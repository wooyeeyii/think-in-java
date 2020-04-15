package com.chapter3.P177;

public class ThreadB extends Thread {

    private DBTools dbTools;

    public ThreadB(DBTools dbTools) {
        super();
        this.dbTools = dbTools;
    }

    @Override
    public void run() {
        while (true) {
            dbTools.backupB();
        }
    }

}
