package sanqi.com.controller;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import sanqi.com.Page.BasePage;
import sanqi.com.entity.*;
import sanqi.com.mapper.AmazonSellerFulfillmentOrderSet;
import sanqi.com.mapper.GetUserMapper;
import sanqi.com.mapper.UserMapper;
import sanqi.com.util.ReturnJSON;
import sanqi.com.util.ReturnPageJson;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import sanqi.com.util.ZipUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
public class GetUserController {

    @Autowired
    GetUserMapper getUserMapper;
    @Autowired
    UserMapper userMapper;

    @Resource
    private Person person;

    @Resource
    private SqlSessionFactory sqlSessionFactory;
//    @Autowired
//    private LoginMapper userMapper;



    @Resource
    AmazonSellerFulfillmentOrderSet amazonSellerFulfillmentOrderSet;
    @GetMapping("/zip")
    @ResponseBody
    public void getzip(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String path = "D:/savePic";
        String name = "测试ceshi";
                name  =   new String(name.getBytes("UTF-8"), "ISO8859_1");
        response.setContentType("application/zip");
        response.setHeader("Content-Disposition", "attachment; filename="+name+".zip");
        ZipUtils.toZip(path, response.getOutputStream(), false);
    }

    @GetMapping("/getAmazon")
    @ResponseBody
    public String getData(){
        AmazonSellerFulfillmentOrderQueryParam param = new AmazonSellerFulfillmentOrderQueryParam();
//        param.setResendDate(java.sql.Date.valueOf("2022-04-18"));
        List<AmazonSellerFulfillmentOrder> orders = amazonSellerFulfillmentOrderSet.getAllAmazonSellerFulfillmentOrders(param);
        System.out.println("数据条数："+orders.size());
        return "数据条数："+orders.size();
    }

    @GetMapping("/getUsersall")
    @ResponseBody
    public List getUser(ReturnPageJson returnJSON, User user, BasePage basePage, HttpSession session){
//        SqlSession session1 = sqlSessionFactory.openSession(true);
//        GetUserMapper mapper = session1.getMapper(GetUserMapper.class);
//
//        mapper.getAll(user);
//        mapper.getAll(user);


        //返回json数据
        System.out.println("获取数据：getUsersall");
        returnJSON.setSuccess(true);
        List<User> list1 = getUserMapper.getAll(user);
        returnJSON.setData(list1);
        returnJSON.setTotalRows(getUserMapper.getRows(user));//数据总条数

        return list1;
    }
    @GetMapping("/getByUserName")
    @ResponseBody
    public ReturnPageJson getByUserName(ReturnPageJson returnJSON, User user, BasePage basePage){
        System.out.println("自动执行的controller方法-------------");
        //返回json数据
        returnJSON.setSuccess(true);
        List<User> list1 = getUserMapper.getByUserName(user.getUsername());
        returnJSON.setData(list1);
        returnJSON.setTotalRows(getUserMapper.getRows(user));//数据总条数


        return returnJSON;
    }
    @GetMapping("/getFee")
    @ResponseBody
    public ReturnPageJson getFee(ReturnPageJson returnJSON, User user){
        //返回json数据
        System.out.println("开始计算费用");
        System.out.println(person);
        returnJSON.setSuccess(true);
        List<User> list1 = getUserMapper.getExcel(user);
        int sum= 0;
        for (int i = 0; i < list1.size(); i++) {
            sum+= list1.get(i).getId();
        }
        System.out.println("总费用："+sum);
        returnJSON.setData(sum);
        return returnJSON;
    }
    //获取用户名

    @GetMapping("/getUserName")
    @ResponseBody
    public ReturnJSON getUserName(ReturnJSON returnJSON){
        //返回json数据
        returnJSON.setSuccess(true);
        List<UserName> list1 = getUserMapper.getUserName();
        returnJSON.setData(list1);
        System.out.println(returnJSON);
        return returnJSON;
    }

/*
* 使用模板导出Excel
* */
    @GetMapping("/getTemplateExcel")
    @ResponseBody
    public void getTemplateExcel(HttpServletResponse response) throws IOException {
        //创建configuration
        Configuration configuration = new Configuration();
        //设置编码
        configuration.setDefaultEncoding("UTF-8");
        //设置数字格式
        configuration.setNumberFormat("0");
        //设置模板所存在位置路径
        configuration.setDirectoryForTemplateLoading(ResourceUtils.getFile("classpath:"));
        configuration.setObjectWrapper(new DefaultObjectWrapper());
        //加载模板（模板名称）
        Template template = configuration.getTemplate("investigationTable_excel.ftl","UTF-8");
        OutputStreamWriter writer = null;
        List<User> list1 = userMapper.getUsers();
        Map<String,Object> map = new HashMap<>();
        map.put("userlist",list1);

        try {
            response.reset();
            response.setContentType("application/msexcel;charset=UTF-8");
            response.addHeader("Content-Disposition", "attachment;filename=\"" + new String(("重发订单数据.xls").getBytes("UTF-8"),"ISO8859_1") + "\"");
            writer = new OutputStreamWriter(response.getOutputStream(),"UTF-8");
            //加载数据
            template.process(map,writer);
            writer.flush();

        }catch (Exception e){
            e.printStackTrace();
        } finally {
            writer.close();
            System.out.println("创建完成！");
        }

    }
    /*
     * 导出excel
     * */

    @RequestMapping("/getExcel")
    @ResponseBody
    public void UserExcel(User user, HttpServletResponse response){
        System.out.println("准备导出Excel");
        List<User> list = getUserMapper.getExcel(user);
        System.out.println(list);
        //创建一个Excel
        HSSFWorkbook workbook = new HSSFWorkbook();
        //创建一个sheet
        HSSFSheet sheet = workbook.createSheet();
        //设置Excel  sheet表名
        workbook.setSheetName(0,"用户数据");
        //创建表头
        String[] headers = new String[]{
                "编号","用户名","密码","地址"
        };
        //创建表头 第一行
        HSSFRow row = sheet.createRow(0);
        //设置列名
        for (int i = 0; i < headers.length; i++) {
            HSSFCell hssfCell = row.createCell(i);
            hssfCell.setCellValue(new HSSFRichTextString(headers[i]));
        }
        //获取数据总条数、逐行写入数据
        for (int i = 0; i < list.size(); i++) {
            HSSFRow row1 = sheet.createRow(i+1);
            User order = list.get(i);
            row1.createCell(0).setCellValue(order.getId());
            row1.createCell(1).setCellValue(order.getUsername());
            row1.createCell(2).setCellValue(order.getPassword());
            row1.createCell(3).setCellValue(order.getAddress());
        }
        response.reset();
        response.setContentType("application/msexcel;charset=UTF-8");
        try{
            response.addHeader("Content-Disposition", "attachment;filename=\"" + new String(("用户数据.xls").getBytes("UTF-8"),"ISO8859_1") + "\"");
            OutputStream out = response.getOutputStream();
            workbook.write(out);
            out.flush();
            out.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @GetMapping("/readExcel")
    @ResponseBody
    public void readExcel(){
        String filetext  = "C:/Users/Administrator/Desktop/data.txt";
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(filetext,true);



            File excelfile = new File("C:/Users/Administrator/Desktop/用户数据.xls");

            FileInputStream is = new FileInputStream(excelfile);
            //获取Excel
            Workbook workbook = new HSSFWorkbook(is);
            //获取sheet
            Sheet sheet = workbook.getSheetAt(0);
            //获取表头
            Row head = sheet.getRow(0);
            //获取数据总行数
            int totalRowNum = sheet.getLastRowNum();
            //字段
            String id = "";
            String username = "";
            String password = "";
            String address = "";
            //获取所有数据
            for (int i = 0; i < totalRowNum+1; i++) {
                //获得每一行数据
                Row line = sheet.getRow(i);
                id=line.getCell(0).toString();
                username=line.getCell(1).toString();
                password=line.getCell(2).toString();
                address=line.getCell(3).toString();
                System.out.println(id+"\t"+username+"\t"+password+"\t"+address);
                String str = id+"\t"+username+"\t"+password+"\t"+address+"\n";
//将从Excel读取的数据添加到数据库
//                User user = new User();
//                user.setUsername(username);
//                user.setPassword(password);
//                user.setAddress(address);
//                userMapper.addUSer(user);
                fileWriter.write(str);
            }

            fileWriter.flush();
            fileWriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    static  int num =1;
  public void each(){
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      System.out.println(sdf.format(new Date())+":\t每10秒执行一次,这是第"+(num++)+"次");
  }
//    @Override
//    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
//
//        taskRegistrar.addTriggerTask(new Runnable() {
//            @Override
//            public void run() {
//
////                each();
//            }
//        }, new Trigger() {
//            @Override
//            public Date nextExecutionTime(TriggerContext triggerContext) {
//                Calendar cal = Calendar.getInstance();
//                cal.add(Calendar.SECOND,10);
//                Date nextDate = new Date(cal.getTimeInMillis());
//                return nextDate;
//            }
//        });
//    }
}
