package com.coursea.part1.unionfind;

import java.util.HashMap;
import java.util.Map;

public class WeighQuickUnion extends QuickUnion {

    protected Map<Integer, Integer> mapCount = new HashMap<Integer, Integer>();

    @Override
    public void union(int p, int q) {
        if (!map.containsKey(q) && map.containsKey(p)) {
            map.put(q, p);
            mapCount.put(q, mapCount.get(p) + 1);
            mapCount.put(p, mapCount.get(p) + 1);
            return;
        }
        if (!map.containsKey(p) && map.containsKey(q)) {
            union(q, p);
            return;
        }
        if (!map.containsKey(p) && !map.containsKey(q)) {
            map.put(p, q);
            map.put(q, -1);
            mapCount.put(p, 2);
            mapCount.put(q, 2);
            return;
        }

        int pRoot = root(p);
        int qRoot = root(q);
        if (pRoot == qRoot) {
            return;
        }
        if (count(pRoot) >= count(qRoot)) {
            map.put(qRoot, pRoot);
            mapCount.put(pRoot, count(pRoot) + count(qRoot));
        } else {
            map.put(pRoot, qRoot);
            mapCount.put(qRoot, count(qRoot) + count(pRoot));
        }
    }

    @Override
    public Integer count(int p) {
        return null == mapCount.get(p) ? 0 : mapCount.get(p);
    }
}
