package com.chang.once;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.StrSubstitutor;
import org.apache.commons.text.StringSubstitutor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Stream;

public class Once {

    public static void main(String[] args) {
        Map<String, String> valuesMap = new HashMap<>();
        valuesMap.put("animal", "quick brown fox");
        valuesMap.put("target", "lazy dog");
        String templateString = "The ${animal} jumped over the ${target}.";

        // Build StringSubstitutor
        StringSubstitutor sub = new StringSubstitutor(valuesMap);

        // Replace
        String resolvedString = sub.replace(templateString);
        System.out.println(resolvedString);

        // +446681800
        String swissNumberStr = "044 668 18 00";
        Phonenumber.PhoneNumber swissNumberProto = null;
        PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
        try {
            swissNumberProto = phoneUtil.parse(swissNumberStr, "CH");
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        System.out.println(phoneUtil.format(swissNumberProto, PhoneNumberUtil.PhoneNumberFormat.E164));

        // b4b41080b39f6da198dcf2e50f6d117e
        System.out.println(DigestUtils.md5Hex("7e0a97f7b9a08cf20c2a7dc75154918f0d7e2d19ac9c33cabf22801596ac789d"));
    }

}





