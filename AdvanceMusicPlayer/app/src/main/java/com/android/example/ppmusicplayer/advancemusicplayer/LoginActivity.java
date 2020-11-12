package com.android.example.ppmusicplayer.advancemusicplayer;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;

import com.android.example.ppmusicplayer.advancemusicplayer.R;

public class LoginActivity extends AppCompatActivity {
    EditText username,password;
    Button login,register;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);
        register = findViewById(R.id.register);
        databaseHelper = new DatabaseHelper(this);


        login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String usernameValue = username.getText().toString();
                String passwordValue = password.getText().toString();

                if(databaseHelper.isLoginValid(usernameValue,passwordValue)){

                    Intent intent = new Intent(LoginActivity.this, Tunes.class);
                    startActivities(intent);
                    Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();

                }
                else {
                    Toast.makeText(LoginActivity.this, "Invalid username or Password!", Toast.LENGTH_SHORT).show();
                }


            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivities(intent);

            }
        });


    }

    private void startActivities(Intent intent) {
    }


}