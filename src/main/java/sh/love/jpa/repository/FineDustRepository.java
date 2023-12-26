package sh.love.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sh.love.jpa.domain.FineDust;

@Repository
public interface FineDustRepository extends JpaRepository<FineDust, Integer> {
}
