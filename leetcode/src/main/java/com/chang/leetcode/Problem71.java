/*
 * 71. Simplify Path
 * 
 * Given an absolute path for a file (Unix-style), simplify it.
 * Or in other words, convert it to the canonical path.
 * In a UNIX-style file system, a period . refers to the current directory.
 * Furthermore, a double period .. moves the directory up a level.
 * For more information, see: Absolute path vs relative path in Linux/Unix
 * 
 * Note that the returned canonical path must always begin with a slash /,
 * and there must be only a single slash / between two directory names.
 * The last directory name (if it exists) must not end with a trailing /.
 * Also, the canonical path must be the shortest string representing
 * the absolute path.
 * 
 * Example 1:
 * Input: "/home/"
 * Output: "/home"
 * Explanation: Note that there is no trailing slash after the last directory name.
 * 
 * Example 2:
 * Input: "/../"
 * Output: "/"
 * Explanation: Going one level up from the root directory is a no-op, as the root level is the highest level you can go.
 * 
 * Example 3:
 * Input: "/home//foo/"
 * Output: "/home/foo"
 * Explanation: In the canonical path, multiple consecutive slashes are replaced by a single one.
 * 
 * Example 4:
 * Input: "/a/./b/../../c/"
 * Output: "/c"
 * 
 * Example 5:
 * Input: "/a/../../b/../c//.//"
 * Output: "/c"
 * 
 * Example 6:
 * Input: "/a//b////c/d//././/.."
 * Output: "/a/b/c"
 */
package com.chang.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem71 {
    public String simplifyPath(String path) {
        List<String> list = new ArrayList<String>();
        int i = 0;
        while (i < path.length()) {
            while (i < path.length() && path.charAt(i) == '/') {
                i++;
            }
            int start = i;
            while (i < path.length() && path.charAt(i) != '/') {
                i++;
            }
            int end = i;
            if (end > start) {
                list.add(path.substring(start, end));
            }
        }

        for (int j = 0; j < list.size(); ) {
            if (".".equals(list.get(j))) {
                list.remove(j);
            } else if ("..".equals(list.get(j))) {
                list.remove(j);
                if (j - 1 >= 0) {
                    list.remove(j - 1);
                    j--;
                }
            } else {
                j++;
            }
        }

        if (0 != list.size()) {
            StringBuilder sb = new StringBuilder();
            list.forEach(s -> sb.append("/").append(s));
            return sb.toString();
        }
        return "/";
    }

    public static void main(String[] args) {
        Problem71 problem = new Problem71();
        String str1 = "/home/";
        String res1 = "/home";
        System.out.println(res1.equals(problem.simplifyPath(str1)));
        String str2 = "/../";
        String res2 = "/";
        System.out.println(res2.equals(problem.simplifyPath(str2)));
        String str3 = "/home//foo/";
        String res3 = "/home/foo";
        System.out.println(res3.equals(problem.simplifyPath(str3)));
        String str4 = "/a/./b/../../c/";
        String res4 = "/c";
        System.out.println(res4.equals(problem.simplifyPath(str4)));
        String str5 = "/a/../../b/../c//.//";
        String res5 = "/c";
        System.out.println(res5.equals(problem.simplifyPath(str5)));
        String str6 = "/a//b////c/d//././/..";
        String res6 = "/a/b/c";
        System.out.println(res6.equals(problem.simplifyPath(str6)));
    }

    public String simplifyPathExample(String path) {
        String[] strs = path.split("/");
        String[] stack = new String[strs.length];
        int cur = 0;
        for (String str : strs) {
            switch (str) {
                case "..":
                    cur = Math.max(cur - 1, 0);
                    break;
                case "":
                case ".":
                    break;
                default:
                    stack[cur] = str;
                    cur++;
                    break;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cur; i++)
            sb.append("/").append(stack[i]);
        String s = sb.toString();
        return s.length() == 0 ? "/" : s;
    }

}
