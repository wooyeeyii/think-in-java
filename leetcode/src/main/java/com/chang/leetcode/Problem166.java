package com.chang.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Problem166 {
    public String fractionToDecimal(int numerator, int denominator) {
        if(0 == numerator) {
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        Map<Long, Integer> map = new HashMap<Long, Integer>();
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);
        sb.append((((numerator > 0) ^ (denominator > 0)))? "-" : "");
        
        sb.append(String.valueOf(num / den));
        num %= den;
        if(0 == num) {
            return sb.toString();
        }
        sb.append(".");
        while(0 != num) {
            if(map.containsKey(num)) {
                sb.insert(map.get(num), "(");
                sb.append(")");
                break;
            } else {
                map.put(num, sb.length());
                
                num *= 10;
                sb.append(String.valueOf(num / den));
                num %= den;
            }
        }
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
        Problem166 problem = new Problem166();
        int a = 0;
        int b = -5;
        System.out.println(problem.fractionToDecimal(a, b));
    }
}
