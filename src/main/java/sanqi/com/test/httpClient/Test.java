package sanqi.com.test.httpClient;

import cn.hutool.http.HttpUtil;
import sanqi.com.service.ChoiceService;
import sanqi.com.util.ReturnJSON;
import net.sf.json.JSONObject;

import java.io.*;

class GetData extends Thread{

    @Override
    public void run() {
        int i = 0;
            while (true){
                if(i>2){break;}

                String result = HttpUtil.createGet("http://localhost:8080/returnData")
                        .execute().body();
                System.out.println(result);
                ReturnJSON returnJSON = (ReturnJSON) JSONObject.toBean(JSONObject.fromObject(result),ReturnJSON.class);
                System.out.println(returnJSON.getSuccess());
                System.out.println(returnJSON.getData());
                if(returnJSON.getSuccess()){
                    System.out.println("结束执行");
                    break;
                }else{
                    System.out.println("休息10S");
                    try {
                        Thread.sleep(1000*10);
                        i++;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
    }
}

public class Test {

    public static void serinal(){
        int s = 0;
        long j = 0;
        int count = 1000000000;
        long a = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            s++;
        }
        long b = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            j++;
        }

        long c = System.currentTimeMillis();
        System.out.println("s:"+s);
        System.out.println("自增"+count+"次花费的时间："+(b-a)+"ms");
        System.out.println("j:"+j);
        System.out.println("自增"+count+"次花费的时间："+(c-b)+"ms");

    }


    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
//        String className = "Animal";
        String className = "Fruits";
        String basePackage = ChoiceService.class.getPackage().getName();
        Class<?> choiceImpl = Class.forName(basePackage +
                ".impl." + className +"Impl");
        ChoiceService service = (ChoiceService)choiceImpl.newInstance();
        String data = service.getData("测试");
        System.out.println(data);



       /* Thread t = new Thread(()-> {
            System.out.println("hello thread");
        });
        t.start();
*/



//        long a = System.currentTimeMillis();
//        String pageXml2 = HttpUtil.createGet("http://47.242.70.232:10382/crawlerService/crawler/getPageContent?entraceUrl=" + "https://www.amazon.com/dp/B075WQMLXR")
//                .header("CrawlerServiceToken", DataUtil.md5("Pjd&hdfghq^!hdbf(0Sdbn"))
//                .execute().body();
//        long b = System.currentTimeMillis();
//        int startIndex2 = pageXml2.indexOf("'dp60MainImage': '") + "'dp60MainImage': '".length();
//        int endIndex2 = pageXml2.indexOf(",", startIndex2);
//
//        String dp60MainImage = pageXml2.substring(startIndex2, endIndex2 - 1);
//        System.out.println(dp60MainImage);
//        System.out.println(pageXml2.substring(pageXml2.indexOf("<title>")+7,pageXml2.indexOf("</title>")-1));
//        long c = System.currentTimeMillis();
////        System.out.println("--------------");
////        System.out.println(dp60MainImage);
//        System.out.println("获取页面：" + (a - b));
//        System.out.println("解析数据：" + (b - c));
//        System.out.println("--------------使用Jsoup-----------");
//        long d = System.currentTimeMillis();
//        Document doc = Jsoup.connect("https://www.amazon.com/dp/B075WQMLXR").get();
//        long e = System.currentTimeMillis();
//        System.out.println("获取页面时间：" + (d - e));
//        String pageXml = doc.toString();
//        long f = System.currentTimeMillis();
//        System.out.println("页面转字符时间：" + (e - f));
//        int startIndex = pageXml.indexOf("'dp60MainImage': '") + "'dp60MainImage': '".length();
//        int endIndex = pageXml.indexOf(",", startIndex);
//
//        String dp60MainImage2 = pageXml.substring(startIndex, endIndex - 1);
//        long g = System.currentTimeMillis();
//        System.out.println(dp60MainImage2);
//        System.out.println(doc.title());
//        System.out.println("解析页面内容时间：" + (f - g));
//        File file = new File("C:\\Users\\Administrator\\Desktop\\test.txt");
//        //将写入转化为流的形式
//
//        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
//        bw.write(pageXml);
//        bw.close();
//        System.out.println("写入完成");
        /*//获取客户端
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        //参数
        StringBuffer params = new StringBuffer();
        try {
            params.append("name=张三"+ URLEncoder.encode("&","utf-8"));
            params.append("&");
            params.append("password=zhang");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //创建get请求
//        HttpGet httpGet = new HttpGet("http://localhost:8080/getUsers");
        HttpGet httpGet = new HttpGet("https://www.amazon.com/dp/B075WQMLXR");
        CloseableHttpResponse response = null;
        //响应
       try {
            response = httpClient.execute(httpGet);
           HttpEntity entity = response.getEntity();
           System.out.println("响应状态："+response.getStatusLine());

           if(entity!=null){
               System.out.println("响应内容长度："+entity.getContentLength());
               System.out.println("响应内容为："+ EntityUtils.toString(entity));
           }
           


       } catch (ClientProtocolException e) {
           e.printStackTrace();
       } catch (IOException e) {
           e.printStackTrace();
       }finally {
           //释放资源
         try {
             if(httpClient!=null){
                 httpClient.close();
             }
             if(response!=null){
                 response.close();
             }
             
         } catch (IOException e) {
             e.printStackTrace();
         }
       }
*/
    }

}
