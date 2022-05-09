package com.example.garageclient;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Vehicle {

        @SerializedName("Type")
        @Expose
        private String Type;
        @SerializedName("ModelName")
        @Expose
        private String ModelName;
        @SerializedName("LicenseNumber")
        @Expose
        private int LicenseNumber;
        @SerializedName("AvailablEnergyPercentage")
        @Expose
        private int AvailablEnergyPercentage;
        @SerializedName("MaximumTirePressure")
        @Expose
        private int MaximumTirePressure;
        @SerializedName("InflateTire")
        @Expose
        private int InflateTire;
        @SerializedName("AddEnergy")
        @Expose
        private int AddEnergy;
        @SerializedName("EnergySource")
        @Expose
        private String EnergySource;

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getModelName() {
        return ModelName;
    }

    public void setModelName(String modelName) {
        ModelName = modelName;
    }

    public int getLicenseNumber() {
        return LicenseNumber;
    }

    public void setLicenseNumber(int licenseNumber) {
        LicenseNumber = licenseNumber;
    }

    public int getAvailablEnergyPercentage() {
        return AvailablEnergyPercentage;
    }

    public void setAvailablEnergyPercentage(int availablEnergyPercentage) {
        AvailablEnergyPercentage = availablEnergyPercentage;
    }

    public int getMaximumTirePressure() {
        return MaximumTirePressure;
    }

    public void setMaximumTirePressure(int maximumTirePressure) {
        MaximumTirePressure = maximumTirePressure;
    }

    public int getInflateTire() {
        return InflateTire;
    }

    public void setInflateTire(int inflateTire) {
        InflateTire = inflateTire;
    }

    public int getAddEnergy() {
        return AddEnergy;
    }

    public void setAddEnergy(int addEnergy) {
        AddEnergy = addEnergy;
    }

    public String getEnergySource() {
        return EnergySource;
    }

    public void setEnergySource(String energySource) {
        EnergySource = energySource;
    }

    public int[] getWheels() {
        return Wheels;
    }

    public void setWheels(int[] wheels) {
        Wheels = wheels;
    }

    @SerializedName("Wheels")
        @Expose
        private int [] Wheels;



        public Vehicle(String Type, String ModelName, int LicenseNumber, int AvailablEnergyPercentage, int MaximumTirePressure,
                       int InflateTire, int AddEnergy, int[] Wheels) {
            this.Type = Type;
            this.ModelName = ModelName;
            this.LicenseNumber = LicenseNumber;
            this.AvailablEnergyPercentage = AvailablEnergyPercentage;
            this.MaximumTirePressure = MaximumTirePressure;
            this.InflateTire = InflateTire;
            this.AddEnergy = AddEnergy;
            this.Wheels = Wheels;

        }


        public static Vehicle create(Map<String, Object> json) {
            String Type = (String) json.get("Type");
            String ModelName = (String) json.get("ModelName");
            int LicenseNumber = (int) json.get("LicenseNumber");
            int AvailablEnergyPercentage = (int) json.get("AvailablEnergyPercentage");
            int MaximumTirePressure = (int) json.get("MaximumTirePressure");
            int InflateTire = (int) json.get("InflateTire");
            int AddEnergy =(int) json.get("AddEnergy");
            int[] Wheels = (int[]) json.get("Wheels");

            Vehicle vehicle = new Vehicle(Type,ModelName,LicenseNumber,AvailablEnergyPercentage,MaximumTirePressure,
                    InflateTire,AddEnergy,Wheels);

            return vehicle;
        }

        public Map<String, Object> toJson() {
            Map<String, Object> json = new HashMap<String, Object>();
            json.put("Type",Type);
            json.put("ModelName",ModelName);
            json.put("LicenseNumber",LicenseNumber);
            json.put("AvailablEnergyPercentage",AvailablEnergyPercentage);
            json.put("MaximumTirePressure", MaximumTirePressure);
            json.put("InflateTire", InflateTire);
            json.put("AddEnergy", AddEnergy);
            json.put("Wheels",Wheels);

            return json;
        }

}
