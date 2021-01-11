package com.example.module.entities;

import com.example.module.entities.Car;

import java.util.ArrayList;
import java.util.List;

public class Garage {
    private List<Car>allCars;
    private boolean isOpen;
    private String address;
    private String name;

    public Garage(){}

    public Garage( boolean isOpen, String address, String name) {
       this.allCars = allCars;
        this.isOpen = isOpen;
        this.address = address;
        this.name = name;
    }

    public List<Car> getAllCars() {
        return allCars;
    }

    public void setAllCars(ArrayList<Car> allCars) {
        this.allCars = allCars;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
