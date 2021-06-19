package com.src.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Human {

    private int id;
    private String firstName;
    private String lastName;
    private String patronymic;
    private int yearOfBirth;
    private int inn;
    private String country;
    private String gender;

    public Human(){}

    public Human(int id, String firstName, String lastName, String patronymic, int yearOfBirth,
                      int inn, String country, String gender){
        id = this.id;
        firstName = this.firstName;
        lastName = this.lastName;
        patronymic = this.patronymic;
        yearOfBirth = this.yearOfBirth;
        inn = this.inn;
        country = country;
        gender = this.gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public int getInn() {
        return inn;
    }

    public void setInn(int inn) {
        this.inn = inn;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", firstname='" + firstName + '\'' +
                ", lastname='" + lastName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                ", inn=" + inn +
                ", country='" + country + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
