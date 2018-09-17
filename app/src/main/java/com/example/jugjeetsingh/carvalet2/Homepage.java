//package com.example.jugjeetsingh.carvalet2;
//
//import android.content.SharedPreferences;
//import android.os.Bundle;
//import android.support.design.widget.FloatingActionButton;
//import android.support.design.widget.Snackbar;
//import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.LinearLayoutManager;
//import android.support.v7.widget.RecyclerView;
//import android.support.v7.widget.Toolbar;
//import android.view.View;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class Homepage extends AppCompatActivity {
//    private List<applist> applists;
//    private RecyclerView mRecyclerView;
//    applist applist;
//
//    private Reyclerholder adapter;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_homepage);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
//        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view3);
//        //mRecyclerView.setLayoutManager(new GridLayoutManager(Phones.this,2));
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
//
//        List applists = new ArrayList<>();
//        applist = new applist("User info", R.drawable.car);
//        applists.add(applist);
//        applist = new applist("User info", R.drawable.car);
//        applists.add(applist);
//        applist = new applist("User info", R.drawable.car);
//        applists.add(applist);
//        applist = new applist("User info", R.drawable.car);
//        applists.add(applist);
//    }
//
//}
