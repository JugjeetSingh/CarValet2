package com.example.jugjeetsingh.carvalet2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  {
    EditText username, password;
    Button login,signup1;
    SQLiteDatabase sqLiteDatabase;
    int count;

    private FirebaseAuth mAuth;

    ImageView imageView;
    String emailid;
    SharedPreferences sharedPreferences;
    private GoogleApiClient mGoogleApiClient;
    private SignInButton btnSignIn;
    private static final int RC_SIGN_IN = 007;
    private static final String TAG = MainActivity.class.getSimpleName();
    SharedPreferences sharedpreferences1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = findViewById(R.id.username);
        mAuth = FirebaseAuth.getInstance();
        password = findViewById(R.id.passwrod);
        login = findViewById(R.id.login);
        signup1 = findViewById(R.id.signup);

        sharedpreferences1 = getSharedPreferences("Data",
                Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedpreferences1.edit();
        String aa = sharedpreferences1.getString("emailid", "0");
        if (aa != "0") {
            Intent intent = new Intent(MainActivity.this, homepage1.class);
            startActivity(intent);
        }
//        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//                .requestEmail()
//                .build();
//
//        mGoogleApiClient = new GoogleApiClient.Builder(this)
//                .enableAutoManage(this, this)
//                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
//                .build();
//        btnSignIn = (SignInButton) findViewById(R.id.sign_in_button);
//        btnSignIn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
//                startActivityForResult(signInIntent, RC_SIGN_IN);
//            }
//        });


        signup1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Signup.class);
                startActivity(intent);

            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    final String email = username.getText().toString();
                    String pass = password.getText().toString();
                    mAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(getApplicationContext(), "Welcome " + email, Toast.LENGTH_LONG).show();

                                editor.putString("emailid", email);
                                editor.apply();
                                Intent in = new Intent(MainActivity.this, homepage1.class);
                                startActivity(in);
                                finish();
                            } else {
                                Toast.makeText(getApplicationContext(), "Login unsuccessfully", Toast.LENGTH_LONG).show();

                            }
                        }
                    });

                } catch (Exception ee) {
                    Toast.makeText(getApplicationContext(), "Enter your Email or password", Toast.LENGTH_LONG).show();


                }
            }


        });
    }


//        @Override
//        protected void onActivityResult ( int requestCode, int resultCode, Intent data){
//
//            if (requestCode == RC_SIGN_IN) {
//                GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
//                handleSignInResult(result);
//            }
//            super.onActivityResult(requestCode, resultCode, data);
//        }
//
//    private void handleSignInResult(GoogleSignInResult result) {
//        Log.d(TAG, "handleSignInResult:" + result.isSuccess());
//        if (result.isSuccess()) {
//            // Signed in successfully, show authenticated UI.
//            GoogleSignInAccount acct = result.getSignInAccount();
//
//            Log.e(TAG, "display name: " + acct.getDisplayName());
//
//            String personName = acct.getDisplayName();
//            String personPhotoUrl = acct.getPhotoUrl().toString();
//            String email = acct.getEmail();
//            Intent in = new Intent(MainActivity.this, info.class);
//            in.putExtra("name1", personName);
//            in.putExtra("email1", email);
//            in.putExtra("pic1", personPhotoUrl);
//            startActivity(in);
//            finish();
//
//
//        }
//
//    }
//
//
//    @Override
//    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
//        Toast.makeText(getApplicationContext(),"Failed",Toast.LENGTH_SHORT).show();
//
  }

