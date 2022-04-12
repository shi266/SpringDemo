package sanqi.com.test.client;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class MyClient {
    public static void main(String[] args) {
        try {
            //创建一个套接字（Socket） ，向服务器的侦听端口发出请求
            Socket socket = new Socket("localhost", 6666);
            //启动读取数据线程，接收服务器发送过来的消息
            new Cread(socket).start();
            //启动发送数据线程，给服务器发送消息
            new Csend(socket).start();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

//读取数据线程，接收服务器发送过来的消息
class Cread extends Thread {
    private Socket r;
    public Cread(Socket r) {
        this.r = r;
    }
    public void run() {
        try {
            while (true) {
                //获取输入流
                InputStreamReader is = new InputStreamReader(r.getInputStream());
                BufferedReader br = new BufferedReader(is);
                //按行读取从服务器发来的数据消息
                String content = br.readLine();
                if(content.equals("exit")){
                    r.close();
                    System.out.println("关闭连接");
                }
                String name = "三七、";
                System.out.println("\t\t\t\t\t\t\t\t\t\t\t"+name+":\n\t\t\t\t\t\t\t\t\t\t\t" + content);
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
//发送数据线程，给服务器发送消息
class Csend extends Thread {
    private Socket c;
    public Csend(Socket c) {
        this.c = c;
    }
    public void run() {
        try {
            //获取输出流
            OutputStreamWriter osw = new OutputStreamWriter(c.getOutputStream());
            BufferedWriter bw = new BufferedWriter(osw);
            //从键盘写入数据
            Scanner sc = new Scanner(System.in);
            while (true) {
                //将键盘写入的数据按行写入发送给服务器
                String msg = sc.nextLine() + "\n";
                bw.write(msg);
                System.out.println(msg);
                //刷新流
                bw.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}