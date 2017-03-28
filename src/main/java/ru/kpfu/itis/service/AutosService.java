package ru.kpfu.itis.service;


import ru.kpfu.itis.model.Automobile;

import java.util.List;

public interface AutosService {
    Automobile addAuto(Automobile automobile);

    void update(Automobile automobile);

    List<Automobile> findAll();

    Automobile findById(Long id);
}
