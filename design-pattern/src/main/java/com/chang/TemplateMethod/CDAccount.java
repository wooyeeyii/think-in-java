package com.chang.TemplateMethod;

public class CDAccount extends Account {

    @Override
    protected double doCalculateInterestRate() {
        // TODO Auto-generated method stub
        return 0.06;
    }

    @Override
    protected String doCalculateAccountType() {
        // TODO Auto-generated method stub
        return "Cretificate of Deposite";
    }

}
