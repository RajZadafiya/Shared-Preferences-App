package com.example.sharedpreferencesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SignInActivity extends AppCompatActivity {

    TextView email;
    TextView password;
    Button login;
    TextView signup;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        Intent intent = getIntent();
        getSupportActionBar().hide();

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        login = findViewById(R.id.signin);
        signup = findViewById(R.id.clicksignup);

        sharedPreferences = getSharedPreferences("SharedPreferenceApp",MODE_PRIVATE);

        boolean check = sharedPreferences.getBoolean("login",false);
        if(check){
            Intent i = new Intent(SignInActivity.this,MainActivity.class);
            startActivity(i);
        }

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mail = sharedPreferences.getString("email","");
                String spassword = sharedPreferences.getString("passwords","");

                if(mail.equals(email.getText().toString()) && spassword.equals(password.getText().toString())){
                    sharedPreferences.edit().putBoolean("login",true).apply();
                    Intent i = new Intent(SignInActivity.this,MainActivity.class);
                    startActivity(i);
                }else{
                    Toast.makeText(SignInActivity.this, "Invalid Email Or Password!!!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent user = new Intent(SignInActivity.this,SignUpActivity.class);
                startActivity(user);
            }
        });

    }
}