package com.han.http;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.*;

/**
 * Created by hanfei3 on 2017/5/9.
 */
public class MyHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        System.out.println("请求成功");
        InputStream is = httpExchange.getRequestBody();
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        String temp = null;
        while((temp = reader.readLine()) != null) {
            System.out.println("client request:"+temp);
        }
        String response = "<h1>hello my HttpServer</h1>";
        httpExchange.sendResponseHeaders(200, response.length());
        OutputStream os = httpExchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
        //结束服务
//        httpExchange.getHttpContext().getServer().stop(0);
    }
}
