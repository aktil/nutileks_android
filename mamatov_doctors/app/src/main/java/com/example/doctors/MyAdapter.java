package com.example.doctors;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private final LayoutInflater inflater;
    private List<Doctor> doctors;

    MyAdapter(Context context, List<Doctor> doctors) {
        this.doctors = doctors;
        this.inflater = LayoutInflater.from(context);
    }
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_doctor, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyAdapter.ViewHolder holder, int position) {
        Doctor doctor = doctors.get(position);
        holder.nameTxt.setText(doctor.getName());
        holder.roomTxt.setText(doctor.getRoom());
        holder.specialityTxt.setText(doctor.getSpeciality());
        holder.imgView.setImageResource(doctor.getImageView());
        holder.menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu menu = new PopupMenu(view.getContext(), view);
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
                                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                                callIntent.setData(Uri.parse("tel: "+holder.roomTxt.getText()));
                                try {
                                    view.getContext().startActivity(Intent.createChooser(callIntent, "Звонок..."));
                                } catch (android.content.ActivityNotFoundException ex) {
                                    Log.d("Error", "error");
                                }
                                return true;
                            default:
                                return false;
                        }
                    }
                });
                menu.show();
            }
        });


//        Glide.with(R.layout.item_doctor)
//                .load(doctor.getImageView())
//                .centerCrop()
//                .into(R.id.imageView);
    }

    @Override
    public int getItemCount() {
        return doctors.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgView, menu;
        TextView nameTxt, roomTxt, specialityTxt;
        ViewHolder(View view){
            super(view);
            imgView = view.findViewById(R.id.imageView);
            nameTxt = view.findViewById(R.id.txtName);
            roomTxt = view.findViewById(R.id.txtRoom);
            specialityTxt = view.findViewById(R.id.txtSpeciality);
            menu = view.findViewById(R.id.menuIcon);
        }
    }
}
