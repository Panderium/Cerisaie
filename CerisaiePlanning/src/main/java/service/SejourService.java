package service;

import model.SejourEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SejourService implements ISejourService {

    @Autowired
    private ISejourService sejourService;

    @Override
    public SejourEntity findByNumSej(int id) {
        return sejourService.findByNumSej(id);
    }
}
