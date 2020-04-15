package com.chang.command.example.tvcontroller;

import java.util.ArrayList;
import java.util.List;

public class TVMacroCommand implements MacroCommand {

    private List<Command> commandList = new ArrayList<Command>(); //˳��ִ��

    @Override
    public void add(Command cmd) {
        // TODO Auto-generated method stub
        commandList.add(cmd);
    }

    @Override
    public void remove(Command cmd) {
        // TODO Auto-generated method stub
        commandList.remove(cmd);
    }

    @Override
    public void execute() {
        // TODO Auto-generated method stub
        for (Command cmd : commandList) {
            cmd.execute();
        }
    }
}
