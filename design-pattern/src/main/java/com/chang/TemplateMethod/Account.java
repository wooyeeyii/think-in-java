package com.chang.TemplateMethod;

public abstract class Account {
	
	public final double calculateInterest() {
		double interestRate = doCalculateInterestRate();
		String accountType = doCalculateAccountType();
		double amount = calculateAmount(accountType);
		return amount * interestRate;
	}
	
	protected abstract double doCalculateInterestRate();

	protected abstract String doCalculateAccountType();
	
	private double calculateAmount(String accountType){
        /**
         * ʡ����ص�ҵ���߼�
         */
        return 7243.00;
    }

}
