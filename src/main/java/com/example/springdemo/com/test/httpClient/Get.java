package com.example.springdemo.com.test.httpClient;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Get {

    public static void main(String[] args) {
//        get();
        post();
    }
    public static void post(){
        //创建httpClient实例
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //创建http post
        HttpPost httpPost = new HttpPost("http://www.baid.com/");

        //创建参数队列
        List<NameValuePair> formParams = new ArrayList<>();
        formParams.add(new BasicNameValuePair("type","hosue"));

        UrlEncodedFormEntity urlEncodedFormEntity;
        try {
            urlEncodedFormEntity = new UrlEncodedFormEntity(formParams,"UTF-8");
            httpPost.setEntity(urlEncodedFormEntity);
            System.out.println("excuting request: "+httpPost.getURI());
            CloseableHttpResponse response = httpClient.execute(httpPost);
            System.out.println("响应状态："+response.getStatusLine());
            try {
                HttpEntity entity = response.getEntity();
                if(entity != null){
                    System.out.println("------------------------");
                    System.out.println("Response content:"+EntityUtils.toString(entity,"UTF-8"));
                    System.out.println("-------------------------");
                }
            }finally {
                response.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public  static void get(){
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
            //创建HttpGet
            HttpGet httpGet = new HttpGet("http://www.baidu.com/");
            System.out.println("executeing request: "+httpGet.getURI());
            //执行get请求
            CloseableHttpResponse response = httpClient.execute(httpGet);
            try {
                //获取响应实体
                HttpEntity entity = response.getEntity();
                System.out.println("-------------------------------");
                System.out.println("响应状态："+response.getStatusLine());
                if(entity!=null){
                    System.out.println("内容响应长度："+entity.getContentLength());
                    System.out.println("响应内容："+ EntityUtils.toString(entity));
                }
                System.out.println("-------------------------------");
            } finally {
                response.close();
            }
        }catch (ClientProtocolException e){
            e.printStackTrace();
        }catch (IOException o){
            o.printStackTrace();
        }catch (ParseException p){
            p.printStackTrace();
        }finally {
            //关闭连接，释放资源
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
