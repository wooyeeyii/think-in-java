package com.chapter3.P177;

public class DBTools {

    private boolean preIsA = true;

    public synchronized void backupA() {
        try {
            while (false == preIsA) {
                //System.out.println("backupA��" + Thread.currentThread().getName() + " �̳߳�waitװ״̬. ");
                this.wait();
            }
            System.out.println("������");
            preIsA = false;
            notifyAll();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public synchronized void backupB() {
        try {
            while (true == preIsA) {
                //System.out.println("backupB��" + Thread.currentThread().getName() + " �̳߳�waitװ״̬. ");
                this.wait();
            }
            System.out.println("������");
            preIsA = true;
            notifyAll();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
