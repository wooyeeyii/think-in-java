package com.chang.recaptcha;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Date;
import java.util.List;

public class ReCaptchaService {

    @Autowired
    private ObjectMapper objectMapper;

    private static final HttpClient http;

    static {
        http = HttpClient.newBuilder()
                .connectTimeout(Duration.ofMillis(5000))
                .followRedirects(HttpClient.Redirect.NORMAL)
                .build();
    }

    private String reCaptchaV2Secret = "XXX";

    private String reCaptchaV3Secret = "XXX";

    private final String RECAPTCHA_VERIFY_URL = "https://www.recaptcha.net/recaptcha/api/siteverify";

    private final String RECAPTCHA_V3_RESULT_KEY = "recaptcha:v3:%s";

    private final BigDecimal humanThreshold = new BigDecimal("0.8");

    public boolean verifyReCaptchaV3(String token) {
        SiteVerifyRequest request = new SiteVerifyRequest();
        request.setSecret(reCaptchaV3Secret);
        request.setResponse(token);
        HttpRequest httpRequest;
        SiteVerifyResponse verifyResponse;
        boolean result = false;
        try {
            String uri = RECAPTCHA_VERIFY_URL.concat("?secret=").concat(reCaptchaV3Secret).concat("&response=").concat(token);
            httpRequest = HttpRequest.newBuilder()
                    .uri(URI.create(uri))
                    .POST(HttpRequest.BodyPublishers.noBody()).build();
            String rawResponse = http.send(httpRequest, HttpResponse.BodyHandlers.ofString()).body();
            if (StringUtils.isBlank(rawResponse)) {
                return result;
            }
            verifyResponse = objectMapper.readValue(rawResponse, SiteVerifyResponse.class);
        } catch (InterruptedException | IOException e) {
            System.out.println("query reCaptchaV3 score failed");
            e.printStackTrace();
            return result;
        }
        if (verifyResponse.success) {
            result = verifyResponse.score.compareTo(humanThreshold) > 0;
            // if success, save to redis to avoid recheck when use this token to do sth
//            redis.opsForValue().set(String.format(RECAPTCHA_V3_RESULT_KEY, token), verifyResponse.getAction(), 30, TimeUnit.MINUTES);
        }
        return result;
    }

    public boolean verifyReCaptchaV2(String token) {
        SiteVerifyRequest request = new SiteVerifyRequest();
        request.setSecret(reCaptchaV2Secret);
        request.setResponse(token);
        HttpRequest httpRequest;
        SiteVerifyResponse verifyResponse;
        try {
            String uri = RECAPTCHA_VERIFY_URL.concat("?secret=").concat(reCaptchaV2Secret).concat("&response=").concat(token);
            httpRequest = HttpRequest.newBuilder()
                    .uri(URI.create(uri))
                    .POST(HttpRequest.BodyPublishers.noBody()).build();
            String rawResponse = http.send(httpRequest, HttpResponse.BodyHandlers.ofString()).body();
            if (StringUtils.isBlank(rawResponse)) {
                return false;
            }
            verifyResponse = objectMapper.readValue(rawResponse, SiteVerifyResponse.class);
        } catch (IOException | InterruptedException e) {
            System.out.println("verify reCaptchaV2 response failed");
            e.printStackTrace();
            return false;
        }
        return verifyResponse.success;
    }

    public void verifyAction(String reCaptchaToken, String action) {
        // get token from redis
//        String tokenAction = redis.opsForValue().get(String.format(RECAPTCHA_V3_RESULT_KEY, reCaptchaToken));
        String tokenAction = null;
        if (!StringUtils.isBlank(tokenAction)) {
            if (!action.equals(tokenAction)) {
                throw new IllegalArgumentException("token mismatch");
            }
        } else {
            // verify v2
            if (!verifyReCaptchaV2(reCaptchaToken)) {
                throw new IllegalArgumentException("token mismatch");
            }
        }
    }

    @Data
    @NoArgsConstructor
    public static class SiteVerifyRequest {
        private String secret;
        private String response;
        private String remoteip;
    }

    @Data
    @NoArgsConstructor
    public static class SiteVerifyResponse {
        private BigDecimal score;// 评分0 到 1。1：确认为人类，0：确认为机器人。
        private String hostname; // 请求的地址
        private Boolean success; // 是否验证成功，
        @JsonProperty("challenge_ts")
        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
        private Date challengeTs;
        @JsonProperty("error-codes")
        private List<String> errorCodes;
        private String action;
    }
}
