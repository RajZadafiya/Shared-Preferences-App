package com.example.sharedpreferencesapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayActivity extends AppCompatActivity {

    TextView named,emaild,addressd,semesterd,genderd,hobbyd;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        sharedPreferences = getSharedPreferences("SharedPreferenceApp", MODE_PRIVATE);

        Intent i = getIntent();
        String name = i.getStringExtra("name");
        String email = i.getStringExtra("email");
        String address = i.getStringExtra("address");
        String semester = i.getStringExtra("semester");
        String gender = i.getStringExtra("gender");
        String hobby = i.getStringExtra("hobby");

        named = findViewById(R.id.named);
        emaild = findViewById(R.id.emaild);
        addressd = findViewById(R.id.addressd);
        semesterd = findViewById(R.id.semesterd);
        genderd = findViewById(R.id.genderd);
        hobbyd = findViewById(R.id.hobbyd);

        named.setText(name);
        emaild.setText(email);
        addressd.setText(address);
        semesterd.setText(semester);
        genderd.setText(gender);
        hobbyd.setText(hobby);

        Toast.makeText(DisplayActivity.this, ""+name+email+address+semester+gender+hobby, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu){

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        Intent in = getIntent();

        switch (item.getItemId()){
            case R.id.profile:
                Intent setting = new Intent(DisplayActivity.this,ProfileActivity.class);
                Toast.makeText(DisplayActivity.this, "Profile...", Toast.LENGTH_SHORT).show();
                startActivity(setting);
                break;
            case R.id.settings:
                Intent settings = new Intent(DisplayActivity.this,SettingsActivity.class);
                Toast.makeText(DisplayActivity.this, "Settings...", Toast.LENGTH_SHORT).show();
                startActivity(settings);
                break;
            case R.id.logout:
                Intent intent = new Intent(DisplayActivity.this,SignInActivity.class);
                sharedPreferences.edit().putBoolean("login",false).apply();
                Toast.makeText(DisplayActivity.this, "Logged Out!!!", Toast.LENGTH_SHORT).show();
                startActivity(intent);
        }
        return true;
    }
}