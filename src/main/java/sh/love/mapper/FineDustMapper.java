package sh.love.mapper;

import org.apache.ibatis.annotations.Mapper;
import sh.love.jpa.domain.FineDust;

@Mapper
public interface FineDustMapper {
    FineDust dustAdd(FineDust fineDust);
    FineDust dustUpdate(FineDust fineDust);
    void dustDelete(int id);
}
