package com.example.springdemo.com.sp_api;

import com.amazon.SellingPartnerAPIAA.AWSAuthenticationCredentials;
import com.amazon.SellingPartnerAPIAA.LWAAuthorizationCredentials;
import com.amazon.sellingpartnerapi.client.FbaOutboundApi;
import com.amazon.sellingpartnerapi.client.FeedsApi;
import com.amazon.sellingpartnerapi.models.fulfillmentOutbound.FulfillmentOrder;
import com.example.springdemo.com.sp_api.spConfig.Config;

public class FulfillmentUtil {

    public static FbaOutboundApi getFbaOutbountInstance(Config config){

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

        return new FbaOutboundApi.Builder()
                .awsAuthenticationCredentials(awsAuthenticationCredentials)
                .lwaAuthorizationCredentials(lwaAuthorizationCredentials)
                .endpoint(config.getApiEndpoint())
                .build();

    }

}
