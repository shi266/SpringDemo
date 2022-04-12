package sanqi.test;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import sanqi.com.entity.User;
import sanqi.com.mapper.LoginMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
public class Mybatis {
    /*
    * mybatis缓存
    *   一级缓存、二级缓存
    *
    * 一级缓存：session级别，cache只在session内部共享，当多次执行sql语句、参数相同且在同一个namespace下，从缓冲中获取数据
    * 当执行DML（insert、delete、update）操作时，缓存刷新（相当于清空），下次执行查询操作时从数据库查询数据，然后查询到的数据添加到一级缓存中。
    *
    * 二级缓存：mapper级别（同一个namespace下），session共享，默认关闭，相当于一个全局变量，开启二级缓存需要全局配置，指定命名空间，（单表查询<cache/>,
    * 多表查询<cache ref>指定多个命名空间，其他表执行DML操作时，缓存也会刷新），也可以指定方法关闭二级缓存（userable=false），
    *
    *
    * */

    @Resource
    private SqlSessionFactory sqlSessionFactory;

    @Resource
    LoginMapper loginMapper;



    @Test
    public void mybatisCache(){

        System.out.println("mybatis一级缓存范围"+sqlSessionFactory.getConfiguration().getLocalCacheScope());
        System.out.println("二级缓存是否启用："+sqlSessionFactory.getConfiguration().isCacheEnabled());
    }
    @Transactional
    @Test
    public void FirstCache(){
        User user = new User();
        user.setUsername("wang");
        user.setPassword("wwww");
        SqlSession session = sqlSessionFactory.openSession();
        LoginMapper mapper = session.getMapper(LoginMapper.class);
        for (int i = 0; i < 3; i++) {
            User u = loginMapper.valiteLogin(user);
            System.out.println(u);
        }
    }
    @Test
    public void valite(){
        User u = new User();
        SqlSession session1 = sqlSessionFactory.openSession(true);
        SqlSession session2 = sqlSessionFactory.openSession(true);
        LoginMapper mapper1 = session1.getMapper(LoginMapper.class);
        LoginMapper mapper2 = session2.getMapper(LoginMapper.class);

        User user1 = mapper1.getById(102);
        session1.commit();
        u.setUsername("李四2");
        u.setPassword("islisi");
        u.setAddress("canada");
        u.setId(102);
        mapper2.updateById(u);
        session1.commit();
        User user = mapper1.getById(102);
        session1.commit();
        User user2 = mapper2.getById(102);



    }

    @Test
    public void image() throws IOException {


        File file = new File("D:\\DemoTest\\123.jpg");
        if(!file.exists()){
            file.mkdirs();
        }
        byte[] bytes = loginMapper.getById(102).getImage();

        ByteArrayInputStream baos = new ByteArrayInputStream(bytes);
        BufferedImage bi = ImageIO.read(baos);
        ImageIO.write(bi,"jpg", new File(file + "demo.jpg"));


        System.out.println("success");
//
//        URL:http://39.102.73.90/AmazonWebServiceSiania/amazonListingFeedReocrd/submitAma
//        zonListingFeedRecord.do

//        URL:http://39.102.73.90/AmazonWebServiceSiania/amazonListingFeedReocrd/submitAma
//        zonListingFeedRecord?submitMethod=uploadProductImage&feedRecordID=FeedRecord1645
//        584872623&accountID=Siania
    }
//    @Test
    public void entity()  {

        Map<String,Object> paramMap = new HashMap<>();
        paramMap.put("id",112);
        String result = HttpUtil.get("localhost:8080/testinfo",paramMap);
//                .execute().body();

        System.out.println("result:"+result);
       User json =  JSONUtil.toBean(result,User.class);
        System.out.println(json.getPassword());
        System.out.println("接收的结果："+json);


    }
    @Test
    public void filePath()  {

        String path1 = this.getClass().getResource("/").getPath()+"amazonFeedListingImage/";
        String path2 = this.getClass().getResource("../").getPath()+"amazonFeedListingImage/";
        String path3 = this.getClass().getResource("../").getPath()+"amazonFeedListingImage/";
        System.out.println(path1);
        System.out.println(path2);
        System.out.println(path3);



    }


}
