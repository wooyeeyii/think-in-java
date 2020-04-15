package com.chapter20;


public class P621Testable {
    public void execute() {
        System.out.println("Executing..");
    }

    @P621Test
    void testExecute() {
        execute();
    }

}
