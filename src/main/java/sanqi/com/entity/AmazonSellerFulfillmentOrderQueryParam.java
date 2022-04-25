package sanqi.com.entity;

import java.sql.Date;

public class AmazonSellerFulfillmentOrderQueryParam {

    private String accountId;  //�˻�����
    private String oldOrderID;  //�ɶ�����
    private String fulfillmentOrderId;  //�¶�����
    private Date resendDate;  //�ط�����
    private Date minDate;  //�ط�����
    private String sku;    //SKU
    private String addUser;  //�ϴ���

    public Date getMinDate() {
        return minDate;
    }

    public void setMinDate(Date minDate) {
        this.minDate = minDate;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getOldOrderID() {
        return oldOrderID;
    }

    public void setOldOrderID(String oldOrderID) {
        this.oldOrderID = oldOrderID;
    }

    public String getFulfillmentOrderId() {
        return fulfillmentOrderId;
    }

    public void setFulfillmentOrderId(String fulfillmentOrderId) {
        this.fulfillmentOrderId = fulfillmentOrderId;
    }

    public Date getResendDate() {
        return resendDate;
    }

    public void setResendDate(Date resendDate) {
        this.resendDate = resendDate;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getAddUser() {
        return addUser;
    }

    public void setAddUser(String addUser) {
        this.addUser = addUser;
    }
}
