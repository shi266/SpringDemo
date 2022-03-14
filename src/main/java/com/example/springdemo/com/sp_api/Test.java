package com.example.springdemo.com.sp_api;

import com.amazon.SellingPartnerAPIAA.AWSAuthenticationCredentials;
import com.amazon.SellingPartnerAPIAA.LWAAuthorizationCredentials;
import com.example.springdemo.com.sp_api.spConfig.Config;

public class Test {
    private static AWSAuthenticationCredentials awsAuthenticationCredentials;
    private static LWAAuthorizationCredentials lwaAuthorizationCredentials;



    public void util (Config config) {
        AWSAuthenticationCredentials awsAuthenticationCredentials = AWSAuthenticationCredentials.builder()
                .accessKeyId("accessKeyId")
                .secretKey("secretKey")
                .region("region")
                .build();


        LWAAuthorizationCredentials lwaAuthorizationCredentials = LWAAuthorizationCredentials.builder()
                .clientId("clientId")
                .clientSecret("clientSecret")
                .refreshToken("refreshToken")
                .endpoint("https://api.amazon.com/auth/o2/token")
                .build();

    }

}
