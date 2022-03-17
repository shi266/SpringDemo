/*
package com.example.springdemo.com.sp_api;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.amazonaws.mws.MarketplaceWebServiceClient;
import com.amazonaws.mws.MarketplaceWebServiceException;
import com.amazonaws.mws.model.*;
import okhttp3.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class UploadTest {

    public static void main(String args[]) throws MarketplaceWebServiceException {
//        MarketplaceWebServiceClient client =FBAFeedUtil.getClient();

        

        SubmitFeedRequest request = new SubmitFeedRequest();
        request.withContentMD5("fwfer")
                .withContentMD5("")
                .withFeedType("");

//        SubmitFeedResponse submitFeedResponse = client.submitFeed(request);
//        SubmitFeedResult result = submitFeedResponse.getSubmitFeedResult();




        String url = "/feeds/2021-06-30/feeds";
        String content = "<your feed content>";

        UploadTest obj = new UploadTest();
        obj.upload(content.getBytes(StandardCharsets.UTF_8), url);

        FeedSubmissionInfo info = new FeedSubmissionInfo();
        System.out.println(        info.getFeedProcessingStatus());

    }

    */
/**
     * Upload content to the given URL.
     *
     * @param source the content to upload
     * @param url    the URL to upload content
     *//*

    public void upload(byte[] source, String url) {
        OkHttpClient client = new OkHttpClient();
        String contentType = String.format("text/xml; charset=%s", StandardCharsets.UTF_8);


        try {
            Request request = new Request.Builder()
                    .url(url)
                    .put(RequestBody.create(MediaType.parse(contentType),source))
                    .build();
            Response response = client.newCall(request).execute();
                if(!response.isSuccessful()){
                    String.format("Call to upload document failed with response code: %d and message: %s",
                            response.code(), response.message());
                }
                //成功返回
                String a = response.message();
            JSON json = JSONUtil.parse(a);



        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
*/
