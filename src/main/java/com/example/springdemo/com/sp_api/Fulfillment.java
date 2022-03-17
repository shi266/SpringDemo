package com.example.springdemo.com.sp_api;

import com.amazon.sellingpartnerapi.ApiException;
import com.amazon.sellingpartnerapi.ApiResponse;
import com.amazon.sellingpartnerapi.client.FbaOutboundApi;
import com.amazon.sellingpartnerapi.models.fulfillmentOutbound.*;
import com.example.springdemo.com.sp_api.spConfig.Config;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class Fulfillment {

    public void fulfillmentsend() throws ApiException {

        FbaOutboundApi client =FulfillmentUtil.getFbaOutbountInstance(new Config());

            CreateFulfillmentOrderRequest request = new CreateFulfillmentOrderRequest();
            request.setMarketplaceId("marketplaceId");
            request.sellerFulfillmentOrderId("FulfillmentID");
            request.setDisplayableOrderId("oldOrderId");
            request.setDisplayableOrderDate("2022-03-14");
            request.setDisplayableOrderComment("备注");
            request.setShippingSpeedCategory(ShippingSpeedCategory.STANDARD);
        //Address
        Address address = new Address();
        address.setName("");
        address.setAddressLine1("");
        address.setAddressLine2("");
        address.setAddressLine2("");
        address.setCity("");
        address.setStateOrRegion("");
        address.setPostalCode("");
        address.setCountryCode("");

        request.setDestinationAddress(address);

        //Items
        CreateFulfillmentOrderItemList createFulfillmentOrderItemList = new CreateFulfillmentOrderItemList();
        CreateFulfillmentOrderItem createFulfillmentOrderItem = new CreateFulfillmentOrderItem();
        createFulfillmentOrderItem.setSellerSku("");
        createFulfillmentOrderItem.setSellerFulfillmentOrderItemId("");
        createFulfillmentOrderItem.setQuantity(1);
        createFulfillmentOrderItemList.add(createFulfillmentOrderItem);
        request.setItems(createFulfillmentOrderItemList);
        try {
            ApiResponse<CreateFulfillmentOrderResponse> fulfillmentOrderWithHttpInfo = client.createFulfillmentOrderWithHttpInfo(request);
            if(fulfillmentOrderWithHttpInfo.getStatusCode()==200){
                Map<String, List<String>> headers = fulfillmentOrderWithHttpInfo.getHeaders();
                headers.get("x-amzn-RequestId");
            }
            //获取订单
            GetFulfillmentOrderResponse response = client.getFulfillmentOrder("");
            GetFulfillmentOrderResult result = response.getPayload();
            FulfillmentOrder fulfillmentOrder = result.getFulfillmentOrder();
            String sellerFulfillmentOrderId = fulfillmentOrder.getSellerFulfillmentOrderId();
            Address destinationAddress = fulfillmentOrder.getDestinationAddress();
            String addressName = destinationAddress.getName();


        } catch (ApiException e) {
            e.printStackTrace();
        }


    }



}
