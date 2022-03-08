package com.example.springdemo.com.service.Impl;

import com.example.springdemo.com.service.SavePictureService;
import org.springframework.stereotype.Service;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.UUID;

@Service
public class SavePictureServiceImpl implements SavePictureService {
    @Override
    public String savePictureByIo(HttpServletRequest request) throws IOException {
        //图片存储路径
        String savePath = "D:\\savePic\\demo";
        //判断是否有路径
        if(!new File(savePath).exists()){
            new File(savePath).mkdirs();
        }
        ServletInputStream inputStream = request.getInputStream();
        String fileName = UUID.randomUUID().toString().replace("-","")+".jpg";
        File tempFile = new File(savePath,fileName);
        if(!tempFile.exists()){
            OutputStream out = new FileOutputStream(tempFile);
            BufferedOutputStream bout = new BufferedOutputStream(out);
            byte[] buf = new byte[1024];
            int length;
            length=inputStream.read(buf,0,buf.length);
            while (length != -1){
                bout.write(buf,0,buf.length);
                length = inputStream.read(buf);
            }
            bout.close();
            out.close();
            inputStream.close();
        }
        return fileName;
    }
}
