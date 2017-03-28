package ru.kpfu.itis.model;

import javax.persistence.*;


@Entity
@Table(name = "reviews", schema = "public", catalog = "carcarbla")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reviews_id_sequence")
    @SequenceGenerator(name = "reviews_id_sequence", sequenceName = "reviews_id_seq", allocationSize = 1)
    private
    Long id;
    @ManyToOne(targetEntity = Trip.class)
    @JoinColumn(name = "trip_id", referencedColumnName = "id")
    private
    Trip trip;
    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private
    User user;
    private String text;
    private int grade;

    public Review() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
