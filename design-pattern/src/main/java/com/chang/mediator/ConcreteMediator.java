package com.chang.mediator;

public class ConcreteMediator implements Mediator {

    //持有并维护同事A
    private ConcreteColleagueA colleagueA;

    //持有并维护同事B
    private ConcreteColleagueB colleagueB;

    public void setColleagueB(ConcreteColleagueB colleagueB) {
        this.colleagueB = colleagueB;
    }

    public void setColleagueA(ConcreteColleagueA colleagueA) {
        this.colleagueA = colleagueA;
    }

    @Override
    public void changed(Colleague c) {
        /**
         * 某一个同事发生了变化，通常需要其他同事交互
         * 具体协调相应的同事对象来实现协作行为
         */
    }

}
