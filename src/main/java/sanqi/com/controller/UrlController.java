package sanqi.com.controller;

import sanqi.com.entity.User;
import sanqi.com.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

@Controller
public class UrlController {

    //登录
        @GetMapping("/tologin")
        public String tttt(){
            System.out.println("准备进入后台页面");
            return  "login.html";
        }
        @GetMapping("/nginx")
        public String nginx(){
            return  "nginx.html";
        }
        @GetMapping("/boot/index")
        public String bootIndex(){
            return  "boot/index";
        }
        @GetMapping("/erp")
        public String erp(){
            return  "erp";
        }




    @GetMapping("/testinfo2")
    @ResponseBody
    public User testinfo(User user ){
        System.out.println("this is ID:"+user.getId());
        System.out.println("根据ID查询ssss");
        user.setUsername("Demo");
        user.setPassword("DemoPassword");

        return user;
    }
    @GetMapping("/exit")
    @ResponseBody
    public String exitlogin(HttpSession session){
        System.out.println("进入exitlogin");

        return "exit";
    }
    @GetMapping("/toSavePicture")
    public String login() throws FileNotFoundException {
//获取跟目录
        File path = new File(ResourceUtils.getURL("static/img").getPath());
        System.out.println("准备进入登录页面");
        System.out.println("相对路径"+path);
        return  "saveImg.html";
    }

    @GetMapping("/savePi")
    public String login2(){

        System.out.println("准备进入登录页面");
        return  "savePicture.html";
    }
    @ResponseBody
    @RequestMapping("/index2")
    public ModelAndView index(ModelAndView model){
        System.out.println("准备进入首页页面index");
        model.addObject("name","asfidshfisd");
        model.setViewName("lo");
        return  model;
    }
    @GetMapping("/vlogin")
    public String data(){

        System.out.println("准备进入首页页面");
        return  "Vlogin.html";
    }
    @GetMapping("/index")
    public String in(){

        System.out.println("准备进入首页页面");
        return  "index.html";
    }
    @GetMapping("/tree")
    public String tree(){

        System.out.println("准备进入首页页面");
        return  "tree.html";
    }
    @GetMapping("/user")
    public String user(){

        System.out.println("准备进入首页页面");
        return  "YLDemo/userList.html";
    }
    @GetMapping("/userTree")
    public String userTree(){

        System.out.println("准备进入UserTree页面");
        return  "YLDemo/test.html";
    }

    @GetMapping("/send")
    public String send(){
        System.out.println("准备进入后台页面");
        return  "QQ/send.html";
    }
@Autowired
UserMapper userMapper;
    @GetMapping("/responseDownload")
    public String responseDownload(HttpServletResponse response) throws IOException {

        try {
//            response.sendError(404);
            response.sendError(500,"找不到回家的路了");

        }catch (Exception e){
            e.printStackTrace();
        }
        return  "login.html";
    }

    @RequestMapping("wwwcilent")
    public  String getHttpClient(String name,String password){
       /* System.out.println("webclient准备执行");
        System.out.println("Schedule GenerateAmazonAdvertisingCampaignStatisticJob");
        String jobName = System.currentTimeMillis() + "_GenerateAmazonAdvertisingCampaignStatisticJob";
        String cronTriggerName = System.currentTimeMillis() + "_Trigger";
        String cronTriggerGroupName = cronTriggerName + "_Group";
        CronTrigger cronTrigger = quartzUtil.createCronTrigger(cronTriggerName,cronTriggerGroupName,"0/5 * * * * ?");
        JobDataMap jobDataMap = new JobDataMap();
        JobDetail jobDetail = quartzUtil.createCronScheduleJob(jobName, ProductTwo.class,jobDataMap);

        try {
            quartzUtil.scheduleJob(jobDetail,cronTrigger);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
*/
        return "这是你的用户名："+name+"\n这是你的密码："+password;

    }

}
