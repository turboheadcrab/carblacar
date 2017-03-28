package ru.kpfu.itis.service.impl;

import ru.kpfu.itis.dao.BookingsDao;
import ru.kpfu.itis.model.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import ru.kpfu.itis.service.BookingService;

import java.util.List;

public class BookingsServiceImpl implements BookingService {

    @Autowired
    BookingsDao bookingsDao;

    public Booking addBooking(Booking booking) {
        bookingsDao.save(booking);
        return booking;
    }

    public void update(Booking booking) {
        bookingsDao.save(booking);
    }

    public List<Booking> findAll() {
        return bookingsDao.findAll();
    }

    public Booking findById(Long id) {
        return bookingsDao.findOne(id);
    }
}
