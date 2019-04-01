package com.chang.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Problem460 {
    
    private Map<Integer, UseRecord> map = new HashMap<Integer, UseRecord>();
    private Integer capacity = 0;
    
    public Problem460(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        System.out.println("####################  get #########################");
        for(Integer k : map.keySet()) {
            System.out.printf("key: %d, content: ", k);
            (map.get(k)).printContent();
            System.out.println("");
        }
        
        UseRecord useRecord = map.get(key);
        if(null == useRecord) {
            return -1;
        }
        
        Long timeNow = System.currentTimeMillis();
        useRecord.addUseRecord(timeNow);
        return useRecord.getValue();
    }
    
    public void put(int key, int value) {
        if(capacity == 0) {
            return;
        }
        if(map.containsKey(key)) {
            map.get(key).setValue(value);
            return;
        }
        
        if(map.size() >= capacity) {
            Integer minKey = null;
            int minCount = Integer.MAX_VALUE;
            long latestTime = System.currentTimeMillis();
            for(Integer k : map.keySet()) {
                UseRecord record = map.get(k);
                if(record.getUseCount() < minCount) {
                    minCount = record.getUseCount();
                    latestTime = record.getLatestUseTime();
                    minKey = k;
                } else if(record.getUseCount() == minCount && record.getLatestUseTime() < latestTime) {
                    latestTime = record.getLatestUseTime();
                    minKey = k;
                } 
            }
            map.remove(minKey);
        }
        
        UseRecord useRecord = new UseRecord(value);
        map.put(key, useRecord);
        
        System.out.println("####################  put #########################");
        for(Integer k : map.keySet()) {
            System.out.printf("key: %d, content: ", k);
            (map.get(k)).printContent();
            System.out.println("");
        }
    }
    
    class UseRecord {
        private Integer useCount = 0;
        private Long latestUseTime = 0L;
        private Integer value;
        
        public UseRecord(int value) {
            this.value = value;
            latestUseTime = System.currentTimeMillis();
        }
        
        public void setValue(int value) {
            this.value = value;
            latestUseTime = System.currentTimeMillis();
        }
        
        public int getUseCount() {
            return useCount;
        }
        
        public int getValue() {
            return value;
        }
        
        public long getLatestUseTime() {
            return latestUseTime;
        }
        
        public void addUseRecord(long timeNow) {
            useCount++;
            latestUseTime = timeNow;
        }
        
        public void printContent() {
            System.out.printf("value: %d, useCount: %d, latestUseTime: %d", value, useCount, latestUseTime);
        }
    }
    
    
    
    public static void main(String[] args) {
//        Problem460 problem = new Problem460(2);
//        problem.put(2, 1);
//        problem.put(3, 2);
//        System.out.println(problem.get(3));
//        System.out.println(problem.get(2));
//        problem.put(4, 3);
//        System.out.println(problem.get(2));
//        System.out.println(problem.get(3));
//        System.out.println(problem.get(4));
        
        Problem460 problem = new Problem460(2);
        problem.put(3, 1);
        problem.put(2, 1);
        problem.put(2, 2);
        problem.put(4, 4);
        System.out.println(problem.get(2));
        
    }
}
