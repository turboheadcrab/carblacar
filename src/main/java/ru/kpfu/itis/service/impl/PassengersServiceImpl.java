package ru.kpfu.itis.service.impl;

import ru.kpfu.itis.dao.PassengersDao;
import ru.kpfu.itis.model.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import ru.kpfu.itis.service.PassengersService;

import java.util.List;

public class PassengersServiceImpl implements PassengersService {

    @Autowired
    PassengersDao passengersDao;

    public Passenger addPassenger(Passenger passenger) {
        passengersDao.save(passenger);
        return passenger;
    }

    public Passenger findById(Long id) {
        return passengersDao.findOne(id);
    }

    public void update(Passenger passenger) {
        passengersDao.save(passenger);

    }

    public List<Passenger> findAll() {
        return passengersDao.findAll();
    }
}
