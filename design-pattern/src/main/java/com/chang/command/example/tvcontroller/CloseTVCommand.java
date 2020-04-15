package com.chang.command.example.tvcontroller;

public class CloseTVCommand implements Command {
    private ReceiverTV receiverTV = new ReceiverTV();

    public CloseTVCommand(ReceiverTV receiverTV) {
        this.receiverTV = receiverTV;
    }

    @Override
    public void execute() {
        // TODO Auto-generated method stub
        receiverTV.closeTV();
    }
}
