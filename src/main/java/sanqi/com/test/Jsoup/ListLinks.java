package sanqi.com.test.Jsoup;

import org.jsoup.Jsoup;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

/*
* Example program to list links from a url
* */
public class ListLinks {


    public static void main(String[] args) throws IOException {

//        Validate.isTrue(args.length == 1,"usage: supply url to fetch");
        Document doc = Jsoup.connect("http://jsoup.org").get();

        Element link = doc.select("a ").last();
        String relHref = link.attr("href"); // == "/"
        String rel = link.attr("rel"); // == "/"
        String absHref = link.attr("abs:href"); // "http://jsoup.org/"
        System.out.println(link.text());
        System.out.println(relHref);
        System.out.println(rel);
        System.out.println(absHref);

    }

}
