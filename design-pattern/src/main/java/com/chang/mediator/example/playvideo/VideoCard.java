package com.chang.mediator.example.playvideo;

public class VideoCard extends Colleague {

    public VideoCard(Mediator mediator) {
        super(mediator);
    }

    /**
     * 显示视频数据
     */
    public void showData(String data) {
        System.out.println("您正在观看的是：" + data);
    }
}
