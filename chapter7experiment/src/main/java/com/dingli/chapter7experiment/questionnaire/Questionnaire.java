package com.dingli.chapter7experiment.questionnaire;

import java.util.Arrays;

/**
 * @author: xbronze
 * @date: 2024-10-23 08:57
 * @description: TODO
 */
public class Questionnaire {

    public String username;
    private String gender;
    private int age;
    private String address;
    private Boolean work;
    private String[] hobbies;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getWork() {
        return work;
    }

    public void setWork(Boolean work) {
        this.work = work;
    }

    public String[] getHobbies() {
        return hobbies;
    }

    public void setHobbies(String[] hobbies) {
        this.hobbies = hobbies;
    }

    @Override
    public String toString() {
        return "Questionnaire{" +
                "username='" + username + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", work=" + work +
                ", hobbies=" + Arrays.toString(hobbies) +
                '}';
    }
}
