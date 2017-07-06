package com.han.thtread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by hanfei3 on 2017/6/23.
 */
public class TestThread {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new MyThread().start();
        }
    }

}

class MyThread extends Thread {
    private volatile static int a = 0;
    public  void run() {
        add();
    }

    private synchronized void add(){
        a++;
        System.out.println(Thread.currentThread().getName());
        System.out.println(a);
    }
}
