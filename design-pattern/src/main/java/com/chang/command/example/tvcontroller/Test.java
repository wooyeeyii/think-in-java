package com.chang.command.example.tvcontroller;

public class Test {
	
	public static void main(String[] args) {
		//接受者
		ReceiverTV receiverTV = new ReceiverTV();
		//创建命令对象
		Command openTVCommand = new OpenTVCommand(receiverTV);
		Command closeTVCommand = new CloseTVCommand(receiverTV);
		Command changeChannelCommand = new ChangeChannelCommand(receiverTV);
		//创建请求者对象
		InvokerTVController invokerTVController = new InvokerTVController(openTVCommand, closeTVCommand, changeChannelCommand);
		//测试
		invokerTVController.openTV();
		invokerTVController.changeChannel();
		invokerTVController.closeTV();
		
		System.out.println("----------------------------------");
		MacroCommand macroCommand = new TVMacroCommand();
		macroCommand.add(openTVCommand);
		macroCommand.add(closeTVCommand);
		macroCommand.execute();
	}

}
