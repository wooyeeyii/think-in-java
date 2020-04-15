package com.chang.once;


import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializeConfig;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Once {

    public static void main(String[] args) {
        C c = new C();
        c.set__v(1L);
        JSONObject jsonObject = (JSONObject) JSONObject.toJSON(c, new SerializeConfig(true));
        System.out.println(jsonObject.toJSONString());
    }



}





