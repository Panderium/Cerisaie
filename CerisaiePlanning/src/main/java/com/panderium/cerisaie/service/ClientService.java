package com.panderium.cerisaie.service;

import com.panderium.cerisaie.dao.IClientDao;
import com.panderium.cerisaie.model.ClientEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService implements IClientService {

    @Autowired
    private IClientDao clientDao;

    @Override
    public ClientEntity findByNumCli(int id) {
        return clientDao.findByNumCli(id);
    }
}
