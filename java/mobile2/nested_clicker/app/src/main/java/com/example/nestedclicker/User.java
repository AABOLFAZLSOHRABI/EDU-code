package com.example.nestedclicker;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    public static List<User> getUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User("John"));
        users.add(new User("Jane"));
        users.add(new User("Peter"));
        users.add(new User("Paul"));
        users.add(new User("Mary"));
        return users;
    }
}