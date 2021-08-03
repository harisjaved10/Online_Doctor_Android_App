package com.example.online_doctor_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class HomePage extends AppCompatActivity {

    TextView doctor_text, ambulance_text, corona_text, labs_text;
    Button btn_logout;
    FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        doctor_text = findViewById(R.id.doctor_text);
        ambulance_text = findViewById(R.id.ambulance_text);
        corona_text = findViewById(R.id.corona_text);
        labs_text = findViewById(R.id.labs_text);
        btn_logout = findViewById(R.id.btn_logout);

        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FirebaseAuth.getInstance().signOut();
                Intent obj = new Intent(HomePage.this, Login.class );
                startActivity(obj);
            }
        });

        doctor_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intToMain = new Intent(HomePage.this, Doctors.class );
                startActivity(intToMain);

            }
        });

        ambulance_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intToMain = new Intent(HomePage.this, ambulance_page.class );
                startActivity(intToMain);

            }
        });

        corona_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intToMain = new Intent(HomePage.this, CovidPage.class );
                startActivity(intToMain);

            }
        });

        labs_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intToMain = new Intent(HomePage.this, LabsPage.class);
                startActivity(intToMain);
            }
        });

    }
}


