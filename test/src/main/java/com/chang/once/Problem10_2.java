/*
 * 剑指offer 10-2： frog hump
 *
 * 常俊杰
 * 420381199106240031
 * 2021/03/15
 */
package com.chang.once;

public class Problem10_2 {

    // f(n) = f(n - 1) + f(n - 2)
    public int jump(int n) {
        if (1 >= n) {
            return n;
        }

        if (2 == n) {
            return 2;
        }

        int a = 1, b = 2, c = 0;
        for (int i = 3; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    public static void main(String[] args) {
        Problem10_2 problem = new Problem10_2();
        System.out.println(problem.jump(0));
        System.out.println(problem.jump(1));
        System.out.println(problem.jump(2));
        System.out.println(problem.jump(3));
        System.out.println(problem.jump(4));
        System.out.println(problem.jump(5));
    }

}
