package com.example.sharedpreferencesapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Display;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    CheckBox ch, ch1, ch2, ch3;
    EditText name,email,semester,address;
    String msg="";
    RadioGroup radioGroup;
    RadioButton selectedRadioButton;
    TextView alreadyacc;
    Button submit;
    ArrayAdapter<String> adapter;
    String selectedRbText;
    private static final String[] COUNTRIES = new String[] {
            "Electrical Engineering", "Mechanical Engineering", "Civil Engineering", "Computer Engineering", "Information Technology"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences("SharedPreferenceApp", MODE_PRIVATE);

        Intent i = new Intent(MainActivity.this, DisplayActivity.class);

        ch = (CheckBox) findViewById(R.id.checkBox);
        ch1 = (CheckBox) findViewById(R.id.checkBox2);
        ch2 = (CheckBox) findViewById(R.id.checkBox3);
        ch3 = (CheckBox) findViewById(R.id.checkBox4);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        semester = findViewById(R.id.sem);
        address = findViewById(R.id.address);
        radioGroup = findViewById(R.id.radiogroup);
        alreadyacc = findViewById(R.id.alreadyaccount);
        submit = findViewById(R.id.signup);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedRadioButtonId = radioGroup.getCheckedRadioButtonId();
                if (selectedRadioButtonId != -1) {
                    selectedRadioButton = findViewById(selectedRadioButtonId);
                    selectedRbText = selectedRadioButton.getText().toString();
                }

                 new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_dropdown_item_1line,COUNTRIES);
                AutoCompleteTextView textView = (AutoCompleteTextView)
                        findViewById(R.id.branch);
                textView.setThreshold(1);
                textView.setAdapter(adapter);

                if (ch.isChecked()){
                    msg = msg + " Painting ";}
                if (ch1.isChecked()){
                    msg = msg + " Reading ";}
                if (ch2.isChecked()){
                    msg = msg + " Singing ";}
                if (ch3.isChecked()){
                    msg = msg + " Cooking ";}

                i.putExtra("name",name.getText().toString());
                i.putExtra("email",email.getText().toString());
                i.putExtra("address",address.getText().toString());
                i.putExtra("semester",semester.getText().toString());
                i.putExtra("gender",selectedRbText);
                i.putExtra("hobby",msg);

                Toast.makeText(MainActivity.this, ""+name.getText().toString()+email.getText().toString()
                        +address.getText().toString()+semester.getText().toString()+msg+selectedRbText, Toast.LENGTH_SHORT).show();

                startActivity(i);

            }
        });
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
                Intent setting = new Intent(MainActivity.this,ProfileActivity.class);
                Toast.makeText(MainActivity.this, "Profile...", Toast.LENGTH_SHORT).show();
                startActivity(setting);
                break;
            case R.id.settings:
                Intent settings = new Intent(MainActivity.this,SettingsActivity.class);
                Toast.makeText(MainActivity.this, "Settings...", Toast.LENGTH_SHORT).show();
                startActivity(settings);
                break;
            case R.id.logout:
                Intent intent = new Intent(MainActivity.this,SignInActivity.class);
                sharedPreferences.edit().putBoolean("login",false).apply();
                Toast.makeText(MainActivity.this, "Logged Out!!!", Toast.LENGTH_SHORT).show();
                startActivity(intent);
        }
        return true;
    }
}