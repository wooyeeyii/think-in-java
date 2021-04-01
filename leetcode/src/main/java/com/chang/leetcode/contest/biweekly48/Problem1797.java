package com.chang.leetcode.contest.biweekly48;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Problem1797 {

    int life;
    private TreeMap<Integer, String> tm = new TreeMap<>();
    private Map<String, Integer> expireTime = new HashMap<>();

    public Problem1797(int timeToLive) {
        this.life = timeToLive;
    }

    public void generate(String tokenId, int currentTime) {
        tm = new TreeMap<>(tm.tailMap(currentTime + 1)); // remove expired tokens
        expireTime.put(tokenId, life + currentTime);
        tm.put(life + currentTime, tokenId);
    }

    public void renew(String tokenId, int currentTime) {
        tm = new TreeMap<>(tm.tailMap(currentTime + 1)); // remove expired tokens
        int expire = expireTime.getOrDefault(tokenId, 1 << 31);
        if (!tm.isEmpty() && expire >= tm.firstKey()) {
            tm.remove(expire);
            tm.put(life + currentTime, tokenId);
            expireTime.put(tokenId, life + currentTime);
        }
    }

    public int countUnexpiredTokens(int currentTime) {
        tm = new TreeMap<>(tm.tailMap(currentTime + 1)); // remove expired tokens
        return tm.size();
    }

}
