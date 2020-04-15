package com.chang.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class TestClass {
    public static void main(String[] args) throws ClassNotFoundException, Exception {
        /* 一、反射机制获取类的三种方法 */
        //法1: 类名.class
        Class<TestClassType> testTypeClass = TestClassType.class;
        System.out.println("testTypeClass---" + testTypeClass);
        System.out.println("");

        //法2: Class.forName()
        Class<?> testTypeForName = Class.forName("com.chang.reflection.TestClassType");   //packageName.ClassName, otherwise class can't be found
        System.out.println("testForName---" + testTypeForName);
        System.out.println("");

        //法3: Object.getClass()
        TestClassType testGetClass = new TestClassType();
        Class<? extends TestClassType> testTypeGetClass = testGetClass.getClass();
        System.out.println("testTypeGetClass---" + testTypeGetClass);
        System.out.println("");

        /* 二、创建对象：获取类后我们来创建它的对象，利用newInstance： */
        Object obj = testTypeClass.newInstance();    //调用了TestClassType的无参数构造方法.
        System.out.println("");

        //a. 获取类中所有属性
        Field[] fs = testTypeClass.getDeclaredFields();  // 反射获取的类型.get...
        //定义可变长的字符串，用来存储属性
        StringBuffer sb = new StringBuffer();
        //通过追加的方法，将每个属性拼接到此字符串中
        //最外边的public定义
        sb.append(Modifier.toString(testTypeClass.getModifiers()) + " class " + testTypeClass.getSimpleName() + "{\n");
        //里边的每一个属性
        for (Field field : fs) {
            sb.append("\t");//空格
            sb.append(Modifier.toString(field.getModifiers()) + " ");//获得属性的修饰符，例如public，static等等
            sb.append(field.getType().getSimpleName() + " ");//属性的类型的名字
            sb.append(field.getName() + ";\n");//属性的名字+回车
        }
        sb.append("}");
        System.out.println(sb);
        System.out.println("");

        //b. 获取指定属性
        Field fsSpec = testTypeClass.getDeclaredField("intpri");
        //使用反射机制可以打破类的封装性，导致java对象的属性不安全
        fsSpec.setAccessible(true);
        //给obj对象的intpri属性赋值"1001"
        fsSpec.set(obj, 1001);
        System.out.println(fsSpec.get(obj));
        System.out.println("");

        Method reflectMethodbyName = testTypeGetClass.getMethod("Method", int.class, String.class);
        reflectMethodbyName.invoke(obj, 100, "hundred");

    }
} 
  
 
