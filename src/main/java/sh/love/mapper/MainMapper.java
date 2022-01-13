package sh.love.mapper;

import org.apache.ibatis.annotations.Mapper;
import sh.love.jpa.domain.Main;

import java.util.List;

@Mapper
public interface MainMapper {

    List<Main> findAll();
}
