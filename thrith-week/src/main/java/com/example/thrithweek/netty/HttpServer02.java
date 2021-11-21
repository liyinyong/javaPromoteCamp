package com.example.thrithweek.netty;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer02 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8082);
        System.out.println("开启侦听。。。。");
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                service(socket);
            } catch (Exception e) {

            }
        }
    }

    private static void service(Socket socket) {
        System.out.println("接受到请求：" + socket);
        try {
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
            printWriter.println("HTTP/1.1 200 OK");
            printWriter.println("Content-Type:text/html;charset=utf-8");
            String body = "hello";
            printWriter.println("Content-Length:" + body.getBytes().length);
            printWriter.println();
            printWriter.write(body);
            printWriter.close();
            socket.close();
        } catch (Exception e) {

        }
    }
}
