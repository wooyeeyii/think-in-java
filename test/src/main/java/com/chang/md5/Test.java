package com.chang.md5;

public class Test {

    public static void main(String[] args) {

        String sb = "appid=wx122a174956f794cf&nonceStr=Aljst4IGwg8b7xh9&signType=MD5&timeStamp=1503911354&package=prepay_id=wx201708281706499e5c74076a0310548213&key=0a68e488932b15a1d8748922490ca5d0";
        String sb1 = "appid=wx122a174956f794cf&nonceStr=Aljst4IGwg8b7xh9&package=prepay_id&signType=MD5&timeStamp=1503911354&key=0a68e488932b15a1d8748922490ca5d0";
        String sign = MD5Util.MD5Encode(sb1, "UTF-8").toUpperCase();
        System.out.println(sign);
    }

}