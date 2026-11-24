package com.syrine.mvcapplication.model;

public class Person {
    private String firstName;
    private String lastName;
    private String birthDay;
    private String sex;
    public Person(String firstName,String lastName,String birthDay,String sex) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDay = birthDay;
        this.sex=sex;
    }
    public Person() {
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public String getLastName() {
        return lastName;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getBirthDay() {
        return birthDay;
    }
    public String getSex() {
        return sex;
    }
}