package com.han.http;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * Created by hanfei3 on 2017/5/9.
 */
public class MyHttpServer {
    public static void main(String[] args) {
//实现HTTP SERVER
        try {
            // 设置HttpServer的端口为8888
            HttpServer hs = HttpServer.create(new InetSocketAddress(8888), 0);
            hs.createContext("/myHttp", new MyHandler());// 用MyHandler类内处理到/的请求
            hs.setExecutor(null); // creates a default executor
            System.out.println("server 启动成功！");
            hs.start();
//            hs.stop(0);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
