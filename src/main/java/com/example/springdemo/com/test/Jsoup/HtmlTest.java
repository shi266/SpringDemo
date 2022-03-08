package com.example.springdemo.com.test.Jsoup;

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

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HtmlTest {


    public static void main(String[] args) throws IOException {



       Document document = Jsoup.connect("https://xy.51job.com/default-xs.php").get();

        Elements element = document.select("div.cmsg");
       Elements e2 = element.first().select("div.ctxt").first().select("div.cell >div.e");


        for (Element e: e2) {

            String zhiwei = e.select("a[target]").first().text();
            String city = e.select("span").text();
            String country = e.select("a[target]").last().text();
            System.out.print(zhiwei+"\t\t");
            System.out.println(city+"\t\t");
            System.out.println(country);
            System.out.println("-------------------------------------------");
        }












//       Document document = Jsoup.connect("https://www.amazon.com/dp/B07L2Y62G2").get();
//            List<String> list = new ArrayList<>();

          /*  Elements element = document.select("div.celwidget >" +
                    "div.a-section >" +
                    "ul.a-unordered-list >" +
                    "li >" +
                    "span.a-list-item");
        for (Element e:element) {
            list.add(e.text());
        }

        for (String s: list) {
            System.out.println(s);
            System.out.println("-----------------------------------------");
        }
*/
    }
}
