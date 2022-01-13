package sh.love.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sh.love.jpa.domain.Main;

@Repository
public interface MainRepository extends JpaRepository<Main, Integer> {
}
