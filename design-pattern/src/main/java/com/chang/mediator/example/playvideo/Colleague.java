package com.chang.mediator.example.playvideo;

public abstract class Colleague {

    //持有一个调停者
    private Mediator mediator;

    public Colleague(Mediator mediator) {
        this.mediator = mediator;
    }

    //获取当前同事类对应的调停者对象
    public Mediator getMediator() {
        return mediator;
    }

}
