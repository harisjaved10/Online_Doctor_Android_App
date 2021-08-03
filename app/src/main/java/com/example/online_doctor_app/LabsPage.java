package com.example.online_doctor_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LabsPage extends AppCompatActivity {

    Button excel_call, excel_location, IL_call, IL_location, GL_call, GL_location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_labs_page);

        excel_call = findViewById(R.id.excel_call);
        excel_location = findViewById(R.id.excel_location);

        IL_call = findViewById(R.id.IL_call);
        IL_location = findViewById(R.id.IL_location);

        GL_call = findViewById(R.id.GL_call);
        GL_location = findViewById(R.id.GL_location);

        excel_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent obj = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: 0518311006"));
                startActivity(obj);
            }
        });

        excel_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent obj = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("https://goo.gl/maps/nkisgtV6cwwgMucs6"));
                startActivity(obj);
            }
        });

        IL_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent obj = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: +92512251212"));
                startActivity(obj);
            }
        });

        IL_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent obj = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("https://goo.gl/maps/o1eF9f7tF7rczoKt6"));
                startActivity(obj);
            }
        });

        GL_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent obj = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: 0917158555"));
                startActivity(obj);
            }
        });

        GL_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent obj = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("https://goo.gl/maps/VdoXQ4B8oW8hk9sG6"));
                startActivity(obj);
            }
        });

    }
}
