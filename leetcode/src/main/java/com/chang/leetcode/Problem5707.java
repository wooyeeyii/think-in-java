package com.chang.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Problem5707 {

    public static void main(String[] args) {
        Problem5707 problem = new Problem5707();
        System.out.println(problem.maxHappyGroups(3, new int[]{1, 2, 3, 4, 5, 6}));
        System.out.println(problem.maxHappyGroups(4, new int[]{1, 3, 2, 5, 2, 2, 1, 6}));
        System.out.println(problem.maxHappyGroups(7, new int[]{287773481, 815094798, 356732984, 644469322,
                543193620, 903158817, 274116865, 395252956, 363839119, 365378492, 122313059, 312690039, 252532812}));
    }

    public int maxHappyGroups(int batchSize, int[] groups) {
        int n = groups.length;
        int[] cnt = new int[batchSize];
        int res = 0;
        int remgroup = 0;
        for (int i = 0; i < n; i++) {
            int gr = groups[i] % batchSize;
            cnt[gr]++;
            //this the remaining number of groups needs to be processed
            if (gr != 0) remgroup++;
        }
        //Remainder 0 groups are directly added to the result
        res += cnt[0];
        res += dfs(0, cnt, remgroup, new HashMap<>());
        return (res);
    }

    public int dfs(int curr, int[] cnt, int remgroup, Map<String, Integer> memo) {
        int n = cnt.length;
        //no more group needs to be processed
        if (remgroup == 0) return 0;
        //key for memo
        String key = curr + Arrays.toString(cnt);
        if (memo.containsKey(key)) return (memo.get(key));
        int res = 0;
        //starting a new batch, current group is happy
        if (curr == 0) {
            res++;
            curr = n;
        }
        int val = 0;
        //starting from remainder 1 group
        for (int i = 1; i < n; i++) {
            //remainder of i, cnt is 0
            if (cnt[i] == 0) continue;
            cnt[i]--;
            //number of remaining group - 1
            int currem = remgroup - 1;
            //how much left in the batch
            int nextcurr = curr - i;
            // not enough, add n (this was my bug during the contest)
            if (nextcurr < 0) nextcurr += n;
            val = Math.max(val, dfs(nextcurr, cnt, currem, memo));
            cnt[i]++;
        }
        res += val;
        memo.put(key, res);
        return (res);
    }

}
