package com.example.profile_datamodel;

public class Profile {
    private String name;

    // سازنده پیش‌فرض
    public Profile() {
    }

    // سازنده با پارامتر
    public Profile(String name) {
        this.name = name;
    }

    // متدهای دسترسی
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
} 