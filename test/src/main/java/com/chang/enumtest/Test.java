package com.chang.enumtest;

public class Test {
    public static void main(String[] args) {
        DayEnum test = DayEnum.MONDAY;

        System.out.println(test);
        System.out.println(DayEnum.MONDAY);
        System.out.println(test == DayEnum.MONDAY);
        if (test.equals(DayEnum.MONDAY)) {
            System.out.println("equals");
        } else {
            System.out.println("not equal");
        }

        switch (test) {
            case MONDAY:
                System.out.println("case monday");
            default:
                break;
        }
    }
}
