package com.chang.command.example.tvcontroller;

public class Test {

    public static void main(String[] args) {
        //������
        ReceiverTV receiverTV = new ReceiverTV();
        //�����������
        Command openTVCommand = new OpenTVCommand(receiverTV);
        Command closeTVCommand = new CloseTVCommand(receiverTV);
        Command changeChannelCommand = new ChangeChannelCommand(receiverTV);
        //���������߶���
        InvokerTVController invokerTVController = new InvokerTVController(openTVCommand, closeTVCommand, changeChannelCommand);
        //����
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
