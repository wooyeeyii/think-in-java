package com.coursea.part1.unionfind;

public interface UnionFind {

    /**
     * add the connection
     */
    public void union(int p, int q);

    /**
     * wether p and q connect
     */
    public boolean connected(int p, int q);

    public Integer find(int p);

    /**
     * number of components
     */
    public Integer count(int p);
}
