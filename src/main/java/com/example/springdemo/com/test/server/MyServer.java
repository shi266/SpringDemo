package com.example.springdemo.com.test.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;

public class MyServer {
    //使用ArrayList存放连上服务端的所有客户端
    public static ArrayList<Socket> sockets = new ArrayList<>();
    public static void main(String[] args) {
        try {
            //创建一个服务器套接字,绑定到54321端口
            ServerSocket server = new ServerSocket(6666);
            System.out.println("服务器已启动，正在等待连接");
            while (true) {
                //调用accept方法，侦听来自客户端的请求
                Socket socket = server.accept();
                if(socket.isClosed()){
                    sockets.remove(socket);
                }
                //将客户端发送过来的通信套接字添加到sockets动态数组中
                sockets.add(socket);
                //输出在线的客户端个数
                System.out.println("有" + sockets.size() + "个客户连接上");
                //启动发送线程，给客户端发送一句“欢迎光临！”
                new getOutputStream(socket).start();
                //启动接收线程，读取从客户端发来的消息
                new getInputStream(socket).start();
            }
        } catch (SocketException sc){
            sc.printStackTrace();
            System.out.println("客户端连接已被断开");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
class getOutputStream extends Thread{
    private Socket s;
    public getOutputStream(Socket s) {
        this.s=s;
    }
    @Override
    public void run() {
        try {
            //获取输出流
            OutputStream ops= s.getOutputStream();
            String msg="服务器连接成功！\n";
            //将msg写入流
            ops.write(msg.getBytes());
            //刷新流
            ops.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

//接收线程，读取从客户端发来的消息
class getInputStream extends Thread {
    private Socket r;
    public getInputStream(Socket r) {
        this.r = r;
    }
    public void run() {
        try {
            //获取输入流
            InputStreamReader is = new InputStreamReader(r.getInputStream());
            BufferedReader br = new BufferedReader(is);
            while (true) {
                //读取客户端发送过来的消息
                String msg = br.readLine();
                String name = "时七、";
                System.out.println(name+":\n" + msg);
                //读取客户端发送过来的消息后转发给所有在线的客户端
                for (Socket socket : MyServer.sockets) {
                    OutputStreamWriter osw = new OutputStreamWriter(
                            socket.getOutputStream());
                    BufferedWriter bw = new BufferedWriter(osw);
                    bw.write(msg + "\n");
                    //刷新流
                    bw.flush();

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
