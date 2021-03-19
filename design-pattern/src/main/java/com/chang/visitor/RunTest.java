/**
 * 　结构对象会遍历它自己所保存的聚集中的所有节点，在本系统中就是节点NodeA和NodeB。首先NodeA会被访问到，这个访问是由以下的操作组成的：
 * 　　（1）NodeA对象的接受方法accept()被调用，并将VisitorA对象本身传入；
 * 　　（2）NodeA对象反过来调用VisitorA对象的访问方法，并将NodeA对象本身传入；
 * 　　（3）VisitorA对象调用NodeA对象的特有方法operationA()。
 * 　　从而就完成了双重分派过程，接着，NodeB会被访问，这个访问的过程和NodeA被访问的过程是一样的，这里不再叙述。
 *
 * 分析：
 * 第一次分配过程： 对象NodeA或者NodeB传递给参数Node，调用Node的accept()方法，第一次动态分配
 * 第二次分配过程：例如NodeA中的accept方法，参数为接口Visitor，而传入的是实例类VisitorA或者VisitorB类，
 * 方法中使用Visitor的visit(), 第二次动态分配。
 */
/**
 * 分析：
 * 第一次分配过程： 对象NodeA或者NodeB传递给参数Node，调用Node的accept()方法，第一次动态分配
 * 第二次分配过程：例如NodeA中的accept方法，参数为接口Visitor，而传入的是实例类VisitorA或者VisitorB类，
 * 				  方法中使用Visitor的visit(), 第二次动态分配。
 */


package com.chang.visitor;

public class RunTest {

    public static void main(String[] args) {
        //创建一个结构对象
        ObjectStructure os = new ObjectStructure();
        //给结构增加一个节点
        os.add(new NodeA());
        //给结构增加一个节点
        os.add(new NodeB());
        //创建一个访问者
        Visitor visitor = new VisitorA();
        os.action(visitor);
    }

}
