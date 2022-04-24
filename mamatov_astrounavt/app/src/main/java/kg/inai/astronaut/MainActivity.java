package com.example.cosmonaut;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class MainActivity extends AppCompatActivity {
    EditText wishes;
    Button sendWishes1;
    Button sendWishes2;
//    BottomSheetBehavior sendW;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        clickListener();
    }

    void init(){
        wishes = findViewById(R.id.textField);
        sendWishes1=findViewById(R.id.btn_send);
        sendWishes2=findViewById(R.id.btn_send2);
    }
    public void clickListener(){
        sendWishes1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sendWishes1.setVisibility(View.INVISIBLE);
                wishes.setVisibility(View.VISIBLE);
                wishes.setCursorVisible(true);
                sendWishes2.setVisibility(View.VISIBLE);
            }
        });
        sendWishes2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendEmail();
            }
        });
    }
    @SuppressLint("IntentReset")
    protected void sendEmail() {
        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");

        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Wishes");
        emailIntent.putExtra(Intent.EXTRA_TEXT,wishes.getText().toString());
        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(MainActivity.this, "There is no email client installed.",
                    Toast.LENGTH_SHORT).show();
        }
    }
}
