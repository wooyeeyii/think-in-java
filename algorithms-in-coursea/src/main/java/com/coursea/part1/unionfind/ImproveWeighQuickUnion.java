package com.coursea.part1.unionfind;

public class ImproveWeighQuickUnion extends WeighQuickUnion {

    @Override
    public void union(int p, int q) {
        if(!map.containsKey(q) && map.containsKey(p)) {
            map.put(q, p);
            mapCount.put(q, 0);
            mapCount.put(p, mapCount.get(p) + 1);
            return;
        }
        if(!map.containsKey(p) && map.containsKey(q)) {
            union(q, p);
            return;
        }
        if(!map.containsKey(p) && !map.containsKey(q)) {
            map.put(p, q);
            map.put(q, -1);
            mapCount.put(p, 0);
            mapCount.put(q, 1);
            return;
        }

        int pRoot = root(p);
        int qRoot = root(q);
        if(count(pRoot) >= count(qRoot)) {
            map.put(qRoot, pRoot);
            mapCount.put(pRoot, count(pRoot) + count(qRoot) + 1);
            //flat the tree
            if(q != qRoot) {
                map.put(q, pRoot);
                mapCount.put(qRoot, count(qRoot) - count(q) - 1);
            }
        } else {
            map.put(pRoot, qRoot);
            mapCount.put(qRoot, count(qRoot) + count(pRoot) + 1);
        }
    }

}
