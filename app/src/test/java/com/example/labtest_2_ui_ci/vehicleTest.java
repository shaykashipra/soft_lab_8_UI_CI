package com.example.labtest_2_ui_ci;

import static org.junit.Assert.*;

import org.junit.Test;

public class vehicleTest {

    @Test
    public void testSedanDrive() {
        sedan sedanCar = new sedan();
        sedanCar.petrol(10);
        assertEquals("fuel:8.0L milage:5.0m", sedanCar.drive()); // Expected fuel and mileage after driving
    }

    @Test
    public void testMotorcycleDrive() {
        motorcycle motorcycleVehicle = new motorcycle();
        motorcycleVehicle.petrol(5);
        assertEquals("fuel:3.5L milage:0.5m", motorcycleVehicle.drive()); // Expected fuel and mileage after driving
    }

    @Test
    public void testSUVDrive() {
        SUV suvVehicle = new SUV();
        suvVehicle.petrol(20); // Adding 20 liters of fuel
        assertEquals("fuel:16.0L milage:2.5m", suvVehicle.drive()); // Expected fuel and mileage after driving
    }

    @Test
    public void testColor() {
        color redColor = new red();
        assertEquals("red", redColor.showcolor()); // Expected color name

        color blueColor = new blue();
        assertEquals("blue", blueColor.showcolor()); // Expected color name

        color greenColor = new green();
        assertEquals("green", greenColor.showcolor()); // Expected color name
    }
}