package com.example.doctors;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{
    ArrayList<Doctor> docs = new ArrayList<Doctor>();
    MyAdapter adapter;
    RecyclerView recyclerView;
    Button addBtn;
    ImageView menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        initList();
        recyclerView = findViewById(R.id.rv_doctors);
        adapter = new MyAdapter(this, docs);
        recyclerView.setAdapter(adapter);
        int img = docs.get(0).getImageView();
        Log.d("CheckImg", "Image = " + img);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        onClick();



        Log.d("checkList", "create");
    }

    void init(){
        addBtn = findViewById(R.id.btnAdd);
        menu = findViewById(R.id.menuIcon);

//        menu.setOnClickListener(viewClickListener);
    }

    void initList(){
        docs.add(new Doctor("Актилек", "+996704774106","Травматолог", R.drawable.doc));
        docs.add(new Doctor("Мирбек", "+996707418989","Медбрат", R.drawable.doc1));
        docs.add(new Doctor("Aзим", "+996707414989","Хирург", R.drawable.doc2));
        docs.add(new Doctor("Самара", "+996505133399","Кардиолог", R.drawable.doc3));
        docs.add(new Doctor("Аман", "+996999324564","Терапефт", R.drawable.doc4));
        docs.add(new Doctor("Тима", "+996701245678","Акушер", R.drawable.doctor_default_man));
        docs.add(new Doctor("Гульхумор", "+996551355673","Травматолог", R.drawable.doctor_defoult_women));
        docs.add(new Doctor("Хума", "+996777888999","Кардиохирург", R.drawable.doctor_default_man));
        docs.add(new Doctor("Сюита", "+996772871145","Любимая", R.drawable.doc6));
        docs.add(new Doctor("Санжар", "+996708652361","Нейрохирург", R.drawable.doctor_default_man));
        docs.add(new Doctor("Гоха", "+996551232334","Анестезиолог", R.drawable.doctor_defoult_women));
    }

    View.OnClickListener viewClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            showMenu(v);
        }
    };






    void showMenu(View v) {
        PopupMenu menu = new PopupMenu(this, v);
        menu.inflate(R.menu.popup_menu);

        menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.visit:
                            Log.d("checkMenuClick", "Visit is clicked");
                            return true;
                        case R.id.chat:
                            Log.d("checkMenuClick", "Chat is clicked");
                            return true;
                        case R.id.call:
                            Log.d("checkMenuClick", "Call is clicked");
                            Intent callIntent = new Intent(Intent.ACTION_CALL);
                            callIntent.setData(Uri.parse("tel: "+R.id.txtRoom));
                            try {
                                startActivity(Intent.createChooser(callIntent, "Звонок..."));
                            } catch (android.content.ActivityNotFoundException ex) {
                                Toast.makeText(MainActivity.this, "There is no call client installed.",
                                        Toast.LENGTH_SHORT).show();
                            }
                            return true;
                        default:
                            return false;
                    }
                }
            });
        menu.show();
    }



    public void onClick(){
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AddActivity.class));
            }
        });
    }

    public ArrayList<Doctor> getDocs() {
        return docs;
    }

    public void setDocs(ArrayList<Doctor> docs) {
        this.docs = docs;
    }
}

//    public void addOnClick(View view){
//        Intent intent = new Intent(this, AddActivity.class);
//        startActivity(intent);
//    }

    //    @Override
//    protected void onRestart() {
//        super.onRestart();
//        Log.d("checkList", "restart");
//        AddActivity addActivity = new AddActivity();
//        ArrayList<Doctor> updatedDocs = addActivity.clickListener();
//        adapter.notifyItemInserted(updatedDocs.size()-1);
//        adapter = new MyAdapter(this, updatedDocs);
//        recyclerView.setAdapter(adapter);
//    }
//
//    @Override
//    protected void onStart() {
//        super.onStart();
//        Log.d("checkList", "start");
//
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        Log.d("checkList", "resume");
//    }

