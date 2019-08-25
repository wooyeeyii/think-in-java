package com.chang.leetcode.contest.weekly151;

import java.util.*;

public class Problem1169 {

    public List<String> invalidTransactions(String[] transactions) {
        Set<String> result = new HashSet<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String t : transactions) {
            String[] info = t.split(",");
            List<String> nameStr = map.getOrDefault(info[0], new ArrayList<>());
            if (Integer.valueOf(info[2]) > 1000) {
                result.add(t);
            }

            nameStr.forEach(s -> {
                String[] sA = s.split(",");
                if (Math.abs(Integer.valueOf(sA[1]) - Integer.valueOf(info[1])) <= 60 &&
                        !sA[3].equals(info[3])) {
                    result.add(t);
                    result.add(s);
                }
            });

            nameStr.add(t);
            map.put(info[0], nameStr);
        }

        return new ArrayList<>(result);
    }

    public static void main(String[] args) {
        Problem1169 problem = new Problem1169();
        // ["alice,20,800,mtv","alice,50,100,beijing"]
        List<String> res1 = problem.invalidTransactions(new String[]{"alice,20,800,mtv", "alice,50,100,beijing"});
        // ["alice,50,1200,mtv"]
        List<String> res2 = problem.invalidTransactions(new String[]{"alice,20,800,mtv", "alice,50,1200,mtv"});
        // ["bob,50,1200,mtv"]
        List<String> res3 = problem.invalidTransactions(new String[]{"alice,20,800,mtv", "bob,50,1200,mtv"});
        // ["bob,689,1910,barcelona","bob,832,1726,barcelona","bob,820,596,bangkok"]
        List<String> res4 = problem.invalidTransactions(new String[]{"bob,689,1910,barcelona", "alex,696,122,bangkok", "bob,832,1726,barcelona", "bob,820,596,bangkok", "chalicefy,217,669,barcelona", "bob,175,221,amsterdam"});
        // ["bob,627,1973,amsterdam","alex,387,885,bangkok","alex,355,1029,barcelona","alex,587,402,bangkok","chalicefy,973,830,barcelona","alex,932,86,bangkok","bob,188,989,amsterdam"]
        List<String> res5 = problem.invalidTransactions(new String[]{"bob,627,1973,amsterdam", "alex,387,885,bangkok", "alex,355,1029,barcelona", "alex,587,402,bangkok", "chalicefy,973,830,barcelona", "alex,932,86,bangkok", "bob,188,989,amsterdam"});

    }
}
