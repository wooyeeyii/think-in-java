package com.coursea.part1.unionfind;

import org.junit.Assert;
import org.junit.Test;

public class UnionFindTest {

    @Test
    public void quickFindTest() {
        UnionFind quickFind = new QuickFind();
        testData1(quickFind);
    }

    @Test
    public void quickUnionTest() {
        UnionFind quickUnion = new QuickUnion();
        testData1(quickUnion);
    }

    @Test
    public void weighQuickUnionTest() {
        UnionFind weighQuickUnion = new WeighQuickUnion();
        testData1(weighQuickUnion);
    }

    @Test
    public void improveWeighQuickUnion() {
        UnionFind improveWeighQuickUnion = new ImproveWeighQuickUnion();
        testData1(improveWeighQuickUnion);
    }


    private void testData1(UnionFind unionFind) {
        unionFind.union(4, 3);
        unionFind.union(3, 8);
        unionFind.union(6, 5);
        unionFind.union(9, 4);
        unionFind.union(2, 1);
        unionFind.union(5, 0);
        unionFind.union(7, 2);
        Assert.assertEquals(null, unionFind.find(100));
        Assert.assertEquals(true, unionFind.connected(1, 7));
        Assert.assertEquals(true, unionFind.connected(8, 9));
        Assert.assertEquals(true, unionFind.connected(5, 6));
        Assert.assertEquals(false, unionFind.connected(7, 4));
        Assert.assertEquals(false, unionFind.connected(5, 8));
        Assert.assertEquals(false, unionFind.connected(0, 1));
        unionFind.union(6, 1);
        unionFind.union(7, 3);
        Assert.assertEquals(true, unionFind.connected(7, 4));
        Assert.assertEquals(true, unionFind.connected(5, 8));
        Assert.assertEquals(true, unionFind.connected(0, 1));
    }
}