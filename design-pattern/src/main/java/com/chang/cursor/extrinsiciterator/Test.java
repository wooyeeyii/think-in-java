package com.chang.cursor.extrinsiciterator;

public class Test {

    public void operation(){
        Object[] objArray = {"One","Two","Three","Four","Five","Six"};
        //创建聚合对象
        Aggregate agg = new ConcreteAggregate(objArray);
        //循环输出聚合对象中的值
        MyIterator it = agg.createIterator();
        while(!it.isDone()){
            System.out.println(it.currentItem());
            it.next();
        }
    }
    
    public static void main(String[] args) {
        Test test = new Test();
        test.operation();
    }

}
