package ru.kpfu.itis.service.impl;

import ru.kpfu.itis.dao.TripsDao;
import ru.kpfu.itis.model.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import ru.kpfu.itis.service.TripsService;

import java.util.List;

public class TripsServiceImpl implements TripsService {

    @Autowired
    TripsDao tripsDao;

    public Trip addTrip(Trip trip) {
        tripsDao.save(trip);
        return trip;
    }

    public void update(Trip trip) {
        tripsDao.save(trip);
    }

    public List<Trip> findAll() {
        return tripsDao.findAll();
    }

    public List<Trip> findAllOrderDate() {
        return tripsDao.findAllByOrderByDateDesc();
    }

    public List<Trip> findByStatusOrderDate() {
        return tripsDao.findByStatusOrderByDateDesc("Ожидание");
    }

    public List<Trip> findBySearch(String departure, String destination) {
        return tripsDao.findByDepartureAndDestinationOrderByDateDesc(departure, destination);
    }

    public Trip findById(Long id) {
        return tripsDao.findOne(id);
    }

    public List<Trip> lastTrips() {
        return tripsDao.findTop10ByOrderByDateDesc();
    }
}
