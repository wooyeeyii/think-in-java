package com.coursea.part1.unionfind;

import java.util.HashMap;
import java.util.Map;

public class QuickFind implements UnionFind {

    private Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    @Override
    public void union(int p, int q) {
        if(!map.containsKey(q)) {
            map.put(q, -1);
        }

        int value = map.get(q).equals(-1) ? q : map.get(q);
        if(!map.containsKey(p)) {
            map.put(p, value);
        } else {
            Integer f = map.get(p).equals(-1) ? p : map.get(p);
            map.put(p, value);
            for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int entryValue = entry.getValue().equals(-1)? entry.getKey() : entry.getValue();
                if(f.equals(entryValue)) {
                    map.put(entry.getKey(), value);
                }
            }
        }
    }

    @Override
    public boolean connected(int p, int q) {
        if(null == map.get(p) || null == map.get(q)) {
            return false;
        }
        int pValue = map.get(p).equals(-1) ? p : map.get(p);
        int qValue = map.get(q).equals(-1) ? q : map.get(q);
        return pValue == qValue;
    }

    @Override
    public Integer find(int p) {
        return map.get(p);
    }

    @Override
    public Integer count(int p) {
        return 0;
    }
}
