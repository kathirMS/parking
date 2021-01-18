package com.kathir.parking.service;

import com.kathir.parking.controller.ParkingController;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class FirstTest {
    @Test
    public void test() {
        ParkingController parkingController=new ParkingController();
        assertEquals(ParkingController.testString(), "ExampleTest Successfully compleed");
    }
}
