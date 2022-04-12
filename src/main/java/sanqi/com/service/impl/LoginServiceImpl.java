package sanqi.com.service.impl;

import sanqi.com.entity.TestDouble;
import sanqi.com.entity.User;
import sanqi.com.mapper.LoginMapper;
import sanqi.com.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    LoginMapper mapper;
    @Override
    public List<User> CheckLogin(String username, String password, HttpSession session) {

        session.setAttribute("user",username);

        return mapper.CheckLogin(username, password);
    }

    @Override
    public List<User> selectall() {
        return mapper.selectall();
    }

    @Override
    public int addTest(TestDouble testDouble) {
        int i = mapper.addTest(testDouble);
        return i;
    }
}
