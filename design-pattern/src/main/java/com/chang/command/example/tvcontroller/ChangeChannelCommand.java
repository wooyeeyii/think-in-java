package com.chang.command.example.tvcontroller;

public class ChangeChannelCommand implements Command {

    private ReceiverTV receiverTV = new ReceiverTV();

    public ChangeChannelCommand(ReceiverTV receiverTV) {
        this.receiverTV = receiverTV;
    }

    @Override
    public void execute() {
        // TODO Auto-generated method stub
        receiverTV.changeChannel();
    }

}
