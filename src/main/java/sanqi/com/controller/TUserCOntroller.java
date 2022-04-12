package sanqi.com.controller;


import sanqi.com.entity.TUser;
import sanqi.com.entity.User;
import sanqi.com.mapper.GetUserMapper;
import sanqi.com.util.ReturnJSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class TUserCOntroller {

    @Resource
    private GetUserMapper mapper;


    @GetMapping("/getTuser")
    @ResponseBody
    public ReturnJSON testinfo(User user , ReturnJSON returnJSON){
        System.out.println("查询Tuser");
        List<TUser> list = mapper.getTUser();
        returnJSON.setSuccess(true);
        returnJSON.setData(list);
        return returnJSON;
    }
}
