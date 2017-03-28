package ru.kpfu.itis.dao;

import ru.kpfu.itis.model.Review;

import java.util.List;

public interface ReviewsDao {

    void save(Review review);

    List<Review> findAll();

    Review findOne(Long id);

}
