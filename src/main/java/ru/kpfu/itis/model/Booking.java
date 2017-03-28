package ru.kpfu.itis.model;

import javax.persistence.*;

@Entity
@Table(name = "bookings", schema = "public", catalog = "carcarbla")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bookings_id_sequence")
    @SequenceGenerator(name = "bookings_id_sequence", sequenceName = "bookings_id_seq", allocationSize = 1)
    private Long id;

    @ManyToOne(targetEntity = Trip.class)
    @JoinColumn(name = "trip_id", referencedColumnName = "id")
    private Trip trip;

    @ManyToOne(targetEntity = Passenger.class)
    @JoinColumn(name = "passenger_id", referencedColumnName = "id")
    private Passenger passenger;

    private int count;

    private String info;

    private String confirm;

    public Booking() {
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

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getConfirm() {
        return confirm;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }
}
