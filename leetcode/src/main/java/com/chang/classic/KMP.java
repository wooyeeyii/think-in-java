package com.chang.classic;

public class KMP {

    public int algorithm(String source, String pattern) {
        char[] src = source.toCharArray();
        char[] ptn = pattern.toCharArray();
        int[] next = getNext(ptn);

        int i = 0, j = 0;
        while (i < src.length && j < ptn.length) {
            // 如果j = -1,或者当前字符匹配成功(src[i] = ptn[j]),都让i++,j++
            if (j == -1 || src[i] == ptn[j]) {
                i++;
                j++;
            } else {
                // 如果j!=-1且当前字符匹配失败,则令i不变,j=next[j],即让pattern模式串右移j-next[j]个单位
                j = next[j];
            }
        }

        return j == ptn.length ? i - j : -1;
    }

    /*
     * 获取KMP算法中pattern字符串对应的next数组
     */
    protected int[] getNext(char[] p) {
        int pLen = p.length;
        int[] next = new int[pLen];
        int j = 0;
        int k = -1;
        next[0] = -1;
        while (j < pLen - 1) {
            if (k == -1 || p[j] == p[k]) {
                next[++j] = ++k;
            } else {
                k = next[k];
            }
        }
        return next;
    }

    public static void main(String[] args) {
        KMP kmp = new KMP();
        System.out.println(20 == kmp.algorithm("AAAAAAAAAAAAAAAAAAAAABB", "ABB"));
        System.out.println(20 == kmp.algorithm("ABAABBAAAAAAAAAAAAAAABC", "ABC"));
        System.out.println(-1 == kmp.algorithm("ABAABBAAAAAAAAAAAAAAABC", "ABCD"));
    }

}
