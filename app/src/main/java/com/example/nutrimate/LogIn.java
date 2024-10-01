package com.example.nutrimate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LogIn extends AppCompatActivity {
    EditText emaillogin;
    EditText passwordlogin;
    Button loginbutton;
    DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);

        emaillogin = findViewById(R.id.emaillogin);
        passwordlogin = findViewById(R.id.passwordlogin);
        loginbutton = findViewById(R.id.loginbutton);
        dbHelper = new DatabaseHelper(this);

        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emaillogin.getText().toString();
                String password = passwordlogin.getText().toString();

                if (email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(LogIn.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                } else {
                    boolean result = dbHelper.checkUser(email, password);
                    if (result) {
                        Toast.makeText(LogIn.this, "Sign In Successful", Toast.LENGTH_SHORT).show();
                        // Redirect to home activity or another activity
                        Intent intent = new Intent(LogIn.this, HomeActivity.class);
                        intent.putExtra("email", email);
                        startActivity(intent);
                    } else {
                        Toast.makeText(LogIn.this, "Invalid email or Password", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


    }
}
//    Intent intent = new Intent(LogIn.this, HomeActivity.class);
//    startActivity(intent);