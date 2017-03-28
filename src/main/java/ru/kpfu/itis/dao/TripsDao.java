package ru.kpfu.itis.dao;

import ru.kpfu.itis.model.Trip;
import java.util.List;

public interface TripsDao {

    void save(Trip trip);

    List<Trip> findAll();

    Trip findOne(Long id);

    List<Trip> findTop10ByOrderByDateDesc();

    List<Trip> findAllByOrderByDateDesc();

    List<Trip> findByStatusOrderByDateDesc(final String status);

    List<Trip> findByDepartureAndDestinationOrderByDateDesc(String destination, String departure);
}
