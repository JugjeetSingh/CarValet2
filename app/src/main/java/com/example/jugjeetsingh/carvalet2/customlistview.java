package com.example.jugjeetsingh.carvalet2;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by jugjeetsingh on 18/08/18.
 */

public class customlistview extends ArrayAdapter {
    private Activity context;
    private String [] details;
    private Integer [] images;
    TextView textView;
    ImageView imageView;

    public customlistview(@NonNull Activity context, String [] details,   Integer [] images) {
        super(context, R.layout.carviewlayout, details);
       this.images=images;
        this.details=details;
        this.context=context;

    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater=context.getLayoutInflater() ;
        View view=layoutInflater.inflate(R.layout.carviewlayout,null);
        textView=view.findViewById(R.id.phone);
        imageView=view.findViewById(R.id.image);

        textView.setText(details[position]);
        imageView.setImageResource(images[position]);
        return view;
    }
}
