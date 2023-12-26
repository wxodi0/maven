package sh.love.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sh.love.jpa.domain.Main;
import sh.love.jpa.repository.MainRepository;
import sh.love.mapper.MainMapper;
import sh.love.model.MainAddDto;
import sh.love.model.MainInDto;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class MainService {

    @Autowired
    private MainMapper mainMapper;

    @Autowired
    private MainRepository mainRepository;

    public Map<String, List<Main>> findMain(){
        Map<String, List<Main>> map = new HashMap<>();
        map.put("mybatis", mainMapper.findAll());
        map.put("jpa", mainRepository.findAll());
        return map;
    }

    public String findSn(MainInDto dto) {
        return mainMapper.findSn(dto.getSn());
    }

    public String add(MainAddDto dto) {
        return mainMapper.save(dto.getCn());
    }

    public String delete(int id) {
        return mainMapper.delete(id);
    }

}
