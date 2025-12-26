package com.example.database;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "users")
public class UserModel {

    @PrimaryKey(autoGenerate = true)
    private long id;

    private String name;
    private String family;
    private String email;

    public UserModel(String name, String family, String email) {
        this.name = name;
        this.family = family;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getFamily() {
        return family;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}