package com.student.dto;

import java.util.Date;

public class StudentDto {
    private String first_name;
    private String last_name;
    private String email;
    private String gender;
    private Date date_of_birth;
    private String country_of_birth;

    public StudentDto() {
    }

    StudentDto(String first_name, String last_name, String email, String gender, Date date_of_birth, String country_of_birth) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.gender = gender;
        this.date_of_birth = date_of_birth;
        this.country_of_birth = country_of_birth;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getCountry_of_birth() {
        return country_of_birth;
    }

    public void setCountry_of_birth(String country_of_birth) {
        this.country_of_birth = country_of_birth;
    }
}
