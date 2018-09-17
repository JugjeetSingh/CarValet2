package com.example.jugjeetsingh.carvalet2;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static android.app.PendingIntent.getActivity;

public class homepage1 extends AppCompatActivity implements  GoogleApiClient.OnConnectionFailedListener{


    GridView gridLayout;
    //OnItemClickListener onItemClickListener;
    List<String> ItemsList;
    TextView textView;
    CardView cardView;
    String details[] = {"User Information", "Online Booking", "Cancel Booking", "Last Booking", "Logout"};
    Integer images[] = {R.drawable.userss, R.drawable.cars, R.drawable.cancels, R.drawable.last, R.drawable.logouts};
    ListView listView;

    LinearLayout ll;
    customlistview cc;
    SharedPreferences sharedpreferences1;
    private static final int TIME_DELAY = 2000;
    private static long back_pressed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userinfo);
        //mRecyclerView.setLayoutManager(new GridLayoutManager(Phones.this,2));

        gridLayout = findViewById(R.id.grid);
        textView= findViewById(R.id.color);

        boolean doubleBackToExitPressedOnce = false;
        //cardView=findViewById(R.id.cardview);

        listView = findViewById(R.id.listview);
        sharedpreferences1 = getSharedPreferences("Data",
                Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedpreferences1.edit();
        String aa = sharedpreferences1.getString("emailid", "0");


        cc = new customlistview(homepage1.this, details, images);
        gridLayout.setAdapter(cc);

        gridLayout.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                if (position == 0) {
                    Intent intent = new Intent(homepage1.this, info.class);
                    startActivity(intent);

                } else if (position == 1) {
                    Intent intent = new Intent(homepage1.this, Main2Activity.class);
                    startActivity(intent);
                }
                else  if (position==2){
                    Intent intent= new Intent(homepage1.this,CancelBooking.class);
                    startActivity(intent);

                }
                else if (position==3){
                    Intent intent= new Intent(homepage1.this,lastBooking.class);
                    startActivity(intent);
                } else if (position == 4) {
                    SharedPreferences.Editor editor = sharedpreferences1.edit();
                    editor.remove("emailid");
                    editor.apply();
                    finish();
                }

            }
        });}

    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(homepage1.this);
        builder.setTitle(R.string.app_name);
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setMessage("Do you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();

                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();

    }


    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
}
