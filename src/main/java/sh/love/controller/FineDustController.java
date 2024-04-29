package sh.love.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sh.love.jpa.domain.FineDust;
import sh.love.model.FineDustAddDto;
import sh.love.service.FineDustService;

import java.util.List;

@RestController
@RequestMapping("/dust")
public class FineDustController {

    @Autowired
    private FineDustService fineDustService;

    @GetMapping
    public List<FineDust> getList() {
        return fineDustService.findAll();
    }

    @PostMapping
    public FineDust add(@RequestBody FineDustAddDto dto) {
        return fineDustService.add(dto);
    }

    @PutMapping("/{id}")
    public FineDust update(
            @PathVariable int id,
            @RequestBody FineDustAddDto dto
    ) {
        return fineDustService.update(id,dto);
    }

    @DeleteMapping("/{id}")
    public String delete(
            @PathVariable int id
    ) {
        return fineDustService.delete(id);
    }

}
