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
}
