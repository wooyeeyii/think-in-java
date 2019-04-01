package com.chang.leetcode;

import java.util.Arrays;

public class Problem299 {
    
    public String getHint(String secret, String guess) {
        int[] secretArray = new int[10];
        int[] guessArray = new int[10];
        Arrays.fill(secretArray, 0);
        Arrays.fill(guessArray, 0);
        int countA = 0;
        int countB = 0;
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                countA++;
            } else {
                secretArray[secret.charAt(i) - 48]++;
                guessArray[guess.charAt(i) - 48]++;
            }
        }
        for(int j = 0; j < 10; j++) {
            if(secretArray[j] > 0) {
                countB += secretArray[j] > guessArray[j]? guessArray[j] : secretArray[j];
            }
        }
        StringBuilder sb = new StringBuilder().append(countA).append("A").append(countB).append("B");
        return sb.toString();
    }
    
    public static void main(String[] args) {
        Problem299 problem = new Problem299();
        System.out.println(problem.getHint("1807", "7810"));
        System.out.println(problem.getHint("1123", "0111"));
    }

}
