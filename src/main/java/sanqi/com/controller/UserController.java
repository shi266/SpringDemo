package sanqi.com.controller;

import sanqi.com.entity.User;
import sanqi.com.mapper.LoginMapper;
import sanqi.com.mapper.UserMapper;
import sanqi.com.service.UserService;
import sanqi.com.test.redis.test.RedisService;
import sanqi.com.util.ReturnJSON;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.*;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;

@RestController
public class UserController {


    @Resource
    private  UserService userService;
    @Resource
    UserMapper userMapper;
    @Resource
    LoginMapper loginMapper;

    @Resource
    private RedisService redisService;

    @Resource
    private RedisTemplate<String, String> redisTemplate;
    @RequestMapping(value = "/returnData/{id}",method = RequestMethod.GET)
    public ReturnJSON demo(@PathVariable String id){
        ReturnJSON returnJSON = new ReturnJSON();
        returnJSON.setSuccess(true);
        returnJSON.setData("测试"+id);
        return  returnJSON;
    }



    @ResponseBody
    @RequestMapping("/sanqi/uploadExcel")
    public ReturnJSON batchAddAmazonFBAInventoryAgeProcessingRecordByExcel(MultipartFile excelFile,ReturnJSON returnJSONObject ) throws IOException, InvalidFormatException {

        String fileName = excelFile.getOriginalFilename();
        System.out.println("文件名："+fileName);


//        XSSFWorkbook workbook = new XSSFWorkbook(excelFile.getInputStream());
        Workbook workbook = WorkbookFactory.create(excelFile.getInputStream());
        //获取第一个sheet
        Sheet sheet =  workbook.getSheetAt(0);

        if(sheet!=null){
            Row row = sheet.getRow(1);
            Cell cell = row.getCell(20);
            System.out.println(cell.getStringCellValue());
        }


        returnJSONObject.setSuccess(true);
        returnJSONObject.setData("倒入成功");

        return returnJSONObject;
    }

    @GetMapping("/getUsers")
    @ResponseBody
    public ReturnJSON getUsers(HttpSession session){
//        StringBuffer url = request.getRequestURL();
//        StringBuffer uri = request.getRequestURL();
//        System.out.println(url.toString());
//        System.out.println(uri.toString());
        //返回json数据
        ReturnJSON returnJSON = new ReturnJSON();
        returnJSON.setSuccess(true);
        List<User> list1 = userService.getUsers();
        System.out.println("getUsers+  \t"+list1);
        returnJSON.setData(list1);
        System.out.println("转换json后的数据"+returnJSON.toString());

        return returnJSON;
    }

    /*
    * 添加数据
    * */
    @GetMapping("/addUSer")
    @ResponseBody
    public ReturnJSON addUSer(User user, ReturnJSON returnJSON) {
        //返回json数据
        System.out.println("准备添加数据");



        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY,0);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.MILLISECOND,0);

//        user.setAddDate(new Date(System.currentTimeMillis()-40500653));
        user.setAddDate(new Date(1644422445000l));
        boolean result = userMapper.addUSer(user);
        returnJSON.setSuccess(result);
       if(result){
           returnJSON.setData("添加成功");
       }else {
           returnJSON.setData("添加失败");
       }

        return returnJSON;

    }
    @GetMapping("/selectID")
    @ResponseBody
    public User selectId(User user ){
        System.out.println("this is ID:"+user.getId());
        System.out.println("根据ID查询");
        return loginMapper.selectById(user.getId());
    }
    @GetMapping("/testinfo")
    @ResponseBody
    public User testinfo(User user ){
        System.out.println("this is ID:"+user.getId());
        System.out.println("根据ID查询");
        user.setUsername("Demo");
        user.setPassword("DemoPassword");
        String picturesSavePath = this.getClass().getResource("/").getPath()+"amazonFeedListingImage/";
        String picturesSavePath3 = this.getClass().getResource("../").getPath()+"amazonFeedListingImage/";

        File file = new File(picturesSavePath);
        if(!file.exists()){
            System.out.println("不存在就创建");
            file.mkdirs();
        }
        String picturesSavePath2 = this.getClass().getResource("").getPath();
        System.out.println("picturesSavePath3:"+picturesSavePath3);
        System.out.println(picturesSavePath);
        System.out.println(picturesSavePath2);
        return user;
    }

    /*
    * 修改数据
    * */
    @PostMapping("/updateUser")
    @ResponseBody
    public ReturnJSON updateUser(@RequestParam MultipartFile[] pictures, User user, ReturnJSON returnJSON, HttpServletRequest request) throws IOException {

        pictures[0].getContentType();
        System.out.println("===================================");
        System.out.println( pictures[0].getSize()/(1024*1024)<1.0?"小于1M":"大于1M");
        System.out.println( pictures[0].getBytes());
        System.out.println(pictures[0].getInputStream().available());


        System.out.println("===================================");

        if(pictures.length!=0){
            System.out.println("图片进入后台");
        //将图片转换成字节
            BufferedImage bi;
            ByteArrayOutputStream bos;
            try {
//                bi = ImageIO.read(pictures[0].getInputStream());
//                bos =new ByteArrayOutputStream();
//                ImageIO.write(bi,"jpg",bos);
//                byte[] bytes = bos.toByteArray();
//                user.setImage(bytes);
                user.setImage(pictures[0].getBytes());

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        //返回json数据
        System.out.println("准备修改数据");
        boolean result = userMapper.updateUser(user);
        returnJSON.setSuccess(result);

           returnJSON.setData(result?"修改成功":"修改失败");


        return returnJSON;

    }
    /*
    * 删除数据
    * */
    @PostMapping("/deleteUser")
    @ResponseBody
    public ReturnJSON deleteUser(int id,ReturnJSON returnJSON) {
        //返回json数据
        System.out.println("准备删除数据");
        boolean result = userMapper.deleteUser(id);
        System.out.println("shan chu de shu ju wei :"+id);
        returnJSON.setSuccess(result);
       if(result){
           returnJSON.setData("删除成功");
       }
        System.out.println("删除成功"+returnJSON.toString());
        return returnJSON;

    }

    @PostMapping("/upload")
    @ResponseBody
    public ReturnJSON upload(@RequestParam MultipartFile file, ReturnJSON returnJSON) throws IOException {
        String filetext  = "C:/Users/Administrator/Desktop/data2.txt";
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(filetext,true);
        InputStream in = file.getInputStream();
        //获取Excel
        Workbook workbook = new HSSFWorkbook(in);
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
            fileWriter.write(str);
        }
        returnJSON.setData("success");
        returnJSON.setSuccess(true);
        fileWriter.flush();
        fileWriter.close();
    }catch (Exception e){
        e.printStackTrace();
    }



        return returnJSON;
    }

}
