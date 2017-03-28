package ru.kpfu.itis.dao;

import ru.kpfu.itis.model.Booking;

import java.util.List;

public interface BookingsDao {

    void save(Booking booking);

    List<Booking> findAll();

    Booking findOne(Long id);
}
