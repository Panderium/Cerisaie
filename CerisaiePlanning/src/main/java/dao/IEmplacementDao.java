package dao;

import model.EmplacementEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmplacementDao extends JpaRepository<EmplacementEntity, Integer> {
}
