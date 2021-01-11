package com.example.module.controllers;

import com.example.module.entities.Garage;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GarageAPI {

    @GET("WypPzJCt")
    Call<Garage>loadGarage();
}
