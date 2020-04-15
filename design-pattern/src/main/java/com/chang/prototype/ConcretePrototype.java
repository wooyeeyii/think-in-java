package com.chang.prototype;

//����ԭ�ͽ�ɫ
public class ConcretePrototype implements Prototype {

    public Object clone() {
        //
        Prototype prototype = new ConcretePrototype();
        return prototype;
    }

}
