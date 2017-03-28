package ru.kpfu.itis.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "trips", schema = "public", catalog = "carcarbla")
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "trips_id_sequence")
    @SequenceGenerator(name = "trips_id_sequence", sequenceName = "trips_id_seq", allocationSize = 1)
    private Long id;

    @ManyToOne(targetEntity = Driver.class)
    @JoinColumn(name = "driver_id", referencedColumnName = "id")
    private Driver driver;

    @ManyToOne
    @JoinColumn(name = "auto_id", referencedColumnName = "id")
    private Automobile auto;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "passengers_trips", joinColumns = @JoinColumn(name = "trip_id"), inverseJoinColumns =
    @JoinColumn(name = "passenger_id"))
    List<Passenger> passengers;

    private String departure;

    private String destination;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    private int price;

    private int count; //количество пассажиров

    private String status;

    private String info; //информация и доп. условия

    @OneToMany(mappedBy = "trip")
    List<Booking> bookings;

    @OneToMany(mappedBy = "trip")
    List<Review> reviews;

    public Trip() {

    }

    public Trip(Driver driver, Automobile auto, String departure, String destination, Date date, int price, int count, String status, String info) {
        this.driver = driver;
        this.auto = auto;
        this.departure = departure;
        this.destination = destination;
        this.date = date;
        this.price = price;
        this.count = count;
        this.status = status;
        this.info = info;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Automobile getAuto() {
        return auto;
    }

    public void setAuto(Automobile auto) {
        this.auto = auto;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }
}


