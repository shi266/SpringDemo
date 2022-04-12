package sanqi;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
@ServletComponentScan
public class SpringDemoApplication {
    private static final Logger logger = LoggerFactory.getLogger(SpringDemoApplication.class);
    public static void main(String[] args) {
        logger.info("===============项目启动了===============");
        SpringApplication.run(SpringDemoApplication.class,args);
        logger.info("===============启动成功了===============》》");
    }


}
