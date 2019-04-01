package com.chang.common;

import java.util.Map;

public class MapUtil {

    public static <K, V> V getOrDefault(Map<K, V> map, K k, V vDefault) {
        V v = map.get(k);
        if(v == null) {
            return vDefault;
        }
        return v;
    }
}
