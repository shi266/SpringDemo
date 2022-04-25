package sanqi.com.entity;

import java.sql.Date;

//@Component
public class AmazonSellerFulfillmentOrder {

    private String fulfillmentOrderId;  //新订单号
    private String accountId;           //账号名称
    private String marketplaceID;    //站点
    private String sku;    //卖家SKU
    private Integer quantity;    //数量
    private String shippingSpeedCategory;    //速度
    private String addressName;    //地址
    private String addressFieldOne;    //地址一
    private String addressFieldTwo;    //地址二
    private String addressFieldThree;    //地址三
    private String addressCity;    //城市
    private String addressCountryCode;    //国家
    private String addressStateOrRegion;    //区/州
    private String addressPostalCode;    //邮编
    private String addressPhoneNumber;    //地区号码
    private String oldOrderID;      //旧订单号
    private Double fulfillmentFee;
    private String purchaseDate;       //购买日期
    private String requestIdMws;
    private Date resendDate;        //重发日期
    private String fulfillmentReason;        //重发原因
    private String customerUploadPictures;    //上传图片
    private String addUser;        //上传人
    private String displayableOrderComment;        //上传人
    private StringBuilder checkResult = new StringBuilder();

    public String getDisplayableOrderComment() {
        return displayableOrderComment;
    }

    public void setDisplayableOrderComment(String displayableOrderComment) {
        this.displayableOrderComment = displayableOrderComment;
    }

    public StringBuilder getCheckResult() {

        if (this.accountId == null || "".equals(this.accountId.trim())) {
            this.checkResult.append("账户不能为空<br />");
        }
        if (this.sku == null || "".equals(this.sku.trim())) {
            this.checkResult.append("SKU不能为空<br />");
        }
        if (this.oldOrderID == null || "".equals(this.oldOrderID.trim())) {
            this.checkResult.append("旧订单号不能为空<br />");
        }
        if (this.fulfillmentOrderId == null || "".equals(this.fulfillmentOrderId.trim())) {
            this.checkResult.append("新订单号不能为空<br />");
        }

        if (this.fulfillmentReason == null || "".equals(this.fulfillmentReason.trim())) {
            this.checkResult.append("重发原因不能为空<br />");
        }
        return checkResult;
    }

    public String getRequestIdMws() {
        return requestIdMws;
    }

    public void setRequestIdMws(String requestIdMws) {
        this.requestIdMws = requestIdMws;
    }

    public Double getFulfillmentFee() {
        return fulfillmentFee;
    }

    public void setFulfillmentFee(Double fulfillmentFee) {
        this.fulfillmentFee = fulfillmentFee;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public void setCheckResult(StringBuilder checkResult) {
        this.checkResult=checkResult;
    }

    public String getFulfillmentOrderId() {
        return fulfillmentOrderId;
    }

    public void setFulfillmentOrderId(String fulfillmentOrderId) {
        if(fulfillmentOrderId != null){
            this.fulfillmentOrderId = fulfillmentOrderId.trim();
        }

    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getMarketplaceID() {
        return marketplaceID;
    }

    public void setMarketplaceID(String marketplaceID) {
        this.marketplaceID = marketplaceID;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        if(sku != null){
            this.sku = sku.trim();
        }
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getShippingSpeedCategory() {
        return shippingSpeedCategory;
    }

    public void setShippingSpeedCategory(String shippingSpeedCategory) {
        this.shippingSpeedCategory = shippingSpeedCategory;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    public String getAddressFieldOne() {
        return addressFieldOne;
    }

    public void setAddressFieldOne(String addressFieldOne) {
        this.addressFieldOne = addressFieldOne;
    }

    public String getAddressFieldTwo() {
        return addressFieldTwo;
    }

    public void setAddressFieldTwo(String addressFieldTwo) {
        this.addressFieldTwo = addressFieldTwo;
    }

    public String getAddressFieldThree() {
        return addressFieldThree;
    }

    public void setAddressFieldThree(String addressFieldThree) {
        this.addressFieldThree = addressFieldThree;
    }

    public String getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    public String getAddressCountryCode() {
        return addressCountryCode;
    }

    public void setAddressCountryCode(String addressCountryCode) {
        this.addressCountryCode = addressCountryCode;
    }

    public String getAddressStateOrRegion() {
        return addressStateOrRegion;
    }

    public void setAddressStateOrRegion(String addressStateOrRegion) {
        this.addressStateOrRegion = addressStateOrRegion;
    }

    public String getAddressPostalCode() {
        return addressPostalCode;
    }

    public void setAddressPostalCode(String addressPostalCode) {
        this.addressPostalCode = addressPostalCode;
    }

    public String getAddressPhoneNumber() {
        return addressPhoneNumber;
    }

    public void setAddressPhoneNumber(String addressPhoneNumber) {
        this.addressPhoneNumber = addressPhoneNumber;
    }

    public String getOldOrderID() {
        return oldOrderID;
    }

    public void setOldOrderID(String oldOrderID) {
        if(oldOrderID != null){
            this.oldOrderID = oldOrderID.trim();
        }
    }


    public Date getResendDate() {
        return resendDate;
    }

    public void setResendDate(Date resendDate) {
        this.resendDate = resendDate;
    }

    public String getFulfillmentReason() {
        return fulfillmentReason;
    }

    public void setFulfillmentReason(String fulfillmentReason) {
        this.fulfillmentReason = fulfillmentReason;
    }

    public String getCustomerUploadPictures() {
        return customerUploadPictures;
    }

    public void setCustomerUploadPictures(String customerUploadPictures) {
        this.customerUploadPictures = customerUploadPictures;
    }

    public String getAddUser() {
        return addUser;
    }

    public void setAddUser(String addUser) {
        this.addUser = addUser;
    }


}
