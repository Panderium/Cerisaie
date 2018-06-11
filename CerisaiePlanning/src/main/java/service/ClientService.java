package service;

import dao.IClientDao;
import model.ClientEntity;
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
