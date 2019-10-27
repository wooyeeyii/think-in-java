/**
 * 1233. Remove Sub-Folders from the Filesystem
 * <p>
 * Given a list of folders, remove all sub-folders in those folders and return in any order the folders after removing.
 * If a folder[i] is located within another folder[j], it is called a sub-folder of it.
 * The format of a path is one or more concatenated strings of the form: / followed by one or more lowercase English letters. For example,
 * /leetcode and /leetcode/problems are valid paths while an empty string and / are not.
 * <p>
 * Example 1:
 * Input: folder = ["/a","/a/b","/c/d","/c/d/e","/c/f"]
 * Output: ["/a","/c/d","/c/f"]
 * Explanation: Folders "/a/b/" is a subfolder of "/a" and "/c/d/e" is inside of folder "/c/d" in our filesystem.
 * <p>
 * Example 2:
 * Input: folder = ["/a","/a/b/c","/a/b/d"]
 * Output: ["/a"]
 * Explanation: Folders "/a/b/c" and "/a/b/d/" will be removed because they are subfolders of "/a".
 * <p>
 * Example 3:
 * Input: folder = ["/a/b/c","/a/b/ca","/a/b/d"]
 * Output: ["/a/b/c","/a/b/ca","/a/b/d"]
 * <p>
 * Constraints:
 * 1 <= folder.length <= 4 * 10^4
 * 2 <= folder[i].length <= 100
 * folder[i] contains only lowercase letters and '/'
 * folder[i] always starts with character '/'
 * Each folder name is unique.
 */
package com.chang.leetcode.contest.weekly159;

import java.util.*;

public class Problem1233 {

    public List<String> removeSubfoldersTooSlow(String[] folder) {
        Set<String> set = new HashSet<>();
        for (String fold : folder) {
            String[] fs = fold.split("[/]");
            String subFs = "";
            boolean sub = false;
            for (int i = 0; i < fs.length; i++) {
                if ("".equals(fs[i])) {
                    continue;
                }

                subFs += ("/" + fs[i]);
                if (set.contains(subFs)) {
                    sub = true;
                    break;
                }
            }
            if (!sub) {
                Iterator<String> it = set.iterator();
                while (it.hasNext()) {
                    if (it.next().contains(fold)) {
                        it.remove();
                    }
                }
                set.add(fold);
            }
        }

        return new ArrayList<>(set);
    }

    public static void main(String[] args) {
        Problem1233 problem = new Problem1233();
        // "/a","/c/d","/c/f"
        List<String> list1 = problem.removeSubfolders(new String[]{"/a", "/a/b", "/c/d", "/c/d/e", "/c/f"});

        // "/a"
        List<String> list2 = problem.removeSubfolders(new String[]{"/a", "/a/b/c", "/a/b/d"});

        // "/a/b/c","/a/b/ca","/a/b/d"
        List<String> list3 = problem.removeSubfolders(new String[]{"/a/b/c", "/a/b/ca", "/a/b/d"});

        List<String> list4 = problem.removeSubfolders(new String[]{"/a/b/c", "/a/b", "/a"});
    }

    public List<String> removeSubfolders(String[] folder) {
        Set<String> st = new HashSet<>();
        for (String f : folder) {
            st.add(f);
        }
        List<String> li = new ArrayList<>();
        for (String f : folder) {
            boolean flag = true;
            int sz = f.length();
            for (int j = 1; j < sz; ++j) {
                if (f.charAt(j) == '/') {
                    String tmp = f.substring(0, j);
                    if (st.contains(tmp)) {
                        flag = false;
                        break;
                    }
                }
            }
            if(flag) {
                li.add(f);
            }
        }
        return li;
    }

}
