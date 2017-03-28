package ru.kpfu.itis.service.impl;

import ru.kpfu.itis.dao.DriversDao;
import ru.kpfu.itis.model.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import ru.kpfu.itis.service.DriversService;

import java.util.List;

public class DriversServiceImpl implements DriversService {

    private final DriversDao driversDao;

    @Autowired
    public DriversServiceImpl(DriversDao driversDao) {
        this.driversDao = driversDao;
    }

    public Driver addDriver(Driver driver) {
        driversDao.save(driver);
        return driver;
    }

    public Driver findById(Long id) {
        return driversDao.findOne(id);
    }

    public void update(Driver driver) {
        driversDao.save(driver);
    }

    public List<Driver> findAll() {
        return driversDao.findAll();
    }

    public List<Driver> getBest() {
        return driversDao.findTop9ByOrderByRatingDesc();
    }

}
