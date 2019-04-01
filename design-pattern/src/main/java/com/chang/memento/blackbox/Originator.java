/**
 * 发起人角色类，发起人角色利用一个新创建的备忘录对象将自己的内部状态存储起来。
 */
package com.chang.memento.blackbox;

public class Originator {
	
	private String state;
	
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
		System.out.println("当前状态为：" + this.state);
	}
	
	/**
	 * 工厂方法，放回一个新的备忘录对象
	 * @return
	 */
	public MementoIF createMemento() {
		return new Memento(state);
	}
	
	/**
	 * 将发起人状态恢复到备忘录对象所记载的状态
	 * @param memento
	 */
	public void restoreMemento(MementoIF memento) {
		//this.setState(((Memento)memento).getState());
		this.state = ((Memento)memento).getState();
	}
	
	private class Memento implements MementoIF {
		
	    private String state;
	    
	    private Memento(String state){
	        this.state = state;
	    }

	    private String getState() {
	        return state;
	    }

	    private void setState(String state) {
	        this.state = state;
	    }

	}

}
