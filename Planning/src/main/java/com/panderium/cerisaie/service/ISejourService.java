package com.panderium.cerisaie.service;

import com.panderium.cerisaie.model.ActiviteEntity;
import com.panderium.cerisaie.model.SejourEntity;

import java.util.List;

public interface ISejourService {

    SejourEntity findByNumSej(int id);

    List<SejourEntity> listAll();
}
