package com.example.online_doctor_app;

public class All_doctors_data {

    private String name;
    private String degree;
    private String phone_no;

    public All_doctors_data(String name, String degree, String phone_no) {
        this.name = name;
        this.degree = degree;
        this.phone_no = phone_no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }
}
