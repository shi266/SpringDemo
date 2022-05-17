package sanqi.com.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
//@Configuration
//@PropertySource(value = "classpath:application-service.properties")
//@ConfigurationProperties(prefix = "man")

//手动加载自定义配置文件
@Component
@PropertySource(value = {"classpath:application-service.properties"}, encoding = "utf-8")

public class People  {

    @Value("${man.username}")
    private String username;
    @Value("${man.password}")
    private String password;
    @Value("${man.tell}")
    private String tell;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTell() {
        return tell;
    }

    public void setTell(String tell) {
        this.tell = tell;
    }
}
