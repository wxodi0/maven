package sh.love.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import sh.love.jpa.domain.Main;
import sh.love.service.MainService;

import java.util.List;
import java.util.Map;

@Controller
public class MainController {

    @Autowired
    private MainService mainService;

    @RequestMapping(value = "/")
    public String main(Model model){
        Map<String, List<Main>> map = mainService.findMain();
        System.out.println("mybatis: " + map.get("mybatis"));
        System.out.println("jpa: " + map.get("jpa"));
        model.addAttribute("mainTitle", "Hello");
        return "/main";
    }

}
