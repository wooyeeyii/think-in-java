package com.chang.md5;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Test {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("zzz");
        list.add("aaa");
        list.add("ppp");
        List<PackageData> packageDataList = new ArrayList<>();

        PackageData pack0 = PackageData.builder()
                .id(0L)
                .name("pack")
                .number(0)
                .build();


        PackageData pack1 = PackageData.builder()
                .id(1111L)
                .name("pack")
                .number(11)
                .build();
        packageDataList.add(pack1);
        PackageData pack2 = PackageData.builder()
                .id(2222L)
                .name("pack")
                .number(22)
                .build();
        packageDataList.add(pack2);

        Result result = Result.builder()
                .id(null)
                .list(list)
                .name("name")
                .number(100)
                .packageData(pack0)
                .packageDataList(packageDataList)
                .build();
        String raw = result.toString();
        System.out.println(raw);
        JSONObject jsonObject = (JSONObject) JSONObject.toJSON(result);
        System.out.println(jsonObject.toJSONString());
        String preHandleStr = preprocess(jsonObject, System.currentTimeMillis());
        System.out.println(preHandleStr);

        String sign = MD5Util.MD5Encode(preHandleStr, "UTF-8").toUpperCase();
        System.out.println(sign);
    }

    public static String preprocess(JSONObject result, Long timestamp) {
        String res = null;
        try {
            if (null == result) {
                result = new JSONObject();
            }
            result.put("timestamp", timestamp);
            res = recursiveToString(result);
        } catch (Exception var8) {
            var8.printStackTrace();
        }

        return res;
    }

    static String recursiveToString(Object obj) {
        String str = "";
        if (null != obj) {
            if (obj instanceof JSONObject) {
                JSONObject jsonObj = (JSONObject) obj;
                Map<Object, Object> value = new TreeMap<>(jsonObj);
                for (Map.Entry<?, ?> entry : value.entrySet()) {
                    if (null != entry.getValue()) {
                        str = str + entry.getKey() + recursiveToString(entry.getValue());
                    } else {
                        str += entry.getKey();
                    }
                }
            } else if (obj instanceof JSONArray) {
                JSONArray jsonArray = (JSONArray) obj;
                int idx = 0;
                for (Object o : jsonArray) {
                    str = str + idx++ + recursiveToString(o);
                }
            } else {
                str += String.valueOf(obj);
            }
        }
        return str;
    }

}