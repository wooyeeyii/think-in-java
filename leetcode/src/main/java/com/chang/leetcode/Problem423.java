/**
 * 423. Reconstruct Original Digits from English
 * <p>
 * Given a non-empty string containing an out-of-order English representation of digits 0-9, output the digits in ascending order.
 * <p>
 * Note:
 * Input contains only lowercase English letters.
 * Input is guaranteed to be valid and can be transformed to its original digits.
 * That means invalid inputs such as "abc" or "zerone" are not permitted.
 * Input length is less than 50,000.
 * <p>
 * Example 1:
 * Input: "owoztneoer"
 * Output: "012"
 * <p>
 * Example 2:
 * Input: "fviefuro"
 * Output: "45"
 */
package com.chang.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Problem423 {

    public String originalDigits(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int[] result = new int[10];
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        // zeros
        int zeros = map.getOrDefault('z', 0);
        if (zeros > 0) {
            result[0] = zeros;
            map.put('z', map.get('z') - zeros);
            map.put('e', map.get('e') - zeros);
            map.put('r', map.get('r') - zeros);
            map.put('o', map.get('o') - zeros);
        }
        // twos
        int twos = map.getOrDefault('w', 0);
        if (twos > 0) {
            result[2] = twos;
            map.put('t', map.get('t') - twos);
            map.put('w', map.get('w') - twos);
            map.put('o', map.get('o') - twos);
        }
        // fours
        int fours = map.getOrDefault('u', 0);
        if (fours > 0) {
            result[4] = fours;
            map.put('f', map.get('f') - fours);
            map.put('o', map.get('o') - fours);
            map.put('u', map.get('u') - fours);
            map.put('r', map.get('r') - fours);
        }
        // sixs
        int sixs = map.getOrDefault('x', 0);
        if (sixs > 0) {
            result[6] = sixs;
            map.put('s', map.get('s') - sixs);
            map.put('i', map.get('i') - sixs);
            map.put('x', map.get('x') - sixs);
        }
        // eights
        int eights = map.getOrDefault('g', 0);
        if (eights > 0) {
            result[8] = eights;
            map.put('e', map.get('e') - eights);
            map.put('i', map.get('i') - eights);
            map.put('g', map.get('g') - eights);
            map.put('h', map.get('h') - eights);
            map.put('t', map.get('t') - eights);
        }
        // threes
        int threes = map.getOrDefault('h', 0);
        if (threes > 0) {
            result[3] = threes;
            map.put('t', map.get('t') - threes);
            map.put('h', map.get('h') - threes);
            map.put('r', map.get('r') - threes);
            map.put('e', map.get('e') - 2 * threes);
        }
        // tens
        int tens = map.getOrDefault('t', 0);
        if (tens > 0) {
            result[10] = tens;
            map.put('t', map.get('t') - tens);
            map.put('e', map.get('e') - tens);
            map.put('n', map.get('n') - tens);
        }
        // fives
        int fives = map.getOrDefault('f', 0);
        if (fives > 0) {
            result[5] = fives;
            map.put('f', map.get('f') - fives);
            map.put('i', map.get('i') - fives);
            map.put('v', map.get('v') - fives);
            map.put('e', map.get('e') - fives);
        }
        // sevens
        int sevens = map.getOrDefault('s', 0);
        if (sevens > 0) {
            result[7] = sevens;
            map.put('s', map.get('s') - sevens);
            map.put('e', map.get('e') - 2 * sevens);
            map.put('v', map.get('v') - sevens);
            map.put('n', map.get('n') - sevens);
        }

        result[1] = map.getOrDefault('o', 0);
        result[9] = map.getOrDefault('i', 0);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < result[i]; j++) {
                sb.append(String.valueOf(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Problem423 problem = new Problem423();
        System.out.println("012".equals(problem.originalDigits("owoztneoer")));
        System.out.println("45".equals(problem.originalDigits("fviefuro")));
        System.out.println("2".equals(problem.originalDigits("otw")));
        System.out.println("7".equals(problem.originalDigits("esnve")));
    }

}
