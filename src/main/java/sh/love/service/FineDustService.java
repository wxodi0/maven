package sh.love.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sh.love.jpa.domain.FineDust;
import sh.love.jpa.repository.FineDustRepository;
import sh.love.mapper.FineDustMapper;
import sh.love.model.FineDustAddDto;

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


    public FineDust add(FineDustAddDto dto) {
        FineDust fineDust = new FineDust();

        fineDust.setCheckData(dto.getCheckData());
        fineDust.setCheckTime(dto.getCheckTime());
        fineDust.setArea(dto.getArea());
        fineDust.setGround(dto.getGround());
        fineDust.setRoadName(dto.getRoadName());
        fineDust.setStartPoint(dto.getStartPoint());
        fineDust.setEndPoint(dto.getEndPoint());
        fineDust.setTemp(dto.getTemp());
        fineDust.setHum(dto.getHum());
        fineDust.setAverageAshDustConcentration(dto.getAverageAshDustConcentration());
        fineDust.setLegend(dto.getLegend());

        return fineDustMapper.dustAdd(fineDust);
    }

    public FineDust update(int id, FineDustAddDto dto) {
        FineDust fineDust = fineDustRepository.findById(id).orElse(null);

        if(fineDust == null) {
            throw new IllegalArgumentException("수정하고 싶은 리스트의 값이 비어있습니다.");
        }

        fineDust.setCheckData(dto.getCheckData());
        fineDust.setCheckTime(dto.getCheckTime());
        fineDust.setArea(dto.getArea());
        fineDust.setGround(dto.getGround());
        fineDust.setRoadName(dto.getRoadName());
        fineDust.setStartPoint(dto.getStartPoint());
        fineDust.setEndPoint(dto.getEndPoint());
        fineDust.setTemp(dto.getTemp());
        fineDust.setHum(dto.getHum());
        fineDust.setAverageAshDustConcentration(dto.getAverageAshDustConcentration());
        fineDust.setLegend(dto.getLegend());

        return fineDustMapper.dustUpdate(fineDust);
    }

    public String delete(int id) {
        fineDustMapper.dustDelete(id);
        return "삭제 되었습니다.";
    }
}
