/*
 * 1656. Design an Ordered Stream
 */
package com.chang.leetcode.contest.weekly215;

import java.util.ArrayList;
import java.util.List;

public class Problem1656 {

    private int N;
    private String[] data;
    private int ptr = 1;

    public Problem1656(int n) {
        N = n;
        data = new String[n + 1];
    }

    public List<String> insert(int id, String value) {
        List<String> result = new ArrayList<>();
        data[id] = value;

        if (id != ptr || null == data[id]) {
            return result;
        }

        result.add(value);
        id++;
        while (id <= N && null != data[id]) {
            result.add(data[id]);
            id++;
        }

        ptr = id;
        return result;
    }

}
