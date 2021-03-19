/*
 * 478. Generate Random Point in a Circle
 * 
 * Given the radius and x-y positions of the center of a circle, write a function randPoint which generates a uniform random point in the circle.
 * 
 * Note:
 * 
 * input and output values are in floating-point.
 * radius and x-y position of the center of the circle is passed into the class constructor.
 * a point on the circumference of the circle is considered to be in the circle.
 * randPoint returns a size 2 array containing x-position and y-position of the random point, in that order.
 * Example 1:
 * Input:
 * ["Solution","randPoint","randPoint","randPoint"]
 * [[1,0,0],[],[],[]]
 * Output: [null,[-0.72939,-0.65505],[-0.78502,-0.28626],[-0.83119,-0.19803]]
 * 
 * Example 2:
 * Input:
 * ["Solution","randPoint","randPoint","randPoint"]
 * [[10,5,-7.5],[],[],[]]
 * Output: [null,[11.52438,-8.33273],[2.46992,-16.21705],[11.13430,-12.42337]]
 * Explanation of Input Syntax:
 * 
 * The input is two lists: the subroutines called and their arguments. Solution's constructor has three arguments,
 * the radius, x-position of the center, and y-position of the center of the circle.
 * randPoint has no arguments. Arguments are always wrapped with a list, even if there aren't any.
 */
package com.chang.leetcode;

import java.math.BigDecimal;

public class Problem478 {

    /*private BigDecimal xCenter;
    private BigDecimal yCenter;
    private BigDecimal radius;*/

    private double radius;
    private double xCenter;
    private double yCenter;

    public Problem478(double radius, double x_center, double y_center) {
        /*this.radius = new BigDecimal(radius);
        this.xCenter = new BigDecimal(x_center);
        this.yCenter = new BigDecimal(y_center);*/

        this.radius = radius;
        this.xCenter = x_center;
        this.yCenter = y_center;
    }

    public double[] randPoint() {
        double len = Math.sqrt(Math.random()) * radius;
        double angle = Math.random() * 2 * Math.PI;
        double x = len * Math.cos(angle);
        double y = len * Math.sin(angle);
        System.out.println(x + ", " + y);
        return new double[]{xCenter + x, yCenter + y};
    }

    // 太烦且不太对
    /*public double[] randPoint() {
        Random r = new Random();
        BigDecimal x = new BigDecimal(r.nextDouble());
        BigDecimal y = bigDecimalSqrt(radius.multiply(radius).subtract(x.multiply(x)));
        int xPos = r.nextInt(1);
        int yPos = r.nextInt(1);
        x = xPos > 0 ? x : x.multiply(new BigDecimal("-1"));
        y = yPos > 0 ? y : y.multiply(new BigDecimal("-1"));
        System.out.println(x + ", " + y);
        return new double[] {(x.add(xCenter)).doubleValue(), (y.add(yCenter)).doubleValue()};
    }

    public static BigDecimal bigDecimalSqrt(BigDecimal num) {
        if(num.compareTo(BigDecimal.ZERO) < 0) {
            return BigDecimal.ZERO;
        }
        BigDecimal x = num.divide(new BigDecimal("2"), MathContext.DECIMAL128);
        while(x.subtract(x = sqrtIteration(x, num)).abs().compareTo(new BigDecimal("0.0000000000000000000001")) > 0);
        return x;
    }

    private static BigDecimal sqrtIteration(BigDecimal x, BigDecimal n) {
        return x.add(n.divide(x, MathContext.DECIMAL128)).divide(new BigDecimal("2"), MathContext.DECIMAL128);
    }*/

    public static void main(String[] args) {
        Problem478 problem1 = new Problem478(1, 0, 0);
        problem1.randPoint();
        problem1.randPoint();
        problem1.randPoint();

        Problem478 problem2 = new Problem478(10, 5, -7.5);
        problem2.randPoint();
        problem2.randPoint();
        problem2.randPoint();

        Problem478 problem3 = new Problem478(0.01, -73839.1, -3289891.3);
        problem3.randPoint();
        problem3.randPoint();
        problem3.randPoint();
    }
}

/*
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(radius, x_center, y_center);
 * double[] param_1 = obj.randPoint();
 */