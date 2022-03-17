package com.example.springdemo.com.sp_api;

import com.amazon.sellingpartnerapi.ApiClient;
import com.amazon.sellingpartnerapi.ApiException;
import com.amazon.sellingpartnerapi.client.FeedsApi;
import com.amazon.sellingpartnerapi.models.feeds.*;
import com.example.springdemo.com.sp_api.spConfig.Config;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FBAFeedUtil {

    public  void getClient() throws ApiException, IOException {
        //设置提要内容类型
        CreateFeedDocumentSpecification createFeedDocumentSpecification =  new CreateFeedDocumentSpecification();
            createFeedDocumentSpecification.setContentType("FeedType");

        FeedsApi feedsApi = SPFeedUtil.getFeedInstance(new Config());

        CreateFeedDocumentResponse feedDocument = feedsApi.createFeedDocument(createFeedDocumentSpecification);
        //返回的 feedDocumentId 和 用于上传feed内容的url
        String feedDocumentId = feedDocument.getFeedDocumentId();
        String url = feedDocument.getUrl();

        File path = new File("D:demotest/text.xml");
        byte[] fiel = new byte[1024];
        FileOutputStream out = new FileOutputStream(path);
        out.write(fiel);

        //提交文档
//        new UploadTest().upload(fiel,url);


        CreateFeedSpecification createFeedSpecification = new CreateFeedSpecification();
        createFeedSpecification.inputFeedDocumentId(feedDocumentId);
        CreateFeedResponse response = feedsApi.createFeed(createFeedSpecification);
        String feedId  = response.getFeedId();


        String status = feedsApi.getFeed(feedId).getProcessingStatus().getValue();
        //DONE、CANCELLED 或 FATAL
        if("DONE".equals(status)){
            System.out.println("订单完成");
            String resultFeedDocumentId = feedsApi.getFeed(feedId).getResultFeedDocumentId();
            FeedDocument feedDocument1 = feedsApi.getFeedDocument(resultFeedDocumentId);

        }else if("CANCELLED".equals(status)){
            System.out.println("订单取消");
        }else if("FATAL".equals(status)){
            System.out.println("订单失败");
        }

    }
    //定时方法
    public String getFeed(String feedId){

        return "";
    }

}
