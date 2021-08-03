package com.example.online_doctor_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Doctors extends AppCompatActivity implements DoctorAdapter.ItemClicked{

    ImageView doc_pic;
    TextView doc_name, doc_degree;
    Button doc_appoint, doc_location;

    FragmentManager fragmentManager;
    Fragment DoctorsListFrag, DoctorsDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctors);

        doc_pic = findViewById(R.id.doc_pic);
        doc_name = findViewById(R.id.doc_name);
        doc_degree = findViewById(R.id.doc_degree);
        doc_appoint = findViewById(R.id.doc_appoint);
        doc_location = findViewById(R.id.doc_location);

        fragmentManager = getSupportFragmentManager();

        DoctorsListFrag = fragmentManager.findFragmentById(R.id.doc_list_frag);
        DoctorsDetail = fragmentManager.findFragmentById(R.id.doctors_details);

        fragmentManager.beginTransaction()
                .show(DoctorsListFrag)
                .show(DoctorsDetail)
                .commit();

        doc_appoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent obj = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: 0515467812"));
                startActivity(obj);
            }
        });

        doc_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent obj = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("https://goo.gl/maps/6VUZdhtSSRdnvNWX7"));
                startActivity(obj);
            }
        });

        onItemClicked(0);

    }



    @Override
    public void onItemClicked(int index) {

        doc_name.setText(AppClass.doctors.get(index).getName());
        doc_degree.setText(AppClass.doctors.get(index).getDegree());
        doc_pic.setImageResource(R.drawable.doc);


    }
}
