package com.chang.memento.whitebox;

public class Caretaker {

    private Memento memento;

    //备忘录的取值方法
    public Memento retriveMemento() {
        return this.memento;
    }

    public void saveMemento(Memento memento) {
        this.memento = memento;
    }

}
