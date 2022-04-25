package sanqi.com.mapper;
import org.apache.ibatis.annotations.Mapper;
import sanqi.com.entity.AmazonSellerFulfillmentOrder;
import sanqi.com.entity.AmazonSellerFulfillmentOrderQueryParam;

import java.util.List;

@Mapper
public interface AmazonSellerFulfillmentOrderSet {


    List<AmazonSellerFulfillmentOrder> getAllAmazonSellerFulfillmentOrders(AmazonSellerFulfillmentOrderQueryParam queryParam);

}
