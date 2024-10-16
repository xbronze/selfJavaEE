package com.dingli.chapter9experiment;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author: xbronze
 * @date: 2024-10-05 22:43
 * @description: TODO
 */
public class Student {

    private String number;
    private String name;
    private String grade;
    private String clbum;
    private String gender;
    private String age;
    private MultipartFile photo;
    private String photoName;
    private String requestPath;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getClbum() {
        return clbum;
    }

    public void setClbum(String clbum) {
        this.clbum = clbum;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public MultipartFile getPhoto() {
        return photo;
    }

    public void setPhoto(MultipartFile photo) {
        this.photo = photo;
    }

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    public String getRequestPath() {
        return requestPath;
    }

    public void setRequestPath(String requestPath) {
        this.requestPath = requestPath;
    }
}
