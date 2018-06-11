package dao;

import model.TypeEmplacementEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITypeEmplacementDao extends JpaRepository<TypeEmplacementEntity, Integer> {
}
