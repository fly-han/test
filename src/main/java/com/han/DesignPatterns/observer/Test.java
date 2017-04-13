package com.han.DesignPatterns.observer;

import java.util.Observable;
import java.util.Observer;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by hanfei3 on 2017/4/13.
 */
public class Test {
    public static void main(String[] args) {
        //创建观察者对象
        Observer watcher = new Watcher();
        //被观察着
        Subject subject = new Subject();
        //把观察者添加到被观察者中
        subject.addObserver(watcher);

        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("执行");
                subject.publish("data===");
            }
        };

        timer.schedule(task, 0, 1000);

    }


}
