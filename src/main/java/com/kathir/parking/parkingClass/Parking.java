package com.kathir.parking.parkingClass;


import javax.persistence.*;

@Entity
public class Parking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer car;
    private Integer bike;
    private Integer vane;

    public Parking() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCar() {
        return car;
    }

    public void setCar(Integer car) {
        this.car = car;
    }

    public Integer getBike() {
        return bike;
    }

    public void setBike(Integer bike) {
        this.bike = bike;
    }

    public Integer getVane() {
        return vane;
    }

    public void setVane(Integer vane) {
        this.vane = vane;
    }
}
