package sanqi.com.service.impl;

import sanqi.com.entity.User;
import sanqi.com.mapper.UserMapper;
import sanqi.com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper mapper;

    @Override
    public List<User> getUsers() {
        return mapper.getUsers();
    }
}