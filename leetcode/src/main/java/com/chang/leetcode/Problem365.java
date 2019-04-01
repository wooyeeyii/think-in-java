package com.chang.leetcode;

public class Problem365 {
    
    public boolean canMeasureWater(int x, int y, int z) {
        //limit brought by the statement that water is finallly in one or both buckets
        if(x + y < z) return false;
        //case x or y is zero
        if( x == z || y == z || x + y == z ) return true;
        
        //get GCD, then we can use the property of Bézout's identity
        return z%GCD(x, y) == 0;
    }

//    public int GCD(int a, int b){
//        while(b != 0 ){
//            int temp = b;
//            b = a%b;
//            a = temp;
//        }
//        return a;
//    }
    
    public int GCD(int x, int y) {
        return y == 0 ? x : GCD(y, x % y);
    }
    
    public static void main(String[] args) {
        Problem365 problem = new Problem365();
        System.out.println(problem.canMeasureWater(1, 2, 4));
        System.out.println(problem.canMeasureWater(4, 6, 8));
        System.out.println(problem.canMeasureWater(34, 5, 6));
        
    }
}
