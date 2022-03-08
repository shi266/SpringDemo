package com.example.springdemo.com.sp_api;

import com.amazonaws.mws.MarketplaceWebServiceClient;
import com.amazonaws.mws.MarketplaceWebServiceConfig;

public class FBAFeedUtil {
    private static MarketplaceWebServiceClient client = null;

    public static MarketplaceWebServiceClient getClient(){
        if(client == null){
            MarketplaceWebServiceConfig config = new MarketplaceWebServiceConfig();
            config.setServiceURL("");
            client = new MarketplaceWebServiceClient("AccessKeyId",
                    "SecretKey",
                    "appName",
                    "appVersion",
                    config);

        }

        return client;
    }

}
