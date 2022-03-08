package com.example.springdemo.com.util;

import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;

public class HttpUtils {
    private static PoolingHttpClientConnectionManager cm;

    public HttpUtils() {
        cm = new PoolingHttpClientConnectionManager();
        //设置最大连接数
        cm.setMaxTotal(100);
        cm.setDefaultMaxPerRoute(10);
    }

    //获取html的网页前端代码
    public static String doGetHtml(String url) throws Exception {
        //1.获取对象
        CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(cm).build();
        //2.地址
        HttpGet httpGet = new HttpGet(url);
        //设置请求信息
//        httpGet.setConfig(getConfig());
        //3.请求数据
        CloseableHttpResponse response = httpClient.execute(httpGet);
        //4.解析
        if (response.getStatusLine().getStatusCode()==200){
            if (response.getEntity() != null){
                String content = EntityUtils.toString(response.getEntity(), "GBK");
                return content;
            }
        }
        if (response != null){
            response.close();
        }
        return "没有数据时候返回空"; //没有数据时候返回空
    }

}
