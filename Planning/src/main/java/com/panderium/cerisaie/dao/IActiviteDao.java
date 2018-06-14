package com.panderium.cerisaie.dao;

import com.panderium.cerisaie.model.ActiviteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IActiviteDao extends JpaRepository<ActiviteEntity, Long> {

    ActiviteEntity findAllByCodeSport(int idCodeSport);
}
