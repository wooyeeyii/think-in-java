package com.chang.command.example.tvcontroller;

//宏命令
public interface MacroCommand extends Command {
	//宏命令聚集的管理方法
	//添加一个成员命令
	public void add(Command cmd);
	
	//宏命令聚集的管理方法
	//删除一个成员命令
	public void remove(Command cmd);
}
