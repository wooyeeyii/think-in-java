package com.chang.once;

public class CalDistance {

    public static void problem(double topH, double downH, double topV, double downV) {
        double gap = (downH - topH) / 2;
        double c = Math.sqrt(topV * topV + gap * gap);
        System.out.println(c);
        double d = (topV + downV) / topV * c;
        System.out.println(d);
        double e = gap / topV * downV;
        System.out.println(e);
        double f = c / topV * downV;
        for (int i = 0; e > 100 * i; i++) {
            double y = f / e * (e - 100 * i);
            System.out.println(d - y);
        }

        double tan = gap / topV;
        double m = tan * 100 * 2;
        System.out.println("h each reduce: " + m);
        for (int i = 0; i < 5; i++) {
            System.out.println(downH - m * i);
        }
    }
}
