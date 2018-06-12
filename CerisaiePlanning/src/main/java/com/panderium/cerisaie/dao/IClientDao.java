package com.panderium.cerisaie.dao;

import com.panderium.cerisaie.model.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClientDao extends JpaRepository<ClientEntity, Integer> {

    ClientEntity findByNumCli(int id);
}
