package com.example.sharedpreferencesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    EditText name;
    EditText mail;
    EditText password;
    EditText phone;
    EditText address;
    TextView login;
    Button register;
    RadioButton male;
    RadioButton female;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Intent i = new Intent();
        getSupportActionBar().hide();

        name = findViewById(R.id.name);
        password = findViewById(R.id.password);
        mail = findViewById(R.id.email);
        phone = findViewById(R.id.mobile);
        address = findViewById(R.id.address);
        login = findViewById(R.id.alreadyacount);
        register = findViewById(R.id.signup);
        male = findViewById(R.id.male);
        female = findViewById(R.id.female);

        sharedPreferences = getSharedPreferences("SharedPreferenceApp",MODE_PRIVATE);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String names = name.getText().toString();
                String email = mail.getText().toString();
                String passwords = password.getText().toString();

                if (!(names.isEmpty() && email.isEmpty() && passwords.isEmpty())) {

                    sharedPreferences.edit().putString("name",names).apply();
                    sharedPreferences.edit().putString("email",email).apply();
                    sharedPreferences.edit().putString("passwords",passwords).apply();
                    sharedPreferences.edit().putBoolean("login",true).apply();
                    sharedPreferences.edit().putBoolean("savedstate",true).apply();

                    Intent intent = new Intent(SignUpActivity.this, SignInActivity.class);
                    Toast.makeText(SignUpActivity.this, "login", Toast.LENGTH_SHORT).show();
                    startActivity(intent);

                }

            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this, SignInActivity.class);
                Toast.makeText(SignUpActivity.this, "login", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });
    }
}