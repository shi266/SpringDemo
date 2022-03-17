package com.example.springdemo.com.sp_api;

import com.amazon.sellingpartnerapi.ApiException;
import com.amazon.sellingpartnerapi.client.FbaOutboundApi;
import com.amazon.sellingpartnerapi.models.fulfillmentOutbound.*;
import com.example.springdemo.com.sp_api.spConfig.Config;

public class GetFulfillmentPreview {

    public void   getFulfillmentPreview () throws ApiException {
        FbaOutboundApi client =FulfillmentUtil.getFbaOutbountInstance(new Config());

        GetFulfillmentPreviewRequest request = new GetFulfillmentPreviewRequest();


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
        request.setAddress(address);

        GetFulfillmentPreviewItemList getFulfillmentPreviewItems = new GetFulfillmentPreviewItemList();
        GetFulfillmentPreviewItem getFulfillmentPreviewItem = new GetFulfillmentPreviewItem();
        getFulfillmentPreviewItem.setSellerFulfillmentOrderItemId("");
        getFulfillmentPreviewItem.setQuantity(1);
        getFulfillmentPreviewItem.setSellerSku("");
        request.setItems(getFulfillmentPreviewItems);

        GetFulfillmentPreviewResponse response = client.getFulfillmentPreview(request);
        GetFulfillmentPreviewResult result = response.getPayload();
        FulfillmentPreviewList fulfillmentPreviews = result.getFulfillmentPreviews();
        for (FulfillmentPreview fulfillmentPreview : fulfillmentPreviews) {
            if(fulfillmentPreview.getFulfillmentPreviewShipments().equals("")){
                FeeList estimatedFees = fulfillmentPreview.getEstimatedFees();
                for (Fee estimatedFee : estimatedFees) {
                    if(estimatedFee.getName().equals("FBAPerUnitFulfillmentFee")){
                        String fee = estimatedFee.getAmount().getValue();
                    }

                }
            }
        }


    }


}
