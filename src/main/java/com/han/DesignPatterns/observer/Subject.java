package com.han.DesignPatterns.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * 被观察者 或者叫发布者
 * Created by hanfei3 on 2017/4/13.
 */
public class Subject extends Observable {

    private String data = "";

    /**
     * 发布信息
     * @param data
     */
    public void publish(String data) {

        if(!this.data.equals(data)){
            this.data = data;
            setChanged();
        }
        super.notifyObservers(data);
    }
}
