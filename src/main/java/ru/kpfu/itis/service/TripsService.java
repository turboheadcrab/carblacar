package ru.kpfu.itis.service;

import ru.kpfu.itis.model.Trip;

import java.util.List;

public interface TripsService {

    Trip addTrip(Trip trip);

    void update(Trip trip);

    List<Trip> findAll();

    List<Trip> findAllOrderDate();

    List<Trip> findByStatusOrderDate();

    List<Trip> findBySearch(String departure, String destination);

    Trip findById(Long id);

    List<Trip> lastTrips();
}
