package service;

import dao.IActiviteDao;
import model.ActiviteEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActiviteService implements IActiviteService {

    @Autowired
    private IActiviteDao activiteDao;


    @Override
    public List<ActiviteEntity> listAll() {
        return activiteDao.findAll();
    }

    @Override
    public List<ActiviteEntity> findAllByCodeSport(Iterable<Integer> iterable) {
        return activiteDao.findAllByCodeSport(iterable);
    }


}
