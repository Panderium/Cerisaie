package dao;

import model.ActiviteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IActiviteDao extends JpaRepository<ActiviteEntity, Integer> {

    List<ActiviteEntity> findAllByCodeSport(Iterable<Integer> iterable);
}
