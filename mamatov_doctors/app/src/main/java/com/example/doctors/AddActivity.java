package com.example.doctors;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class AddActivity extends AppCompatActivity {
    private EditText name;
    private EditText room;
    private EditText specialty;
    private Button addBtn;
    private ArrayList<Doctor> doctors;
    private Doctor doctor;
    private Button backBtn;
    private MainActivity mainActivity;
    private MyAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_doctor);
        init();
        clickListener();
    }


    ArrayList<Doctor> clickListener(){
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameD = name.getText().toString();
                String roomD = room.getText().toString();
                String specD = specialty.getText().toString();

                doctor = new Doctor(nameD, roomD, specD, R.drawable.doctor_default_man);


                mainActivity = new MainActivity();

                doctors = mainActivity.getDocs();

                doctors.add(doctor);

                mainActivity.setDocs(doctors);



                Log.d("checkList", "List is "+doctors.get(doctors.size()-1).getName());


            }

        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        return doctors;
    }
//    public void back(View view){
//        Intent intent = new Intent(this, MainActivity.class);
//        startActivity(intent);
//    }

    void init(){
        name = findViewById(R.id.nameEd);
        room = findViewById(R.id.roomEd);
        specialty = findViewById(R.id.specialityEd);
        addBtn = findViewById(R.id.addButton);
        backBtn = findViewById(R.id.backButton);
    }
}
