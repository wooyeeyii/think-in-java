package com.chang.leetcode.contest.biweekly8;

import java.util.*;

public class Problem5068 {

    public List<String> beforeAndAfterPuzzles(String[] phrases) {
        Set<String> set = new HashSet<>();
        List<String> result = new ArrayList<>();
        if (null == phrases || 0 == phrases.length) {
            return result;
        }

        Map<String, List<IdxString>> map = new HashMap<>();
        for (int i = 0; i < phrases.length; i++) {
            String s = phrases[i];
            String[] sArray = s.split(" ");
            String follow = s.substring(sArray[0].length());
            IdxString value = new IdxString(s, sArray[sArray.length - 1], follow, i);
            if (map.containsKey(sArray[0])) {
                map.get(sArray[0]).add(value);
            } else {
                List<IdxString> newList = new ArrayList<>();
                newList.add(value);
                map.put(sArray[0], newList);
            }
        }

        map.forEach((k, v) -> {
            v.forEach(idxString -> {
                List<IdxString> follows = map.get(idxString.last);
                if (null != follows) {
                    follows.forEach(f -> {
                        if(f.idx != idxString.idx) {
                            set.add(idxString.sOri + f.follow);
                        }
                    });
                }
            });
        });
        result = new ArrayList<>(set);
        Collections.sort(result, (a, b) -> {
            return a.compareTo(b);
        });
        return result;
    }

    class IdxString {
        public String sOri;
        public String last;
        public String follow;
        public int idx;

        public IdxString(String sOri, String word, String follow, int idx) {
            this.sOri = sOri;
            this.last = word;
            this.follow = follow;
            this.idx = idx;
        }
    }

    public static void main(String[] args) {
        Problem5068 problem = new Problem5068();
        String[] phrases1 = new String[]{
                "mission statement",
                "a quick bite to eat",
                "a chip off the old block",
                "chocolate bar",
                "mission impossible",
                "a man on a mission",
                "block party",
                "eat my words",
                "bar of soap"
        };
        List<String> res1 = problem.beforeAndAfterPuzzles(phrases1);

        String[] phrases2 = new String[]{"a", "b", "a"};
        List<String> res2 = problem.beforeAndAfterPuzzles(phrases2);
    }

}
