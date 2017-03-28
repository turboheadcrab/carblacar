package ru.kpfu.itis.service;

import ru.kpfu.itis.model.Passenger;

import java.util.List;

public interface PassengersService {
    Passenger addPassenger(Passenger passenger);

    Passenger findById(Long id);

    void update(Passenger passenger);

    List<Passenger> findAll();
}
