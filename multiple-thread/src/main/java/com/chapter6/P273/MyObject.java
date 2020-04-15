package com.chapter6.P273;

import java.io.Serializable;

public class MyObject implements Serializable {

    private static final long serialVersionUID = -2864591497826595085L;

    //内部类方式
    private static class MyObjectHandler {
        private static final MyObject myObject = new MyObject();
    }

    private MyObject() {
    }

    public static MyObject getInstance() {
        return MyObjectHandler.myObject;
    }

    //序列化和反序列化得到同一对象的关键所在
/*	protected Object readResolve() throws ObjectStreamException {
		System.out.println("调用了 readResolve 方法! ");
		return MyObjectHandler.myObject;
	}*/

}
