package com.example.jugjeetsingh.carvalet2;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class lastBooking extends AppCompatActivity {
TextView textView, textView1;
    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last_booking);
        textView=findViewById(R.id.Name);
        textView1=findViewById(R.id.Carnumber);
        sharedpreferences = getSharedPreferences("booking", Context.MODE_PRIVATE);
        String username = sharedpreferences.getString("Name", "0");
        String carnumber = sharedpreferences.getString("carnumber", "0");

        textView.setText(username);
        textView1.setText(carnumber);
    }
}
