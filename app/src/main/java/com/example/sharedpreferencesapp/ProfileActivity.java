package com.example.sharedpreferencesapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    TextView name,password,emails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPreferences = getSharedPreferences("SharedPreferenceApp",MODE_PRIVATE);
        boolean check = sharedPreferences.getBoolean("savedstate",false);

        if(check){
            getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }else {
            getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
        setContentView(R.layout.activity_profile);

        sharedPreferences = getSharedPreferences("SharedPreferenceApp",MODE_PRIVATE);

        emails = findViewById(R.id.mailmain);
        password = findViewById(R.id.passwordmain);
        name = findViewById(R.id.namemain);

        name.setText(sharedPreferences.getString("name",""));
        password.setText(sharedPreferences.getString("email",""));
        emails.setText(sharedPreferences.getString("passwords",""));

    }
}