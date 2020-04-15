package com.chang.TemplateMethod;

public class AccountTest {
    public static void main(String[] args) {
        Account account = new MoneyMarketAccount();
        System.out.println("�����г��˺ŵ���Ϣ����Ϊ��" + account.calculateInterest());
        account = new CDAccount();
        System.out.println("�����˺ŵ���Ϣ����Ϊ��" + account.calculateInterest());
    }
}
