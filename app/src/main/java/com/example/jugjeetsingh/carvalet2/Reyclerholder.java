//package com.example.jugjeetsingh.carvalet2;
//
//import android.content.Context;
//import android.content.Intent;
//import android.os.Bundle;
//import android.support.annotation.NonNull;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import java.util.ArrayList;
//import java.util.List;
//
//
//
//public class Reyclerholder extends RecyclerView.Adapter<Reyclerholder.ViewHolder> {
//    private List<applist> applists;
//    private Context context;
//    private  OnItemClickListener onItemClickListener;
//
//
//    Reyclerholder(Context context, List<applist> applists){
//        this.context=context;
//        this.applists=applists;
//    }
//    @NonNull
//    @Override
//    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.carviewlayout, null);
//        ViewHolder vv = new ViewHolder(view);
//        return vv;
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        final applist applist = applists.get(position);
//
//        holder.img1.setImageResource(applists.get(position).getImageview());
//        holder.txt1.setText(applists.get(position).getText());
//
//       View.OnClickListener listener= new View.OnClickListener() {
//           @Override
//           public void onClick(View view ){
//               onItemClickListener.onItemClick(applist);
//
//           }
//       };
//
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return applists.size();
//    }
//
//    public class ViewHolder extends RecyclerView.ViewHolder {
//        protected ImageView img1,img2,img3,img4,img5,img6;
//        protected TextView txt1,txt2,txt3,txt4,txt5,txt6,txt7;
//        public ViewHolder(View itemView) {
//            super(itemView);
//            img1 = itemView.findViewById(R.id.img1);
//            img2 = itemView.findViewById(R.id.img2);
//            img3 = itemView.findViewById(R.id.img3);
//            img4 = itemView.findViewById(R.id.img4);
//            img5 = itemView.findViewById(R.id.img5);
//            img6 = itemView.findViewById(R.id.img6);
//
//            txt1=itemView.findViewById(R.id.textGrid);
//            txt2=itemView.findViewById(R.id.txt3);
//            txt3=itemView.findViewById(R.id.txt4);
//            txt4=itemView.findViewById(R.id.txt5);
//            txt5=itemView.findViewById(R.id.txt6);
//            txt6=itemView.findViewById(R.id.txt7);
//            txt7=itemView.findViewById(R.id.txt8);
//
//
//        }
//    }
//    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
//        this.onItemClickListener = onItemClickListener;
//    }
//
//}
