package ru.kpfu.itis.model;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "autos", schema = "public", catalog = "carcarbla")
public class Automobile {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "auto_id_generator")
    @SequenceGenerator(name = "auto_id_generator", sequenceName = "autos_id_seq", allocationSize = 1)
    Long id;

    String brand;

    String model;

    @Column(name = "license_plate")
    String licensePlate; //госномер

    int age;

    @ManyToOne(targetEntity = Driver.class)
    @JoinColumn(name = "driver_id", referencedColumnName = "id")
    Driver driver;

    @OneToMany(mappedBy = "auto")
    List<Trip> trips;

    public Automobile() {
    }

    public Automobile(String brand, String model, String licensePlate, int age, Driver driver) {
        this.brand = brand;
        this.model = model;
        this.licensePlate = licensePlate;
        this.age = age;
        this.driver = driver;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public List<Trip> getTrips() {
        return trips;
    }

    public void setTrips(List<Trip> trips) {
        this.trips = trips;
    }
}
