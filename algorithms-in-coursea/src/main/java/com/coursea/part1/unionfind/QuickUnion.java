package com.coursea.part1.unionfind;

import java.util.HashMap;
import java.util.Map;

public class QuickUnion implements UnionFind {

    protected Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    @Override
    public void union(int p, int q) {
        if (!map.containsKey(q)) {
            map.put(q, -1);
            map.put(p, q);
        } else {
            int qValue = map.get(q).equals(-1) ? q : map.get(q);
            if (!map.containsKey(p)) {
                map.put(p, qValue);
            } else {
                int pRoot = root(p);
                map.put(pRoot, qValue);
            }
        }
    }

    @Override
    public boolean connected(int p, int q) {
        p = root(p);
        q = root(q);
        if (null == map.get(p) || null == map.get(q)) {
            return false;
        }
        int pValue = map.get(p).equals(-1) ? p : map.get(p);
        int qValue = map.get(q).equals(-1) ? q : map.get(q);
        return pValue == qValue;
    }

    protected Integer root(int p) {
        while (map.containsKey(p) && !map.get(p).equals(-1)) {
            p = map.get(p);
        }
        if (!map.containsKey(p)) {
            System.out.println("key p: " + p + " is not exist");
            return null;
        }
        return p;
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
