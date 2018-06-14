package com.panderium.cerisaie.dao;

import com.panderium.cerisaie.model.SportEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISportDao extends JpaRepository<SportEntity, Integer> {
}
