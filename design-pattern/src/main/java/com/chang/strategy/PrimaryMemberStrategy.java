package com.chang.strategy;

public class PrimaryMemberStrategy implements MemberStrategy {

    @Override
    public double calPrice(double booksPrice) {
        
        System.out.println("对于初级会员的没有折扣");
        return booksPrice;
    }

}
