package dao;

import model.SportEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISportDao extends JpaRepository<SportEntity, Integer> {
}
