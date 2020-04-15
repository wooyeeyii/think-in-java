package com.chang.once;

public class ChangableParam {


    public static void main(String[] args) {
        ChangableParam changableParam = new ChangableParam();
        changableParam.mulParam('a', 100, 1, 2, 3, 4, 5, 6, 7);
    }


    public void mulParam(char a, int b, int... args) {
        System.out.println(a);
        System.out.println(b);
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }

    }


}
