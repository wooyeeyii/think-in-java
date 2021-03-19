/*
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
package com.chang.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem380 {

    private List<Integer> list = null;
    private Map<Integer, Integer> map = null;
    java.util.Random rand = new java.util.Random();

    /*
     * Initialize your data structure here.
     */
    public Problem380() {
        list = new ArrayList<Integer>();
        map = new HashMap<Integer, Integer>();
    }

    /*
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        list.add(val);
        map.put(val, list.size() - 1);
        return true;
    }

    /*
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int loc = map.get(val);
        if (loc < list.size() - 1) {
            int lastNum = list.get(list.size() - 1);
            list.set(loc, lastNum);
            map.put(lastNum, loc);
        }
        list.remove(list.size() - 1);
        map.remove(val);
        return true;
    }

    /*
     * Get a random element from the set.
     */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }

}
