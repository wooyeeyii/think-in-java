/*
 * 399. Evaluate Division
 *
 * Equations are given in the format A / B = k, where A and B are variables represented as strings,
 * and k is a real number (floating point number). Given some queries, return the answers.
 * If the answer does not exist, return -1.0.
 *
 * Example:
 * Given a / b = 2.0, b / c = 3.0.
 * queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? .
 * return [6.0, 0.5, -1.0, 1.0, -1.0 ].
 *
 * The input is: vector<pair<string, string>> equations, vector<double>& values, vector<pair<string, string>> queries ,
 * where equations.size() == values.size(), and the values are positive. This represents the equations.
 * Return vector<double>.
 *
 * According to the example above:
 * equations = [ ["a", "b"], ["b", "c"] ],
 * values = [2.0, 3.0],
 * queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ].
 *
 * The input is always valid. You may assume that evaluating the queries will result in no division by zero
 * and there is no contradiction.
 */
package com.chang.leetcode;

import java.util.*;

public class Problem399 {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> map = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> pair = equations.get(i);
            if (pair.get(0).equals(pair.get(1))) {
                continue;
            }
            if (map.containsKey(pair.get(0))) {
                map.get(pair.get(0)).put(pair.get(1), values[i]);
            } else {
                Map<String, Double> val = new HashMap<>();
                val.put(pair.get(1), values[i]);
                map.put(pair.get(0), val);
            }
        }

        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> pair = queries.get(i);
            String a = pair.get(0);
            String b = pair.get(1);
            if (a.equals(b)) {
                result[i] = 1;
            } else {
                result[i] = getValue(map, a, b);
                if (result[i] - (-1) < 0.0000001) {
                    result[i] = 1 / getValue(map, b, a);
                }
            }
        }

        return result;
    }

    private double getValue(Map<String, Map<String, Double>> map, String a, String b) {
        return 0;
    }

    public static void main(String[] args) {
        Problem399 problem = new Problem399();
        List<List<String>> equations = new ArrayList<>();
        List<String> l1 = new ArrayList<>();
        l1.add("a");
        l1.add("b");
        equations.add(l1);
        List<String> l2 = new ArrayList<>();
        l2.add("b");
        l2.add("c");
        equations.add(l2);
        double[] values = new double[]{2.0, 3.0};

        List<List<String>> queries = new ArrayList<>();
        List<String> n1 = new ArrayList<>();
        n1.add("a");
        n1.add("c");
        equations.add(n1);
        List<String> n2 = new ArrayList<>();
        n2.add("b");
        n2.add("a");
        equations.add(n2);
        List<String> n3 = new ArrayList<>();
        n3.add("a");
        n3.add("e");
        equations.add(n3);
        List<String> n4 = new ArrayList<>();
        n4.add("a");
        n4.add("a");
        equations.add(n4);
        List<String> n5 = new ArrayList<>();
        n5.add("x");
        n5.add("x");
        equations.add(n5);

        double[] res = problem.calcEquation(equations, values, queries);
        System.out.print("[");
        for (double d : res) {
            System.out.print(d);
            System.out.print(", ");
        }
        System.out.println("]");
    }

}
