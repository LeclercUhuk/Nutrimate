package com.example.nutrimate;

import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.os.Bundle;
import android.view.View;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class EditProfileActivity extends AppCompatActivity {
    private ImageView profilePicture;
    private TextView tvName, tvId;
    private EditText etEmail, etDob, etGender;
    private Button btnChangePassword, btnLogout;
    private DatabaseHelper dbhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_profile);

        // Inisialisasi DatabaseHelper
        dbhelper = new DatabaseHelper(this);

        profilePicture = findViewById(R.id.profile_picture);
        tvName = findViewById(R.id.tv_name);
        tvId = findViewById(R.id.tv_id);
        etEmail = findViewById(R.id.et_email);
        etDob = findViewById(R.id.et_dob);
        etGender = findViewById(R.id.et_gender);
        btnLogout = findViewById(R.id.btn_logout);

        String email = getIntent().getStringExtra("email");
        String name = dbhelper.getColumnName(email);
        String id = "ID : " + dbhelper.getColumnId(email);

        tvName.setText(name);
        tvId.setText(id);
        etGender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showGenderDialog();
            }
        });

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EditProfileActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void showGenderDialog() {
        final String[] genders = {"Male", "Female"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Select Gender");
        builder.setItems(genders, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                etGender.setText(genders[which]);
            }
        });
        builder.show();
    }
}
