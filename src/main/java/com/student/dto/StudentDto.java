package com.student.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto implements Serializable {
    @NotEmpty
    @Size(min = 1, max = 50, message = "firstName should be between 1 and 50 characters")
    private String firstName;
    @NotBlank
    @Size(min = 1, max = 50, message = "lastName should be between 1 and 50 characters")
    private String lastName;
    @Email(message = "Email should be valid")
    private String email;
    @NotNull
    private String gender;
    @NotNull
    private Date dateOfBirth;
    @NotNull
    private String countryOfBirth;

//    public StudentDto() {
//    }
//
//    StudentDto(String first_name, String last_name, String email, String gender, Date date_of_birth, String country_of_birth) {
//        this.first_name = first_name;
//        this.last_name = last_name;
//        this.email = email;
//        this.gender = gender;
//        this.date_of_birth = date_of_birth;
//        this.country_of_birth = country_of_birth;
//    }

//    public String getFirst_name() {
//        return first_name;
//    }
//
//    public void setFirst_name(String first_name) {
//        this.first_name = first_name;
//    }
//
//    public String getLast_name() {
//        return last_name;
//    }
//
//    public void setLast_name(String last_name) {
//        this.last_name = last_name;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getGender() {
//        return gender;
//    }
//
//    public void setGender(String gender) {
//        this.gender = gender;
//    }
//
//    public Date getDate_of_birth() {
//        return date_of_birth;
//    }
//
//    public void setDate_of_birth(Date date_of_birth) {
//        this.date_of_birth = date_of_birth;
//    }
//
//    public String getCountry_of_birth() {
//        return country_of_birth;
//    }
//
//    public void setCountry_of_birth(String country_of_birth) {
//        this.country_of_birth = country_of_birth;
//    }
}
