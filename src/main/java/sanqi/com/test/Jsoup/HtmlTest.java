package sanqi.com.test.Jsoup;

import cn.hutool.http.HttpUtil;
import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import sanqi.com.util.DataUtil;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HtmlTest {


    public static void main(String[] args) throws IOException {



        String pageXml = HttpUtil.createGet("http://47.242.70.232:10382/crawlerService/crawler/getPageContent?entraceUrl=https://www.amazon.com/dp/B01M2ZI34E")
                .header("CrawlerServiceToken", DataUtil.md5("Pjd&hdfghq^!hdbf(0Sdbn"))
                .execute().body();
        System.out.println(pageXml);
        File file = new File("C:\\Users\\Administrator\\Desktop\\test.txt");
        //将写入转化为流的形式

        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        bw.write(pageXml);
        bw.close();
        System.out.println("写入完成");
        System.out.println("----------------------------------------");
        int startIndex = pageXml.indexOf("'dp60MainImage': '") + "'dp60MainImage': '".length();
        int endIndex = pageXml.indexOf(",", startIndex);
        String dp60MainImage = pageXml.substring(startIndex, endIndex - 1);

        String title = pageXml.substring(pageXml.indexOf("<title>")+7,pageXml.indexOf("</title>")-1);
        System.out.println(dp60MainImage);
        System.out.println(title);




/*

        String asinUrl  = "https://www.amazon.com/dp/B01M2ZI34E";
        Document doc = Jsoup.connect(asinUrl)
                .ignoreContentType(true)
                .ignoreHttpErrors(true)
                .get();
        String pageXml = doc.toString();
        int startIndex = pageXml.indexOf("'dp60MainImage': '") + "'dp60MainImage': '".length();
        int endIndex = pageXml.indexOf(",", startIndex);
        String dp60MainImage = pageXml.substring(startIndex, endIndex - 1);

        String title = pageXml.substring(pageXml.indexOf("<title>")+7,pageXml.indexOf("</title>")-1);
        System.out.println(dp60MainImage);
        System.out.println(title);
*/








    }
}
