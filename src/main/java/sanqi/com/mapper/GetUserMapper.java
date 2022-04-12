package sanqi.com.mapper;

import sanqi.com.entity.TUser;
import sanqi.com.entity.User;
import sanqi.com.entity.UserName;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;


@Mapper
public interface GetUserMapper {


    List<User> getAll(User user);
    List<User> getExcel(User user);
    List<TUser> getTUser();
    int getRows(User user);
    List<UserName> getUserName();
    List<User> getByUserName(String username);
}
