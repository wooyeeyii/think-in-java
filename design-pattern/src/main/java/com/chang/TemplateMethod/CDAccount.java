package com.chang.TemplateMethod;

public class CDAccount extends Account {

    @Override
    protected double doCalculateInterestRate() {
        return 0.06;
    }

    @Override
    protected String doCalculateAccountType() {
        return "Cretificate of Deposite";
    }

}
