package com.chang.command.example.tvcontroller;

public class InvokerTVController {
    private Command openTVCommand = null;
    private Command closeTVCommand = null;
    private Command changeChannelCommand = null;

    public InvokerTVController() {
    }

    public InvokerTVController(Command openTVCommand, Command closeTVCommand,
                               Command changeChannelCommand) {
        this.openTVCommand = openTVCommand;
        this.closeTVCommand = closeTVCommand;
        this.changeChannelCommand = changeChannelCommand;
    }

    public void setOpenTVCommand(Command openTVCommand) {
        this.openTVCommand = openTVCommand;
    }

    public void setCloseTVCommand(Command closeTVCommand) {
        this.closeTVCommand = closeTVCommand;
    }

    public void setChangeChannelCommand(Command changeChannelCommand) {
        this.changeChannelCommand = changeChannelCommand;
    }

    public void openTV() {
        if (null != openTVCommand) {
            openTVCommand.execute();
        } else {
            System.out.println("openTV Command doesn't exist.");
        }
    }

    public void closeTV() {
        if (null != closeTVCommand) {
            closeTVCommand.execute();
        } else {
            System.out.println("closeTV Command doesn't exist.");
        }
    }

    public void changeChannel() {
        if (null != changeChannelCommand) {
            changeChannelCommand.execute();
        } else {
            System.out.println("changeChannelCommand Command doesn't exist.");
        }
    }
}
