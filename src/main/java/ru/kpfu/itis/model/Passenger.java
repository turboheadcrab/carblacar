package ru.kpfu.itis.model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "passengers", schema = "public", catalog = "carcarbla")
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "passengers_id_sequence")
    @SequenceGenerator(name = "passengers_id_sequence", sequenceName = "passengers_id_seq", allocationSize = 1)
    private Long id;

    private int rating;

    @OneToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToMany(mappedBy = "passengers")
    private List<Trip> trips;

    @OneToMany(mappedBy = "passenger")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Booking> bookings;

    public Passenger() {
    }

    public Passenger(int rating, User user) {
        this.rating = rating;
        this.user = user;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Trip> getTrips() {
        return trips;
    }

    public void setTrips(List<Trip> trips) {
        this.trips = trips;
    }
}
