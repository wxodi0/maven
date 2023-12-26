package sh.love.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sh.love.jpa.domain.FineDust;
import sh.love.service.FineDustService;

import java.util.List;

@RestController
public class FineDustController {

    @Autowired
    private FineDustService fineDustService;

    @GetMapping("/")
    public List<FineDust> getList() {
        return fineDustService.findAll();
    }
}
