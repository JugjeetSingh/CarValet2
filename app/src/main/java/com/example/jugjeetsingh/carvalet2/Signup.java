package com.example.jugjeetsingh.carvalet2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Signup extends AppCompatActivity {
    EditText edt1,edt2,edt3,edt4,edt5;
    Button btn3,btn4;
    SQLiteDatabase sqLiteDatabase;
    String name,password,email,mobile;
    TextView textView;
    private FirebaseAuth mAuth;
    SharedPreferences sharedpreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        edt1= findViewById(R.id.editText3);
        edt2=findViewById(R.id.editText4);
        edt3= findViewById(R.id.editText5);
        edt4= findViewById(R.id.editText6);
        mAuth = FirebaseAuth.getInstance();

        edt5= findViewById(R.id.editText8);
        btn3=findViewById(R.id.button2);

        sharedpreferences = getSharedPreferences("mydata",
                Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedpreferences.edit();
//        String username = sharedpreferences.getString("Name", "0");
//        String email = sharedpreferences.getString("email", "0");
//        String phone = sharedpreferences.getString("phone", "0");
//        String carnumber = sharedpreferences.getString("car", "0");

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String password=edt2.getText().toString();
                String email=edt3.getText().toString();
                String name=edt1.getText().toString();
                String number=edt4.getText().toString();
                String carnumber=edt5.getText().toString();

                mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(Signup.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                       Toast.makeText(getApplicationContext(),"Register successfully",Toast.LENGTH_LONG).show();
                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(),"Register unsuccessfully",Toast.LENGTH_LONG).show();

                        }
                    }
                });
                editor.putString("Name", name);
                editor.putString("Email",email);
                editor.putString("phonenumber",number);
                editor.putString("carnumber",carnumber);
                editor.commit();


            }
        });

        }

}
