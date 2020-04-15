package com.chang.strategy;

public class Price {
    //持有一个具体策略的对象
    private MemberStrategy strategy;

    /**
     * 构造函数，传入一个具体策略对象
     *
     * @param strategy 具体策略对象
     */
    public Price(MemberStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * 策略方法
     */
    public double quote(double pay) {
        return strategy.calPrice(pay);
    }

}

