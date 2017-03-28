package ru.kpfu.itis.dao;

import ru.kpfu.itis.model.Driver;

import java.util.List;

public interface DriversDao{

    void save(Driver driver);

    Driver findOne(Long id);

    List<Driver> findAll();

    List<Driver> findTop9ByOrderByRatingDesc();

}
