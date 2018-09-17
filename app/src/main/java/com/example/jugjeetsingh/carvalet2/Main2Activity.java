package com.example.jugjeetsingh.carvalet2;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class Main2Activity extends AppCompatActivity {
   private Button btn3, btn4, btn5,updatebuttons, mButtonStartPause ;
    private Button mButtonReset;
    Chronometer chronometer;
    public int counter;
    TextView textView, textView1,mTextViewCountDown;
    long millisLeft;
    SharedPreferences sharedpreferences;
    private boolean mTimerRunning;

    private long mTimeLeftInMillis;
    private long mEndTime;
    private static final long START_TIME_IN_MILLIS = 600000;

    private CountDownTimer mCountDownTimer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btn3 = findViewById(R.id.button3);
        textView = findViewById(R.id.textView);
        textView1 = findViewById(R.id.textView2);
        mTextViewCountDown= findViewById(R.id.text_view_countdown);
        mButtonStartPause = findViewById(R.id.button_start_pause);
        mButtonReset= findViewById(R.id.button_reset);
        sharedpreferences = getSharedPreferences("booking", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor1 = sharedpreferences.edit();



        mButtonStartPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = textView.getText().toString();
                String Carnumber = textView1.getText().toString();

                Toast.makeText(getApplicationContext(), "Thank you " + name + " for Booking. Select your area", Toast.LENGTH_LONG).show();

                editor1.putString("Name", name);
                editor1.putString("carnumber", Carnumber);
                editor1.commit();
            }


        });

//        btn1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//
//                switch (view.getId()){
//                    case R.id.button3:
//                        btn1.setText("Booked");
//                        btn1.setBackgroundColor(Color.WHITE);
//                        chronometer.setVisibility(View.VISIBLE);
//                        timer.start();
//                        Toast.makeText(getApplicationContext(),"Your parking slot is booked. This area available for you for next 1 hour. ",Toast.LENGTH_LONG).show();
//
//                }
//
////                        // chronometer.setBackgroundColor(Color.BLUE);
////                    btn1.setBackgroundColor(Color.BLACK);
////                        Toast.makeText(getApplicationContext(),"Your parking slot is booked. This area available for you for next 1 hour. ",Toast.LENGTH_LONG).show();
////
////                break;
//
//
//                }
//
//        });

    btn3.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (mTimerRunning) {
                pauseTimer();
            } else {
                startTimer();
            }
            switch (view.getId()){
                    case R.id.button3:
                        btn3.setText("Booked");
                        btn3.setBackgroundColor(Color.WHITE);

                        Toast.makeText(getApplicationContext(),"Your parking slot is booked. This area available for you for next 1 hour. ",Toast.LENGTH_LONG).show();

               }
        }


    });
        mButtonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetTimer();
            }
        });


    }



    private void startTimer() {
        mEndTime = System.currentTimeMillis() + mTimeLeftInMillis;

        mCountDownTimer = new CountDownTimer(mTimeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeftInMillis = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                mTimerRunning = false;
                updateButtons();
            }
        }.start();

        mTimerRunning = true;
        updateButtons();
    }

    private void pauseTimer() {
        mCountDownTimer.cancel();
        mTimerRunning = false;
        updateButtons();
    }

    private void resetTimer() {
        mTimeLeftInMillis = START_TIME_IN_MILLIS;
        updateCountDownText();
        updateButtons();
    }

    private void updateCountDownText() {
        int minutes = (int) (mTimeLeftInMillis / 1000) / 60;
        int seconds = (int) (mTimeLeftInMillis / 1000) % 60;

        String timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);

        mTextViewCountDown.setText(timeLeftFormatted);
    }

    private void updateButtons() {
        if (mTimerRunning) {
            mButtonReset.setVisibility(View.INVISIBLE);
            mButtonStartPause.setText("Click to Book");
        } else {
            mButtonStartPause.setText("Click to Book");

            if (mTimeLeftInMillis < 1000) {
                mButtonStartPause.setVisibility(View.VISIBLE);
            } else {
                mButtonStartPause.setVisibility(View.VISIBLE);
            }

            if (mTimeLeftInMillis < START_TIME_IN_MILLIS) {
                mButtonReset.setVisibility(View.VISIBLE);
             }
 else {
                mButtonReset.setVisibility(View.INVISIBLE);
            }
        }
    }

    @Override
    protected void onStop() {
        super.onStop();

        SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        editor.putLong("millisLeft", mTimeLeftInMillis);
        editor.putBoolean("timerRunning", mTimerRunning);
        editor.putLong("endTime", mEndTime);

        editor.apply();

        if (mCountDownTimer != null) {
            mCountDownTimer.cancel();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);

        mTimeLeftInMillis = prefs.getLong("millisLeft", START_TIME_IN_MILLIS);
        mTimerRunning = prefs.getBoolean("timerRunning", false);

        updateCountDownText();
        updateButtons();

        if (mTimerRunning) {
            mEndTime = prefs.getLong("endTime", 0);
            mTimeLeftInMillis = mEndTime - System.currentTimeMillis();

            if (mTimeLeftInMillis < 0) {
                mTimeLeftInMillis = 0;
                mTimerRunning = false;
                updateCountDownText();
                updateButtons();
            } else {
                startTimer();
            }
        }
    }}



