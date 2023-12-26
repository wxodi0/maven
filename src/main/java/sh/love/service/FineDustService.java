package sh.love.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sh.love.jpa.domain.FineDust;
import sh.love.jpa.repository.FineDustRepository;
import sh.love.jpa.repository.MainRepository;
import sh.love.mapper.FineDustMapper;
import sh.love.mapper.MainMapper;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class FineDustService {

    @Autowired
    private FineDustMapper fineDustMapper;

    @Autowired
    private FineDustRepository fineDustRepository;

    public List<FineDust> findAll() {
        return fineDustRepository.findAll();
    }
}
