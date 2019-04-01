package com.chang.memento.multicheck;

import java.util.ArrayList;
import java.util.List;

public class Memento {

    private List<String> states;
    private int index;
    /**
     * 构造函数
     */
    public Memento(List<String> states , int index){
    	//重新开辟的内存空间
        this.states = new ArrayList<String>(states);
        this.index = index;
    }
    public List<String> getStates() {
        return states;
    }
    public int getIndex() {
        return index;
    }
    
}
