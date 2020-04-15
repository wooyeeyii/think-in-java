package com.chang.mediator.example.playvideo;

public class SoundCard extends Colleague {

    public SoundCard(Mediator mediator) {
        super(mediator);
    }

    /**
     * 按照声频数据发出声音
     */
    public void soundData(String data) {
        System.out.println("画外音：" + data);
    }
}
