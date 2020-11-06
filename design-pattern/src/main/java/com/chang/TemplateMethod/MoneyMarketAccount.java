package com.chang.TemplateMethod;

public class MoneyMarketAccount extends Account {

    @Override
    protected double doCalculateInterestRate() {
        return 0.045;
    }

    @Override
    protected String doCalculateAccountType() {
        return "Money Market";
    }
}
