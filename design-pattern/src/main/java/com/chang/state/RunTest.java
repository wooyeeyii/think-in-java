package com.chang.state;

public class RunTest {
	
	public static void main(String[] args) {
		//创建状态
		State state = new ConcreteStateA();
		
		//创建环境
		Context context = new Context();
		
		//将状态设置到环境中
		context.setState(state);
		
		//请求
		context.request("test");
		
	}

}
