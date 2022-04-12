package sanqi.com.bootController;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/boot")
public class Boot {

    @RequestMapping("/index")
    public String index(){
        System.out.println("进入boot模块");
        return "/bootStrap/index";
    }
}
