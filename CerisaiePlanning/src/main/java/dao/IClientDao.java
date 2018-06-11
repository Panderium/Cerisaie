package dao;

import model.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClientDao extends JpaRepository<ClientEntity, Integer> {

    ClientEntity findByNumCli(int id);
}
