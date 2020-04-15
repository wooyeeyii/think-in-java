/**
 * 93. Restore IP Addresses
 * <p>
 * Given a string containing only digits, restore it
 * by returning all possible valid IP address combinations.
 * <p>
 * Example:
 * Input: "25525511135"
 * Output: ["255.255.11.135", "255.255.111.35"]
 */
package com.chang.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Problem93 {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<String>();
        int n = s.length();
        restoreDiv(s, 0, 4, new ArrayList<String>(), res);
        return res;
    }

    private void restoreDiv(String s, int index, int left, ArrayList<String> list, List<String> res) {
        if (s.length() == index && left == 0) {
            StringBuilder sb = new StringBuilder();
            list.forEach(str -> sb.append(str).append("."));
            String oneRes = sb.toString();
            res.add(oneRes.substring(0, oneRes.length() - 1));
        } else if (s.length() == index || left == 0) {
            return;
        }
        if (((s.length() - index) < left) || ((s.length() - index) > 3 * left)) {
            return;
        }

        for (int i = 1; i <= 3 && index + i <= s.length(); i++) {
            int next = Integer.valueOf(s.substring(index, index + i));
            if (next > 255 || (i > 1 && "0".equals(s.substring(index, index + 1)))) {
                return;
            }
            list.add(s.substring(index, index + i));
            restoreDiv(s, index + i, left - 1, list, res);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        Problem93 problem = new Problem93();

//        List<String> list1 = problem.restoreIpAddresses("25525511135");
//        // output: ["255.255.11.135", "255.255.111.35"]
//        list1.forEach(s -> System.out.println(s));
//        System.out.println("#################");

        List<String> list2 = problem.restoreIpAddresses("010010");
        // output: ["0.10.0.10","0.100.1.0"]
        list2.forEach(s -> System.out.println(s));
        System.out.println("#################");
    }
}
