package com.example.online_doctor_app;

import android.app.Application;

import java.util.ArrayList;

public class AppClass extends Application {

    public static ArrayList<All_doctors_data> doctors;

    @Override
    public void onCreate() {
        super.onCreate();

        doctors = new ArrayList<All_doctors_data>();

        doctors.add(new All_doctors_data("Dr. Ahmed", "MBBS", "051-5627830"));
        doctors.add(new All_doctors_data("Dr. Bisma", "Child Specialist", "051-9876094"));
        doctors.add(new All_doctors_data("Dr. Jamal", "Surgeon", "042-4457890"));
        doctors.add(new All_doctors_data("Dr. Tariq", "MBBS", "021-6621780"));
        doctors.add(new All_doctors_data("Dr. Hassan", "Cardiac Specialist", "042-9071569"));
        doctors.add(new All_doctors_data("Dr. Mushtaq", "Surgeon", "051-6572830"));
        doctors.add(new All_doctors_data("Dr. Bashir", "Cardiac Specialist", "051-6572830"));
        doctors.add(new All_doctors_data("Dr. James", "Dentist", "051-6572830"));
    }
}
