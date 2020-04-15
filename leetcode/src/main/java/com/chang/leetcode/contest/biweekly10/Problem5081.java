package com.chang.leetcode.contest.biweekly10;

import java.util.ArrayList;
import java.util.List;

public class Problem5081 {

    public List<Integer> countSteppingNumbers(int low, int high) {
        List<Integer> steppingNumbers = new ArrayList<>();
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            steppingNumbers.add(i);
            if (i >= low && i <= high) {
                numbers.add(i);
            }

            if (i > high) {
                return numbers;
            }
        }

        int pos = 1;
        int end = steppingNumbers.size();
        while (end >= pos) {
            for (int i = pos; i < end; i++) {
                int last = steppingNumbers.get(i) % 10;
                Integer next1 = null;
                Integer next2 = null;
                if (0 == last) {
                    next1 = steppingNumbers.get(i) * 10 + 1;
                    steppingNumbers.add(next1);
                } else if (9 == last) {
                    next1 = steppingNumbers.get(i) * 10 + 8;
                    steppingNumbers.add(next1);
                } else {
                    next1 = steppingNumbers.get(i) * 10 + last - 1;
                    steppingNumbers.add(next1);
                    next2 = steppingNumbers.get(i) * 10 + last + 1;
                    steppingNumbers.add(next2);
                }
                if (null != next1 && next1 >= low) {
                    if (next1 <= high) {
                        numbers.add(next1);
                    } else {
                        return numbers;
                    }
                }
                if (null != next2 && next2 >= low) {
                    if (next2 <= high) {
                        numbers.add(next2);
                    } else {
                        return numbers;
                    }
                }
            }

            pos = end;
            end = steppingNumbers.size();
        }

        return numbers;
    }

    public static void main(String[] args) {
        Problem5081 problem = new Problem5081();
        List<Integer> res = problem.countSteppingNumbers(0, 1000);
    }
}
