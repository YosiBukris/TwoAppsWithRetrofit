package com.example.commonapp.entities;

import java.util.ArrayList;
import java.util.List;

public class Garage {
    private String[] Cars;
    private boolean open;
    private String address;
    private String name;

    public Garage() {
    }

    public Garage(boolean open, String address, String name, String[] Cars) {
        this.Cars = Cars;
        this.open = open;
        this.address = address;
        this.name = name;
    }

    public String[] getCars() {
        return Cars;
    }

    public void setCars(String[] Cars) {
        this.Cars = Cars;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        open = open;
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
