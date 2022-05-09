package com.example.garageclient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;

public interface RetrofitInterface {

    @GET("/getVeicles")
    Call<List<Vehicle>> getVeicles();

/*
    getVeicles,
    addNewVehicle,
    getVehicleByLicense,
    getVehiclesFromSorting,
    infalteTiresToMax,
    addEnergyByLicense
 */

}