package com.kathir.parking.parkingClass;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Info {
    @Id
    Integer vehicleNo;
    String name;
    Integer id;
    String vehicle;

    public Info() {
    }

    public Integer getVehicleNo() {

        return vehicleNo;
    }

    public void setVehicleNo(Integer vehicleNo) {

        this.vehicleNo = vehicleNo;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVehicle() {

        return vehicle;
    }

    public void setVehicle(String vehicle) {

        this.vehicle = vehicle;
    }
}
