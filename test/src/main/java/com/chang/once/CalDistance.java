package com.chang.once;

public class CalDistance {

    public static void problem(double topL, double topR, double downL, double downR, double topV, double downV, double dif, int total) {
        double top = topL + topR;
        double down = downL + downR;
        double angleA = Math.atan(topV / (downL - topL));
        System.out.println("angle A: " + angleA * 180 / Math.PI);

        /* *****************************************
         *  left -> right
         ******************************************/
        System.out.println("从左往右排:");
        // 最长斜边
        double longestHypotenuse = (topV + downV) / Math.sin(angleA);
        // 空缺三角形的底边
        double e = downV / Math.tan(angleA);
        int cnt = 0;
        for (; e > dif * cnt && cnt < total; cnt++) {
            double f = (e - dif * cnt) / Math.cos(angleA);
            System.out.printf("第%d根长度 = %f \n", cnt + 1, longestHypotenuse - f);
        }

        while (cnt < total && cnt * dif <= top) {
            System.out.printf("第%d根长度 = %f \n", cnt + 1, longestHypotenuse);
            cnt++;
        }

        double angleB = Math.atan(topV / (downR - topR));
        double angleC = Math.PI - angleA - angleB;
        double m = 1D / Math.sin(angleC) * Math.sin(angleB);
        double extra = dif * cnt - top;
        while (cnt < total) {
            System.out.printf("第%d根长度 = %f \n", cnt + 1, longestHypotenuse - m * extra);
            extra += dif;
            cnt++;
        }

        /* *****************************************
         *  right -> left
         ******************************************/
        System.out.println();
        System.out.println("从右往左排:");
        cnt = 0;
        longestHypotenuse = (topV + downV) / Math.sin(angleB);
        // 空缺三角形的底边
        e = downV / Math.tan(angleB);
        for (; e > dif * cnt && cnt < total; cnt++) {
            double f = (e - dif * cnt) / Math.cos(angleB);
            System.out.printf("第%d根长度 = %f \n", cnt + 1, longestHypotenuse - f);
        }

        while (cnt < total && cnt * dif <= top) {
            System.out.printf("第%d根长度 = %f \n", cnt + 1, longestHypotenuse);
            cnt++;
        }

        m = 1D / Math.sin(angleC) * Math.sin(angleA);
        extra = cnt * dif - top;
        while (cnt < total) {
            System.out.printf("第%d根长度 = %f \n", cnt + 1, longestHypotenuse - m * extra);
            extra += dif;
            cnt++;
        }


        /* *****************************************
         *  bottom -> up
         ******************************************/
        System.out.println();
        System.out.println("从下往上排:");
        cnt = 0;
        double n = 1 / Math.tan(angleA) + 1 / Math.tan(angleB);
        while (cnt < total && cnt * dif <= downV) {
            System.out.printf("第%d根长度 = %f \n", cnt + 1, down);
            cnt++;
        }

        while (cnt < total) {
            System.out.printf("第%d根长度 = %f \n", cnt + 1, down - n * (cnt * dif - downV));
            cnt++;
        }
    }

    public static void main(String[] args) {
//        System.out.println(Math.toDegrees(Math.atan(1D)));
//        System.out.println(Math.toDegrees(Math.asin(0.5D)));
//        System.out.println(Math.sin(Math.toRadians(30D)));
//        CalDistance.problem(450D, 1650D, 2050D, 1150D, 200D);
        CalDistance.problem(450D, 450D, 1650D, 1450D, 1950D, 1050D, 200D, 7);
    }
}
