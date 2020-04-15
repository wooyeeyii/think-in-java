package com.chang.mediator.example.playvideo;

/**
 * 光驱
 *
 * @author junjie.chang
 */
public class CDDriver extends Colleague {

    //光驱读取出来的数据
    private String data = "";

    public CDDriver(Mediator mediator) {
        super(mediator);
    }

    //获取光盘读取出来的数据
    public String getData() {
        return data;
    }

    //读取光盘
    public void readCD() {
        //逗号前是视频显示的数据，逗号后是声音
        this.data = "One Piece, 海贼王我当定了";
        //通知主板，自己的状态发生了改变
        getMediator().changed(this);
    }
}
