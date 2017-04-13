package com.han.DesignPatterns.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * 观察者，或者叫订阅者
 * Created by hanfei3 on 2017/4/13.
 */
public class Watcher implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("订阅消息成功"+ arg);
    }
}
