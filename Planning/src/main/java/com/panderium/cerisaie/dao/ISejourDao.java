package com.panderium.cerisaie.dao;

import com.panderium.cerisaie.model.SejourEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISejourDao extends JpaRepository<SejourEntity, Integer> {

    SejourEntity findByNumSej(int id);
}
