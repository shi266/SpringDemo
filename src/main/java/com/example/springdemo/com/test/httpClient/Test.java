package com.example.springdemo.com.test.httpClient;

import cn.hutool.http.HttpUtil;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class Test {

    public static void main(String[] args) {

       String a = HttpUtil.createGet("http://localhost:8080/getUsers").execute().body();
        System.out.println(a);

        /*//获取客户端
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        //参数
        StringBuffer params = new StringBuffer();
        try {
            params.append("name=张三"+ URLEncoder.encode("&","utf-8"));
            params.append("&");
            params.append("password=zhang");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //创建get请求
        HttpGet httpGet = new HttpGet("http://localhost:8080/getUsers");
        CloseableHttpResponse response = null;
        //响应
       try {
            response = httpClient.execute(httpGet);
           HttpEntity entity = response.getEntity();
           System.out.println("响应状态："+response.getStatusLine());

           if(entity!=null){
               System.out.println("响应内容长度："+entity.getContentLength());
               System.out.println("响应内容为："+ EntityUtils.toString(entity));
           }
           


       } catch (ClientProtocolException e) {
           e.printStackTrace();
       } catch (IOException e) {
           e.printStackTrace();
       }finally {
           //释放资源
         try {
             if(httpClient!=null){
                 httpClient.close();
             }
             if(response!=null){
                 response.close();
             }
             
         } catch (IOException e) {
             e.printStackTrace();
         }
       }*/

    }

}
