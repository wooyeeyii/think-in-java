package com.chang.prototype.example.sage;

import java.io.IOException;

/**
 * ǳ��¡�����¡
 *
 * @author junjie.chang
 */
public class TheGreatestSage {

    private Monkey monkey = new Monkey();

    public void change() {
        //��¡��ʥ����
        Monkey copyMonkey = (Monkey) monkey.clone();
        System.out.println("��ʥ����������ǣ�" + monkey.getBirthDate());
        System.out.println("��¡�Ĵ�ʥ�������ǣ�" + copyMonkey.getBirthDate());
        System.out.println("��ʥ�������¡�Ĵ�ʥ�Ƿ�Ϊͬһ������ " + (monkey == copyMonkey));
        System.out.println("��ʥ��������ն��� �� ��¡�Ĵ�ʥ�����ն����Ƿ�Ϊͬһ������" + (monkey.getBirthDate() == copyMonkey.getBirthDate()));
        System.out.println("��ʥ������еĽ𹿰� �� ��¡�Ĵ�ʥ���еĽ𹿰��Ƿ�Ϊͬһ������ " + (monkey.getStaff() == copyMonkey.getStaff()));
    }

    public void deepChange() {
        Monkey copyMonkey = null;
        try {
            copyMonkey = (Monkey) monkey.deepClone();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        System.out.println("��ʥ����������ǣ�" + monkey.getBirthDate());
        System.out.println("��¡�Ĵ�ʥ�������ǣ�" + copyMonkey.getBirthDate());
        System.out.println("��ʥ�������¡�Ĵ�ʥ�Ƿ�Ϊͬһ������ " + (monkey == copyMonkey));
        System.out.println("��ʥ��������ն��� �� ��¡�Ĵ�ʥ�����ն����Ƿ�Ϊͬһ������" + (monkey.getBirthDate() == copyMonkey.getBirthDate()));
        System.out.println("��ʥ������еĽ𹿰� �� ��¡�Ĵ�ʥ���еĽ𹿰��Ƿ�Ϊͬһ������ " + (monkey.getStaff() == copyMonkey.getStaff()));
    }


    public static void main(String[] args) {
        TheGreatestSage sage = new TheGreatestSage();
        System.out.println("-----------------ǳ��¡-------------------");
        sage.change();
        System.out.println("-----------------���¡-------------------");
        sage.deepChange();
    }
}
