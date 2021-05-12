package com.chang.once;

public class CalDistance {

    public static void problem(double topH, double downH, double topV, double downV, double dif) {
        double angleA = Math.atan(topV / (downH - topH));
        System.out.println("angle A: " + angleA);
        double gap = downH - topH;
        double c = topV / Math.sin(angleA);
        double d = (topV + downV) / Math.sin(angleA);
        double e = downV / Math.tan(angleA);
        for (int i = 0; e > dif * i; i++) {
            double f = (e - dif * i) / Math.cos(angleA);
            System.out.println(d - f);
        }
        System.out.println("max: " + d);

        double angleB = Math.atan(topV / 1200D);
        System.out.println("angle B: " + angleB);
        double angleC = Math.PI - angleA - angleB;
        double m = 100D / Math.sin(angleC) * Math.sin(angleB);
        System.out.println("m: " + m);
        System.out.println(d - m);
        System.out.println(d - 3 * m);
        System.out.println(d - 5 * m);
        System.out.println(d - 7 * m);

        double n =  1 / Math.tan(angleA) + Math.tan(angleB);
        System.out.println("up 1 each reduce: " + n);
        System.out.println(1650D + 1450D);
        for (int i = 0; i < 5; i++) {
            System.out.println(1650D + 1450D - 50 * n - i * 200 * n);
        }
    }

    public static void main(String[] args) {
//        System.out.println(Math.toDegrees(Math.atan(1D)));
//        System.out.println(Math.toDegrees(Math.asin(0.5D)));
//        System.out.println(Math.sin(Math.toRadians(30D)));
//        CalDistance.problem(450D, 1650D, 2050D, 1150D, 200D);
        CalDistance.problem(450D, 1450D, 2050D, 1150D, 200D);
    }

}
