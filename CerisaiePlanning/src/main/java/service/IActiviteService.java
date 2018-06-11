package service;

import model.ActiviteEntity;

import java.util.List;

public interface IActiviteService {

    List<ActiviteEntity> listAll();

    List<ActiviteEntity> findAllByCodeSport(Iterable<Integer> iterable);
}
