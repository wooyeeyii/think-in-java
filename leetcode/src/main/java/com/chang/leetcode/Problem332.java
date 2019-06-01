/**
 * 332. Reconstruct Itinerary
 *
 * Given a list of airline tickets represented by pairs of departure and arrival airports [from, to],
 * reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK.
 * Thus, the itinerary must begin with JFK.
 *
 * Note:
 *     If there are multiple valid itineraries, you should return the itinerary
 *     that has the smallest lexical order when read as a single string. For example,
 *     the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
 *     All airports are represented by three capital letters (IATA code).
 *     You may assume all tickets form at least one valid itinerary.
 *
 * Example 1:
 * Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
 * Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]
 *
 * Example 2:
 * Input: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 * Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
 * Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"].
 *              But it is larger in lexical order.
 */
package com.chang.leetcode;

import java.util.*;

public class Problem332 {

    private  Map<String, Queue<String>> map = new HashMap<>();
    private List<String> res = new ArrayList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        if(null == tickets || 0 == tickets.size()) {
            return res;
        }
        tickets.forEach(list ->{
            String from = list.get(0);
            String to = list.get(1);
            if(map.containsKey(from)) {
                map.get(from).add(to);
            } else {
                Queue<String> que = new PriorityQueue<>();
                que.add(to);
                map.put(from, que);
            }
        });

        String key = "JFK";
        findRec(key);
        return res;
    }

    private void findRec(String key) {
        Queue<String> que = map.get(key);
        while(null != que && 0 != que.size()) {
            String dst = que.poll();
            findRec(dst);
        }
        res.add(0, key);
    }

    public static void main(String[] args) {
        Problem332 problem = new Problem332();

        /* List<List<String>> tickets1 = new ArrayList<>();
        List<String> t1 = new ArrayList<>();
        t1.add("MUC");
        t1.add("LHR");
        tickets1.add(t1);
        List<String> t2 = new ArrayList<>();
        t2.add("JFK");
        t2.add("MUC");
        tickets1.add(t2);
        List<String> t3 = new ArrayList<>();
        t3.add("SFO");
        t3.add("SJC");
        tickets1.add(t3);
        List<String> t4 = new ArrayList<>();
        t4.add("LHR");
        t4.add("SFO");
        tickets1.add(t4);
        List<String> res1 = problem.findItinerary(tickets1);
        printList(res1);*/

        List<List<String>> tickets2 = new ArrayList<>();
        List<String> m1 = new ArrayList<>();
        m1.add("JFK");
        m1.add("SFO");
        tickets2.add(m1);
        List<String> m2 = new ArrayList<>();
        m2.add("JFK");
        m2.add("ATL");
        tickets2.add(m2);
        List<String> m3 = new ArrayList<>();
        m3.add("SFO");
        m3.add("ATL");
        tickets2.add(m3);
        List<String> m4 = new ArrayList<>();
        m4.add("ATL");
        m4.add("JFK");
        tickets2.add(m4);
        List<String> m5 = new ArrayList<>();
        m5.add("ATL");
        m5.add("SFO");
        tickets2.add(m5);
        List<String> res2 = problem.findItinerary(tickets2);
        printList(res2);
        
    }
    
    private static void printList(List<String> list) {
        list.forEach(l -> {
            System.out.print(l);
            System.out.print(" ");
        });
        System.out.println();
        System.out.println("######################");
    }
}
