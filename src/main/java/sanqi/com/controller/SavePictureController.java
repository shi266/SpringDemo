package sanqi.com.controller;

import sanqi.com.service.impl.SavePictureServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

@RestController
public class SavePictureController {

    @Autowired
    SavePictureServiceImpl savePictureService;

    @PostMapping("/saveImg")
    public String uploadImg(@RequestParam("file") MultipartFile file, HttpServletRequest request) {

        String fileName = file.getOriginalFilename();
        String filePath = "D:/savePic/demo/";
        if (file.isEmpty()) {
            return "文件为空！";
        }
        try {
            uploadFile(file.getBytes(), filePath, fileName);
        } catch (Exception e) {
        }
        return "succes";
    }

    private void uploadFile(byte[] file, String filePath, String fileName) throws Exception {

        File targetFile = new File(filePath);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(filePath + fileName);
        out.write(file);
        out.flush();
        out.close();
    }

    @PostMapping("/savePicture")
    public String savepicture(@RequestParam("file")MultipartFile file,HttpServletRequest request) throws IOException {
        System.out.println("上传图片");
        String name = request.getParameter("name");
        String userinfo = request.getParameter("userinfo");
        String pwd = request.getParameter("pwd");
        System.out.println("name:" + name);
        System.out.println("pwd:" + pwd);
        System.out.println("userinfo:" + userinfo);
        System.out.println("图片名字：" + file.getOriginalFilename());

        try {
//            File path = new File(ResourceUtils.getURL("static/img/").getPath());
            File savePath = new File("D:/savePic/demo/");
            if(!savePath.exists()){
                savePath.mkdirs();
            }
            System.out.println("路径：" + savePath + file.getOriginalFilename());
            FileOutputStream out = new FileOutputStream(savePath +File.separator+ file.getOriginalFilename());
            System.out.println("完成");
            out.write(file.getBytes());
            out.close();
            return file.getOriginalFilename();
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
            return "失败";
        }


    }
}
