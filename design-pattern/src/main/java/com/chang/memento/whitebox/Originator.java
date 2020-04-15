/**
 * 发起人角色类，发起人角色利用一个新创建的备忘录对象将自己的内部状态存储起来。
 */
package com.chang.memento.whitebox;

public class Originator {

    private String state;

    /**
     * 工厂方法，放回一个新的备忘录对象
     *
     * @return
     */
    public Memento createMemento() {
        return new Memento(state);
    }

    /**
     * 将发起人状态恢复到备忘录对象所记载的状态
     *
     * @param memento
     */
    public void restoreMemento(Memento memento) {
        this.state = memento.getState();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
        System.out.println("当前状态为：" + this.state);
    }

}
