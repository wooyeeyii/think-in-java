/*
 * 1169. Invalid Transactions
 * 
 * A transaction is possibly invalid if:
 * 
 * the amount exceeds $1000, or;
 * if it occurs within (and including) 60 minutes of another transaction with the same name in a different city.
 * Each transaction string transactions[i] consists of comma separated values representing the name, time (in minutes), amount, and city of the transaction.
 * 
 * Given a list of transactions, return a list of transactions that are possibly invalid.  You may return the answer in any order.
 * 
 * Example 1:
 * Input: transactions = ["alice,20,800,mtv","alice,50,100,beijing"]
 * Output: ["alice,20,800,mtv","alice,50,100,beijing"]
 * Explanation: The first transaction is invalid because the second transaction occurs within a difference of 60 minutes,
 * have the same name and is in a different city. Similarly the second one is invalid too.
 * 
 * Example 2:
 * Input: transactions = ["alice,20,800,mtv","alice,50,1200,mtv"]
 * Output: ["alice,50,1200,mtv"]
 * 
 * Example 3:
 * Input: transactions = ["alice,20,800,mtv","bob,50,1200,mtv"]
 * Output: ["bob,50,1200,mtv"]
 * 
 * 
 * Constraints:
 * transactions.length <= 1000
 * Each transactions[i] takes the form "{name},{time},{amount},{city}"
 * Each {name} and {city} consist of lowercase English letters, and have lengths between 1 and 10.
 * Each {time} consist of digits, and represent an integer between 0 and 1000.
 * Each {amount} consist of digits, and represent an integer between 0 and 2000.
 */
package com.chang.leetcode.contest.weekly151;

import java.util.*;

public class Problem1169 {

    public List<String> invalidTransactionsSlow(String[] transactions) {
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
        //
        List<String> res5 = problem.invalidTransactions(new String[]{"bob,627,1973,amsterdam", "alex,387,885,bangkok", "alex,355,1029,barcelona", "alex,587,402,bangkok", "chalicefy,973,830,barcelona", "alex,932,86,bangkok", "bob,188,989,amsterdam"});
    }

    public List<String> invalidTransactions(String[] transactions) {
        List<String> result = new ArrayList<>();
        Map<String, List<Trans>> map = new HashMap<>();
        for (String t : transactions) {
            Trans trans = Trans.fromString(t);
            List<Trans> TransList = map.getOrDefault(trans.name, new ArrayList<>());
            TransList.add(trans);
            map.put(trans.name, TransList);
        }
        map.forEach((k, v) -> {
            v.forEach(x -> {
                if (x.money > 1000 || hasConflict(x, v))
                    result.add(x.orig);
            });
        });

        return result;
    }

    private boolean hasConflict(Trans x, List<Trans> v) {
        for (Trans y : v) {
            if (x == y)
                continue;
            if (x.name.equals(y.name) && !x.city.equals(y.city) && Math.abs(x.time - y.time) <= 60)
                return true;
        }
        return false;
    }

    private static class Trans {
        public String name, city, orig;
        public int time, money;

        public static Trans fromString(String s) {
            String[] parts = s.split(",");
            Trans t = new Trans();
            t.name = parts[0];
            t.time = Integer.parseInt(parts[1]);
            t.money = Integer.parseInt(parts[2]);
            t.city = parts[3];
            t.orig = s;
            return t;
        }

    }

}
