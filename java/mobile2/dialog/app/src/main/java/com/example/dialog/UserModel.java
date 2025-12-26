package com.example.dialog;

public class UserModel {

    private final int imageResId;
    private final String name;
    private final int age;

    public UserModel(int imageResId, String name, int age) {
        this.imageResId = imageResId;
        this.name = name;
        this.age = age;
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}