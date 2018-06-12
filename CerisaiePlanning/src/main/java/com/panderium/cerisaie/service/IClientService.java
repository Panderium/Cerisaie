package com.panderium.cerisaie.service;

import com.panderium.cerisaie.model.ClientEntity;

public interface IClientService {

    ClientEntity findByNumCli(int id);
}
