package com.example.sharedpreferencesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {

    ImageView image;
    public static int count=0;
    Timer _t;
    int[] drawablearray = new int[]{R.color.splash2,R.color.splash1,R.color.splash3};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        image = findViewById(R.id.image);

        image.animate().rotationBy(360.0f).setDuration(4000).setInterpolator(new LinearInterpolator()).start();
        _t = new Timer();
        _t.scheduleAtFixedRate(new TimerTask() {
            @Override public void run() {

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (count < drawablearray.length) {

                            image.setColorFilter(drawablearray[count]);
                            count = (count + 1) % drawablearray.length;
                        }
                    }
                } // run on ui thread                {
                );}
        }, 500, 5000);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                // This method will be executed once the timer is over
                Intent i = new Intent(SplashActivity.this, SignInActivity.class);
                startActivity(i);
                finish();
            }
        }, 5000);
    }
}