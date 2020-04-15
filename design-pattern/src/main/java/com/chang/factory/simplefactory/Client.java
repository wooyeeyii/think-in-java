package com.chang.factory.simplefactory;

public class Client {
    public static void main(String[] args) {
        //����װ������ʦ����
        ComputerEngineer cf = new ComputerEngineer();
        //�ͻ�ѡ�񲢴�����Ҫʹ�õĲ�Ʒ����
        AbstractFactory af = new IntelFactory();
        //����װ������ʦ�Լ�ѡ��Ĳ�Ʒ����װ������ʦ��װ����
        cf.makeComputer(af);
    }
}
