package com.chang.TemplateMethod;

public class MoneyMarketAccount extends Account {

    @Override
    protected double doCalculateInterestRate() {
        // TODO Auto-generated method stub
        return 0.045;
    }

    @Override
    protected String doCalculateAccountType() {
        // TODO Auto-generated method stub
        return "Money Market";
    }
}
