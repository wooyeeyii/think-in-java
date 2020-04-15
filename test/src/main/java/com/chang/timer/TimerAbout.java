package com.chang.timer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

class MyTask extends TimerTask {

    @Override
    public void run() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
        System.out.println("您该起床了!!!!");
    }
}

public class TimerAbout {
    public static void main(String[] args) {

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        System.out.println(df.format(new Date()));// new Date()为获取当前系统时间

        //创建定时器对象
        Timer t = new Timer();
        //在3秒后执行MyTask类中的run方法
        MyTask task = new MyTask();
        t.schedule(task, 3000, 3000); //参数  任务, delay, period

        System.out.println(task.getClass().getName());
    }

}
