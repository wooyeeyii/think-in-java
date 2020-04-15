package com.chang.cursor.extrinsiciterator;

public class Test {

    public void operation() {
        Object[] objArray = {"One", "Two", "Three", "Four", "Five", "Six"};
        //�����ۺ϶���
        Aggregate agg = new ConcreteAggregate(objArray);
        //ѭ������ۺ϶����е�ֵ
        MyIterator it = agg.createIterator();
        while (!it.isDone()) {
            System.out.println(it.currentItem());
            it.next();
        }
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.operation();
    }

}
