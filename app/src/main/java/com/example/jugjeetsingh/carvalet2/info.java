package com.example.jugjeetsingh.carvalet2;

import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.squareup.picasso.Picasso;

public class info extends AppCompatActivity {
    TextView txt2, txt3, txt4, txt5, txt6;
    String uname, uemail, number, carnumber;
    SharedPreferences sharedpreferences;
    String name, email, image, name1, email1, image1;
    ImageView imageView;
    private GoogleApiClient mGoogleApiClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        txt2 = findViewById(R.id.blood_group);
        txt3 = findViewById(R.id.education);
        txt4 = findViewById(R.id.mobileNumber);
        txt5 = findViewById(R.id.occupation);
        imageView = findViewById(R.id.image);


        sharedpreferences = getSharedPreferences("mydata", MODE_PRIVATE);
        String username = sharedpreferences.getString("Name", "0");
        String email = sharedpreferences.getString("Email", "0");
        String phone = sharedpreferences.getString("phonenumber", "0");
        String carnumber = sharedpreferences.getString("carnumber", "0");
        txt2.setText(username);
        txt3.setText(email);
        txt4.setText(phone);
        txt5.setText(carnumber);
        txt3.setText(email);
        txt4.setText(number);
        txt5.setText(carnumber);

//        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//                .requestEmail()
//                .build();
//
//        mGoogleApiClient = new GoogleApiClient.Builder(this)
//                .enableAutoManage(this, this)
//                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
//                .build();
//        name1=getIntent().getExtras().getString("name1");
//        email1=getIntent().getExtras().getString("email1");
//        image1=getIntent().getExtras().getString("pic1");
////        View view=navigationView.inflateHeaderView(R.layout.nav_header_main);*/
//        if(name!=null&&email!=null&&image!=null)
//         {
//
//            txt2.setText(name1);
//            txt3.setText(email1);
//            Picasso.with(getApplicationContext()).load(image1).into(imageView);
//
//        }
//
//
//    }

//    @Override
//    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
//        Toast.makeText(getApplicationContext(),"Failed",Toast.LENGTH_SHORT).show();
//
//    }
    }
}