package com.chang.leetcode.contest.weekly159;


import java.util.*;

public class Problem5231 {

    public List<String> removeSubfolders(String[] folder) {
        Set<String> set = new HashSet<>();
        for(String fold: folder) {
            String[] fs = fold.split("[/]");
            String subFs = "";
            boolean sub = false;
            for(int i = 0; i < fs.length; i++) {
                if("".equals(fs[i])) {
                    continue;
                }

                subFs += ("/" + fs[i]);
                if(set.contains(subFs)) {
                    sub = true;
                    break;
                }
            }
            if(!sub) {
                Iterator<String> it = set.iterator();
                while(it.hasNext()) {
                    if(it.next().contains(fold)) {
                        it.remove();
                    }
                }
                set.add(fold);
            }
        }

        return new ArrayList<>(set);
    }

    public static void main(String[] args) {
        Problem5231 problem = new Problem5231();
        // "/a","/c/d","/c/f"
        List<String> list1 = problem.removeSubfolders(new String[] {"/a","/a/b","/c/d","/c/d/e","/c/f"});

        // "/a"
        List<String> list2 = problem.removeSubfolders(new String[] {"/a","/a/b/c","/a/b/d"});

        // "/a/b/c","/a/b/ca","/a/b/d"
        List<String> list3 = problem.removeSubfolders(new String[] {"/a/b/c","/a/b/ca","/a/b/d"});
    }

}
