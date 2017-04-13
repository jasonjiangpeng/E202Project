package com.aotome202.lostjason.e202project.eventbus;

/**
 * Created by LostJason on 2017/4/11.
 */

public class MessageEvent {
    String value;
    int data;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public MessageEvent(String value, int data) {
        this.value = value;
        this.data = data;
    }
}
