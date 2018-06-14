package com.panderium.cerisaie.service;

import com.panderium.cerisaie.dao.IActiviteDao;
import com.panderium.cerisaie.model.ActiviteEntity;
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
    public ActiviteEntity findAllByCodeSport(int idCodeSport) {
        return activiteDao.findAllByCodeSport(idCodeSport);
    }


}
