package com.example.springdemo.com.sp_api.spConfig;

public class Config {
    private String reportPath;

    private String awsAccessKeyId;
    private String awsAccessSecretKey;
    private String region;
    private String roleArn;
    private String roleSessionName;
    private String lwaClientId;
    private String lwaClientSecret;
    private String refreshToken;
    private String apiEndpoint;

    public String getReportPath() {
        return reportPath;
    }

    public void setReportPath(String reportPath) {
        this.reportPath = reportPath;
    }

    public String getAwsAccessKeyId() {
        return awsAccessKeyId;
    }

    public void setAwsAccessKeyId(String awsAccessKeyId) {
        this.awsAccessKeyId = awsAccessKeyId;
    }

    public String getAwsAccessSecretKey() {
        return awsAccessSecretKey;
    }

    public void setAwsAccessSecretKey(String awsAccessSecretKey) {
        this.awsAccessSecretKey = awsAccessSecretKey;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getRoleArn() {
        return roleArn;
    }

    public void setRoleArn(String roleArn) {
        this.roleArn = roleArn;
    }

    public String getRoleSessionName() {
        return roleSessionName;
    }

    public void setRoleSessionName(String roleSessionName) {
        this.roleSessionName = roleSessionName;
    }

    public String getLwaClientId() {
        return lwaClientId;
    }

    public void setLwaClientId(String lwaClientId) {
        this.lwaClientId = lwaClientId;
    }

    public String getLwaClientSecret() {
        return lwaClientSecret;
    }

    public void setLwaClientSecret(String lwaClientSecret) {
        this.lwaClientSecret = lwaClientSecret;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getApiEndpoint() {
        return apiEndpoint;
    }

    public void setApiEndpoint(String apiEndpoint) {
        this.apiEndpoint = apiEndpoint;
    }
}
