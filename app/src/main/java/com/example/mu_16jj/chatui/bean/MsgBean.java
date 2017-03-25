package com.example.mu_16jj.chatui.bean;

/**
 * Description：消息实体类
 * <p>
 * WeChat：mu-16jj
 * <p>
 * Created by mu-16jj on 2017/3/25.
 */

public class MsgBean {

    private String content;
    private int msgType;

    public MsgBean(String content, int msgType) {
        this.content = content;
        this.msgType = msgType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getMsgType() {
        return msgType;
    }

    public void setMsgType(int msgType) {
        this.msgType = msgType;
    }
}
