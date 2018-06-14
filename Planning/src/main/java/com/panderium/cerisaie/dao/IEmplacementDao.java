package com.panderium.cerisaie.dao;

import com.panderium.cerisaie.model.EmplacementEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmplacementDao extends JpaRepository<EmplacementEntity, Integer> {
}
