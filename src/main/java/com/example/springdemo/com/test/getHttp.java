package com.example.springdemo.com.test;


import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class getHttp {

    public static void main(String[] args) throws IOException {
        //httpGet请求   url
        String test139 = "http://139.129.162.135:9999/YiLianMaoYiTest/index.html";
        String kugou = "https://www.kugou.com/?username==java";
        String baidu = "https://www.baidu.com";
        String boke = "https://blog.csdn.net/guihua55/article/details/108951768?utm_medium=distribute.pc_relevant.none-task-blog-2~default~baidujs_title~default-5.highlightwordscore&spm=1001.2101.3001.4242.4";
        testGet(test139);
    }


    public static void testGet(String url) throws IOException {
        //创建client对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //创建HttpGet请求，
        HttpGet httpGet = new HttpGet(url);
        String useAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36";
        httpGet.setHeader("User-Agent",useAgent);

        //发起请求
        CloseableHttpResponse response = httpClient.execute(httpGet);

        //判断响应状态码并获取响应数据
        if(response.getStatusLine().getStatusCode()==200){
            String html = EntityUtils.toString(response.getEntity(),"UTF-8");
            System.out.println("------------------------------------------");
            System.out.println();
            System.out.println("------------------------------------------");
        }
        //关闭资源
        response.close();
        httpClient.close();


    }

}
