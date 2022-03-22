package com.example.springdemo.com.test;

import com.example.springdemo.com.entity.RecruitmentInformation;
import com.example.springdemo.com.util.HttpUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RecruitmentInformationTask {


    public static void main(String[] args) throws Exception {
        //        //1.声明地址=》校园招聘前程无忧网站
        String url = "https://xy.51job.com/default-xs.php";

        //2.解析页面

        String html = HttpUtils.doGetHtml(url );
        //解析页面，获取商品数据并存储
        new RecruitmentInformationTask().parse(html);


        System.out.println("数据抓取完成！");
    }


    public void parse(String html){
        Document doc = Jsoup.parse(html);
//        logger.info(String.valueOf(doc));
        //2.获取招聘信息
        Elements spuEles = doc.select("div.t-list");
//        logger.info(String.valueOf(spuEles));
        List<RecruitmentInformation> list = new ArrayList<>();
        int id = 1;
        for (Element spuEle : spuEles){
            //获取招聘标题
            String topic = spuEle.select("[tr]").attr("ticket_2400000G1510_01_05");
            //获取招聘公司url
            String url = spuEle.select("[target]").attr("href");
            //获取招聘公司名字
            Elements names = spuEle.select("span");
            String name=names.get(0).text();
            //获取招聘公司所在的位置
            String location = spuEle.select("[class]").attr("title");
//            logger.info(topic,name,url,location);
            RecruitmentInformation recruitmentInformation=new RecruitmentInformation();
            recruitmentInformation.setId(id++);
            recruitmentInformation.setCreated(new Date());
            recruitmentInformation.setCompanylocation(location);
            recruitmentInformation.setUrl(url);
            recruitmentInformation.setRecruitmenttopic(topic);
            recruitmentInformation.setRecruitmentcompany(name);

            //8.保存数据库
            list.add(recruitmentInformation);
//            logger.info("成功保存");
        }
        for (RecruitmentInformation r: list) {
            System.out.println(r);
        }
    }

}
