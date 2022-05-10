package com.example.garageclient;

import android.content.Context;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Model {

    public static final Model instance = new Model();
    public Retrofit retrofit;
    public RetrofitInterface retrofitInterface;
    public String BASE_URL = "http://10.0.2.2:3000"; //local server

    public void retroServer(){
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        retrofitInterface = retrofit.create(RetrofitInterface.class);
    }

    public interface addVehicleListener {
        void onComplete(int code);
    }

    public interface getVeiclesListener {
        void onComplete(Vehicle[] vehicles);
    }

    public void getVeicles(getVeiclesListener getVeicles) {
        retroServer();

        Call<List<Vehicle>> call = retrofitInterface.getVeicles();

        call.enqueue(new Callback<List<Vehicle>>() {
            @Override
            public void onResponse(Call<List<Vehicle>> call, Response<List<Vehicle>> response) {
                if (response.code() == 200) {
                    getVeicles.onComplete(response.body().toArray(new Vehicle[0]));
                }
            }
            @Override
            public void onFailure(Call<List<Vehicle>> call, Throwable t) {
                getVeicles.onComplete(null);
            }
        });
    }

        public void addVehicle(Vehicle vehicle, addVehicleListener addVehicle) {
            retroServer();

            Map<String, Object> map = vehicle.toJson();

        Call<Vehicle> call = retrofitInterface.addNewVehicle(map);

        call.enqueue(new Callback<Vehicle>() {
            @Override
            public void onResponse(Call<Vehicle> call, Response<Vehicle> response) {
                if (response.code() == 200) {
                    addVehicle.onComplete(200);
                } else {
                    addVehicle.onComplete(400);

                }
            }
            @Override
            public void onFailure(Call<Vehicle> call, Throwable t) {
                addVehicle.onComplete(400);
            }
        });
    }

}
