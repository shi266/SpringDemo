package com.example.springdemo.com.test;


import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.springframework.util.ObjectUtils;

import java.io.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public Info demo(){
        Info info = new Info();
        info.setName("Demo");
        return info;

    }

    public static void main(String[] args) throws IOException, NoSuchMethodException {

        Date date = new Date(1648616400000l);
        Date date2 = new Date(1649826000000l);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        System.out.println(sdf.format(date));
        System.out.println(sdf.format(date2));

     /*   String context = "ASIN: B01KNVF4SI" +
                "\n" +
                "Thank you, dfhfhdfghdf564";
        String context2 =
                "ASIN: B07NC8PWDM, B01KNVF4SI, B08GYWZT5V, B08HN15QMJ, B07GZSDHSK, B08CZ7533B, B07GT6XYRC, B08GPKRRRJ, B075RC3FPY, B07H2V5YLH\n" +
                        "Titsle: image\n" +
                        "\n" +
                        "Thank you,";
        List<Info> list = new ArrayList<>();
        Info info = new Info();
        info.setName("sdf");
        info.setAddTime(new Timestamp(System.currentTimeMillis()));
        list.add(info);
        System.out.println(!ObjectUtils.isEmpty(list)?"true":"false");
*/
    /*    String context2 =
                "ASIN: B07NC8PWDM, B01KNVF4SI, B08GYWZT5V, B08HN15QMJ, B07GZSDHSK, B08CZ7533B, B07GT6XYRC, B08GPKRRRJ, B075RC3FPY, B07H2V5YLH\n" +
                "Titsle: image\n" +
                "\n" +
                "Thank you,";
        String context = "ASIN: B07NC8PWDM Thank you,";
        int startAsin = context.indexOf("ASIN:")+6;
        int endAsin = context.indexOf("Thank you,")-1;;

        if (context.contains("Title: image")){
            endAsin = context.indexOf("Title: image")-1;
        }
        String asin[] = context.substring(startAsin,endAsin-1).split(",");
        for (String s: asin) {
            System.out.println(s.trim());
        }
        System.out.println("------------");*/


      /*  Pattern findAsinPatten = Pattern.compile("^([A-Z]*[0-9]*){10}$");*/
//        Pattern findAsinPatten = Pattern.compile("[A-Z0-9]{10}");
//
//        Matcher m = findAsinPatten.matcher(context2);
//        while (m.find()) {
//            System.out.println(m.group()+" "+m.group().length());
//        }
/*
        List<String> list = new ArrayList<>();
        String a = "1,2,3";
        String b = "4,5,6";
        String[] arr1 = a.split(",");
        String[] arr2 = b.split(",");
        list.addAll(Arrays.asList(arr1));
        list.addAll(Arrays.asList(arr2));
        System.out.println(list);*/
//        GregorianCalendar calendar = new GregorianCalendar();
//        XMLGregorianCalendar gc = DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);
//        System.out.println(gc);
//

//        String ss = HttpUtil.createGet("http://localhost:8080/hutool?id=101&name=nnn").execute().body();
//        JSONObject obj = JSONObject.fromObject(ss);
//        ReturnJSON returnJSON = (ReturnJSON) JSONObject.toBean(obj,ReturnJSON.class);
//        String data = (String) returnJSON.getData();
//        System.out.println(ss);
//        System.out.println(data);

        //当前时间
//        Date date = DateUtil.date();
//        //当前时间
//        Date date2 = DateUtil.date(Calendar.getInstance());
//        //当前时间
//        Date date3 = DateUtil.date(System.currentTimeMillis());
//        //当前时间字符串，格式：yyyy-MM-dd HH:mm:ss
//        String now = DateUtil.now();
//        //当前日期字符串，格式：yyyy-MM-dd
//        String today= DateUtil.today();
//        System.out.println(today);
//        String dateStr = "2017-03-01";
//        Date date1 = DateUtil.parse(dateStr);
//        System.out.println(date1);
//        System.out.println(DateUtil.beginOfDay(date));
        //创建document对象


    }
}
class Info{
    private String name;
    private Timestamp addTime;

    public Timestamp getAddTime() {
        return addTime;
    }

    public void setAddTime(Timestamp addTime) {
        this.addTime = addTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
