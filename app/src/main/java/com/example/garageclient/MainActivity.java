package com.example.garageclient;

import static com.example.garageclient.MyApplication.getContext;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    MyAdapter adapter;
    Intent intent;
    Vehicle[] allVehicles;
    EditText type1, modelname1, liscencenumber1, availableanargy1, maxtirespressure1, inflitetire1, addenergy1, wheels1;
    Button addbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        ViewGroup view = (ViewGroup) ((ViewGroup) this
                .findViewById(android.R.id.content)).getChildAt(0);

        // Get intent, action and MIME type
        intent = getIntent();

        type1 = view.findViewById(R.id.add_type);
        modelname1 = view.findViewById(R.id.add_modelname);
        liscencenumber1 = view.findViewById(R.id.add_lisencenumber);
        availableanargy1 = view.findViewById(R.id.add_availablenergypercentage);
        maxtirespressure1 = view.findViewById(R.id.add_maxtirespressure);
        inflitetire1 = view.findViewById(R.id.add_Inflatetire);
        addenergy1 = view.findViewById(R.id.add_addenergy);
        wheels1 = view.findViewById(R.id.add_wheels);
        addbtn = view.findViewById(R.id.add_addbtn);


        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int[] wheelsarray = convertToArray(wheels1.getText().toString());

                Vehicle addedvehical = new Vehicle(type1.getText().toString(), modelname1.getText().toString(),
                        Integer.parseInt(liscencenumber1.getText().toString()), Integer.parseInt(availableanargy1.getText().toString()),
                        Integer.parseInt(maxtirespressure1.getText().toString()), Integer.parseInt(inflitetire1.getText().toString()),
                        Integer.parseInt(addenergy1.getText().toString()), wheelsarray);
                Model.instance.addVehicle(addedvehical, new Model.addVehicleListener() {
                    @Override
                    public void onComplete(int code) {
                        if (code == 200) {
                            Toast.makeText(MainActivity.this, "added done", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(MainActivity.this, "didn't added", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

        Model.instance.getVeicles(new Model.getVeiclesListener() {
            @Override
            public void onComplete(Vehicle[] vehicles) {
                RecyclerView list = view.findViewById(R.id.rv_vehicles);
                list.setHasFixedSize(true);

                list.setLayoutManager(new LinearLayoutManager(getContext()));

                adapter = new MyAdapter();
                list.setAdapter(adapter);
                allVehicles = vehicles;
            }
        });
    //    refresh();

    }


    private void refresh() {
        adapter.notifyDataSetChanged();
    }

    // takes a string like this:"1,2,3,4,5,6,7,8,9,0" and covert to array of int
    public int[] convertToArray(String str){
        String items[] = str.split(",");
        int ent[] = new int[items.length];
        for(int i=0;i<items.length;i++){
            try{
                ent[i] = Integer.parseInt(items[i]);
            }catch(NumberFormatException e){
                //Error
            }
        }
        return ent;
    }

    //////////////////////////VIEWHOLDER////////////////////////////////////

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView type, modelname, lisence;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            type = (TextView) itemView.findViewById(R.id.list_row_type);
            modelname = (TextView) itemView.findViewById(R.id.list_row_ModelName);
            lisence = (TextView) itemView.findViewById(R.id.list_row_LicenseNumber);
        }

        public void bind(Vehicle str) {
            type.setText(str.getType());
            modelname.setText(str.getModelName());
            lisence.setText(Integer.toString(str.getLicenseNumber()));
        }
    }

    //////////////////////////MYYYYYYYY APATERRRRRRRR///////////////////////

    class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = getLayoutInflater().inflate(R.layout.vehicles_list_row, parent, false);
            MyViewHolder holder = new MyViewHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            Vehicle str = allVehicles[position];
            holder.bind(str);

        }

        @Override
        public int getItemCount() {
            if (allVehicles == null) {
                return 0;
            }
            return allVehicles.length;
        }
    }
}