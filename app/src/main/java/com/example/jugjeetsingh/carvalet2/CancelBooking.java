package com.example.jugjeetsingh.carvalet2;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class CancelBooking extends AppCompatActivity {
    TextView textView, textView1;
    Button button;

    SharedPreferences sharedpreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cancel_booking);
        textView=findViewById(R.id.txt);
        textView1=findViewById(R.id.txt2);
        button=findViewById(R.id.cancel);


        sharedpreferences = getSharedPreferences("booking", Context.MODE_PRIVATE);
        String username = sharedpreferences.getString("Name", "0");
        String carnumber = sharedpreferences.getString("carnumber", "0");

        textView.setText(username);
        textView1.setText(carnumber);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences preferences =getSharedPreferences("booking",Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.clear();
                editor.commit();
                finish();
            }
        });

    }
}
