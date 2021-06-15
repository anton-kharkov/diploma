package com.src.domain;

public class Client {

    private int id;
    private String firstname;
    private String lastname;
    private String patronymic;
    private int yearOfBirth;
    private int inn;
    private String country;
    private String gender;

    public void Client(){}

    public void Client(String firstname, String lastname, String patronymic, int yearOfBirth,
                       int inn, String country, String gender){
        firstname = this.firstname;
        lastname = this.lastname;
        patronymic = this.patronymic;
        yearOfBirth = this.yearOfBirth;
        inn = this.inn;
        country = this.country;
        gender = this.gender;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                ", inn=" + inn +
                ", country='" + country + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
