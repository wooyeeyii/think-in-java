package com.chang.leetcode;

import com.chang.common.MapUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem187 {

    /*
     * 法1
     *
     * @param s
     * @return
     */
    public List<String> findRepeatedDnaSequences1(String s) {
        List<String> res = new ArrayList<String>();
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; (i + 9) < s.length(); i++) {
            String sub = s.substring(i, i + 10);
//            int tmp = map.getOrDefault(sub, 0);
            int tmp = MapUtil.getOrDefault(map, sub, 0);
            if (tmp > 0) {
                map.put(sub, tmp + 1);
                if (tmp == 1) {
                    res.add(sub);
                }
            } else {
                map.put(sub, 1);
            }
        }
        return res;
    }

    /*
     * 法2
     */
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<String>();
        if (s == null || s.length() < 10) {
            return res;
        }

        char[] map = new char[255];
        map['A'] = 0;
        map['C'] = 1;
        map['G'] = 2;
        map['T'] = 3;

        int mask = 0xfffff;//20bit,10个字母，每个字母占2bit
        int val = 0;
        char[] schar = s.toCharArray();
        for (int i = 0; i < 9; i++) {
            val = (val << 2) | (map[schar[i]] & 3);
        }

        byte[] record = new byte[1 << 20];
        for (int i = 9; i < schar.length; i++) {
            val = ((val << 2) & mask) | (map[schar[i]] & 3);

            if (record[val] == 1) {
                res.add(s.substring(i - 9, i + 1));
            }
            record[val]++;
        }
        return res;
    }


    public static void main(String[] args) {
        Problem187 problem = new Problem187();
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
//        String s = "AAAAAAAAAAAAAAAAAAAAA";
        System.out.println(problem.findRepeatedDnaSequences(s));
    }

}
