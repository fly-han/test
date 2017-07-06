package com.han.socket;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by hanfei3 on 2017/6/23.
 */
public class MySocketServer {
    public static void main(String[] args) throws IOException {
        int backlog = 10;
        ServerSocket server = new ServerSocket(8888, backlog);
        Socket accept = server.accept();
    }
}
