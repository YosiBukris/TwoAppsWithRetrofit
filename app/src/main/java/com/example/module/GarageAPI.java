package com.example.module;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GarageAPI {

    @GET("WypPzJCt")
    Call<Garage>loadGarage();
//
//    @GET("garages/{garageKey}")
//    Call<Garage> loadGarageByKey(@Path(value = "garageKey", encoded = true) String _garageKey);
}
