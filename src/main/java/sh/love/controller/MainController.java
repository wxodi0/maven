package sh.love.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sh.love.jpa.domain.Main;
import sh.love.model.MainAddDto;
import sh.love.model.MainInDto;
import sh.love.service.MainService;

import java.util.List;
import java.util.Map;

@RestController
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
    @PostMapping("/")
    public String main2(@RequestBody MainInDto dto) {
        return mainService.findSn(dto);
    }

    @PutMapping("/")
    public String main3(@RequestBody MainAddDto dto) {
        return mainService.add(dto);
    }

    @DeleteMapping("/{id}")
    public String main4(@PathVariable int id) {
        return mainService.delete(id);
    }
}
