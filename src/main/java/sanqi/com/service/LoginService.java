package sanqi.com.service;

import sanqi.com.entity.TestDouble;
import sanqi.com.entity.User;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface LoginService {

    //查询登录
    List<User> CheckLogin(String username, String password, HttpSession session);
    List<User> selectall();
    int addTest(TestDouble testDouble);
}
