package com.panderium.cerisaie.service;

import com.panderium.cerisaie.dao.ISejourDao;
import com.panderium.cerisaie.model.SejourEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SejourService implements ISejourService {

    @Autowired
    private ISejourDao sejourDao;

    @Override
    public SejourEntity findByNumSej(int id) {
        return sejourDao.findByNumSej(id);
    }

    @Override
    public List<SejourEntity> listAll() {
        return sejourDao.findAll();
    }
}
