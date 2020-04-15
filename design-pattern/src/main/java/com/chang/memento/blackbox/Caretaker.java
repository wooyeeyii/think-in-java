/**
 * 对象拿到的仅是MementoIF接口，因此无法读出备忘录对象内部的状态
 */
package com.chang.memento.blackbox;

public class Caretaker {

    private MementoIF memento;

    //备忘录的取值方法
    public MementoIF retriveMemento() {
        return this.memento;
    }

    public void saveMemento(MementoIF memento) {
        this.memento = memento;
    }

}
