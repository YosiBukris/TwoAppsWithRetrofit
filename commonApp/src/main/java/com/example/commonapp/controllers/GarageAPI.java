package com.example.commonapp.controllers;
import com.example.commonapp.entities.Garage;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GarageAPI {

    @GET("WypPzJCt")
    Call<Garage>loadGarage();
}
