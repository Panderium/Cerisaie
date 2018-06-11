package service;

import model.ClientEntity;

public interface IClientService {

    ClientEntity findByNumCli(int id);
}
