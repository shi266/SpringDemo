package com.example.springdemo.com.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;








//@Service
public interface SavePictureService {


      String savePictureByIo(HttpServletRequest request) throws IOException;

}
