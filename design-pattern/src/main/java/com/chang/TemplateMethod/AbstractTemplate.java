package com.chang.TemplateMethod;

public abstract class AbstractTemplate {

    /**
     * ģ�巽��
     **/
    public void templateMethod() {
        //���û�������
        abstractMethod();
        hookMethod();
        concreteMethod();
    }

    //����������������������ʵ��
    protected abstract void abstractMethod();

    // ���������� �շ���
    protected void hookMethod() {
    }

    // ���������� ��ʵ��
    private void concreteMethod() {
        //ҵ����صĴ���
    }

    ;

}
