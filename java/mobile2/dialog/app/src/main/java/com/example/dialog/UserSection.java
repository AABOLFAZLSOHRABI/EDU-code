package com.example.dialog;

import java.util.List;

public class UserSection {

    private final String title;
    private final List&lt;UserModel&gt; users;

    public UserSection(String title, List&lt;UserModel&gt; users) {
        this.title = title;
        this.users = users;
    }

    public String getTitle() {
        return title;
    }

    public List&lt;UserModel&gt; getUsers() {
        return users;
    }
}