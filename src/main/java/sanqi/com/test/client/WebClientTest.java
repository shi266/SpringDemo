package sanqi.com.test.client;


import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.net.MalformedURLException;

public class WebClientTest {

    public static void main(String[] args) {
        long t1 = System.currentTimeMillis();
        WebClient client = new WebClient(BrowserVersion.FIREFOX_45);
        client.getOptions().setJavaScriptEnabled(false);//解析JS
        client.getOptions().setCssEnabled(false);//应该是CSS样式？？
        try {
               HtmlPage page = client.getPage("https://www.amazon.com/dp/B00JVLIMKO");
            System.out.println("rrrrrrrrrrrr");
            System.out.println(page.getWebResponse().getStatusCode());
            if(page.getWebResponse().getStatusCode()!=200){
                System.out.println(page.getWebResponse().getStatusCode());
                return;
            }
            if (page.getElementById("captchacharacters") != null) {
                System.out.println("访问出现机器验证了。");
            }
            String pageXml = page.asXml();//以xml的形式响应文本

            int startIndex = pageXml.indexOf("'dp60MainImage': '") + "'dp60MainImage': '".length();
            int endIndex = pageXml.indexOf(",",startIndex);

            String dp60MainImage = pageXml.substring(startIndex,endIndex - 1);


            System.out.println(page.getElementsByTagName("title").get(0).getTextContent());

            System.out.println(dp60MainImage);
            //dp60MainImage
        } catch (MalformedURLException e) {
            System.out.println("11222222");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("2222333");
            e.printStackTrace();
        }catch (FailingHttpStatusCodeException e) {
               System.out.println("222222222222");
               return;
           }


    }



    }

//    HtmlPage page = client.getPage("https://" + station.getBaseUrl() + "/dp/" + asin);
//            if (page.getElementById("captchacharacters") != null) {
//        //访问出现机器验证了。
//        returnJSON.setSuccess(false);
//        returnJSON.setData("出现机器验证，核对失败，请联系管理员");
//        return returnJSON;
//    }
//
//    DomElement reviewEls = page.getElementById("cm-cr-dp-review-list");
//    Document doc = Jsoup.parse(reviewEls.asXml());
//    Elements reviewStarRatings = doc.getElementsByAttributeValue("data-hook","review-star-rating");
//            if (CollectionUtils.isEmpty(reviewStarRatings)) {
//        returnJSON.setSuccess(false);
//        returnJSON.setData("详情页面没有评价");
//        return returnJSON;
//    }
//    Element reviewStarRating = null;
//    String reviewStarRatingString = null;
//            for (int i = 0; i < reviewStarRatings.size(); i ++) {
//        reviewStarRating = reviewStarRatings.get(i);
//        reviewStarRatingString = reviewStarRating.attr("class");
//        reviewStarRatingString = reviewStarRatingString.replaceAll("[^\\d]","");
//        if (Integer.valueOf(reviewStarRatingString) <= 3) {
//            returnJSON.setSuccess(false);
//            returnJSON.setData("详情页面还有差评，请核对");
//            return returnJSON;
//        }
//    }