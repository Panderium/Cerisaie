package com.panderium.cerisaie.service;

import com.panderium.cerisaie.model.ActiviteEntity;

import java.util.List;

public interface IActiviteService {

    List<ActiviteEntity> listAll();

    ActiviteEntity findAllByCodeSport(int idCodeSport);
}
