package ru.kpfu.itis.dao;

import ru.kpfu.itis.model.Passenger;

import java.util.List;

public interface PassengersDao {

    void save(Passenger passenger);

    Passenger findOne(Long id);

    List<Passenger> findAll();
}
