package sanqi.com.test;


import org.springframework.util.ObjectUtils;
import sanqi.com.util.ZipUtils;

import java.io.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public Info demo(){
        Info info = new Info();
        info.setName("Demo");
        return info;

    }

    public static void main(String[] args) throws IOException, NoSuchMethodException, ParseException {


        String path = "D:\\savePic\\demoerror.jpg";
        String path2 = "D:\\savePic";
        String save = "C:\\Users\\Administrator\\Desktop";
        File file = new File(path);

//        _E__project_sqe_WEB-INF_classes_amazonProductPackagePartDesign_US_         sms-videoinstruction-001-   .zip


       /* Info info = new Info();
        info.setStartDate(Date.valueOf("2022-04-19"));
        info.setEndtDate(Date.valueOf("2022-03-27"));

        int day = (int) ((info.getStartDate().getTime()-info.getEndtDate().getTime())/(1 *24 *60*60*1000));
        System.out.println(day);*/








         /*   String bb = "B09WYJSK15  \n" +
                    "B099PMHTJT    \n" +
                    "B09SHR23SX    \n" +
                    "B09BL3D5HK    \n" +
                    "B09NPVY8J6      \n" +
                    "B09SHP8MCP    \n" +
                    "B099PN26XC  ";
            String [] str = bb.split("\n");
        for (String s : str) {
            System.out.println(s.trim()+",");
        }


        Info info = new Info();
        info.setResendDate(new Date(new SimpleDateFormat("yyyy-MM-dd").parse("2022-04-18").getTime()));
        String dateFormat = new SimpleDateFormat("yyyyMMdd").format(info.getResendDate());
        String newID =  "ASRO"+dateFormat+String.format("%03d", 1);
        System.out.println(newID);
        String sub = newID.substring(newID.length()-3,newID.length());
        newID = "ASRO"+ dateFormat +String.format("%03d", Integer.valueOf(sub) + 1);
        System.out.println(newID);*/
      /*  Date today = new Date(System.currentTimeMillis());
        String dateFormat = new SimpleDateFormat("yyyyMMdd").format(today);
        String  newID = "ASRO" + dateFormat +String.format("%03d", 1);
        System.out.println(newID);
        String maxID="ASRO20211205004";
        String sub = maxID.substring(maxID.length()-3,maxID.length());
        newID = "ASRO"+ dateFormat +String.format("%03d", Integer.valueOf(sub) + 1);

        System.out.println(new SimpleDateFormat("yyyy-MM-dd").parse("2022-04-18"));*/
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndtDate() {
        return endtDate;
    }

    public void setEndtDate(Date endtDate) {
        this.endtDate = endtDate;
    }

    private Date startDate;
    private Date endtDate;


    public Date getResendDate() {
        return resendDate;
    }

    public void setResendDate(Date resendDate) {
        this.resendDate = resendDate;
    }

    private Date resendDate;

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
