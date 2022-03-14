package com.example.springdemo.com.sp_api;

import com.amazon.SellingPartnerAPIAA.AWSAuthenticationCredentials;
import com.amazon.SellingPartnerAPIAA.LWAAuthorizationCredentials;
import com.amazon.sellingpartnerapi.client.FbaInventoryApi;
import com.amazon.sellingpartnerapi.client.FeedsApi;
import com.example.springdemo.com.sp_api.spConfig.Config;

public class SPFeedUtil {

    public static FeedsApi getFeedInstance(Config config){

        AWSAuthenticationCredentials awsAuthenticationCredentials = AWSAuthenticationCredentials.builder()
                .accessKeyId(config.getAwsAccessKeyId())
                .secretKey(config.getAwsAccessSecretKey())
                .region(config.getRegion())
                .build();

        LWAAuthorizationCredentials lwaAuthorizationCredentials = LWAAuthorizationCredentials.builder()
                .clientId(config.getLwaClientId())
                .clientSecret(config.getLwaClientSecret())
                .refreshToken(config.getRefreshToken())
                .endpoint("https://api.amazon.com/auth/o2/token")
                .build();

        return new FeedsApi.Builder()
                .awsAuthenticationCredentials(awsAuthenticationCredentials)
                .lwaAuthorizationCredentials(lwaAuthorizationCredentials)
                .endpoint(config.getApiEndpoint())
                .build();

    }

}
