package com.example.online_doctor_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ambulance_page extends AppCompatActivity {

    Button edhi_call, chipa_call, rescue_call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ambulance_page);

        edhi_call = findViewById(R.id.edhi_call);
        chipa_call = findViewById(R.id.chipa_call);
        rescue_call = findViewById(R.id.rescue_call);

        edhi_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent obj = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: 115"));
                startActivity(obj);
            }
        });

        chipa_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent obj = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: 1020"));
                startActivity(obj);
            }
        });

        rescue_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent obj = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: 1122"));
                startActivity(obj);
            }
        });


    }
}
