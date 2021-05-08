package com.example.architecturecomponents;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user_info_table")
public class UserInfo {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String email;

    private String password;

    public UserInfo(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setId(int id) {
        this.id = id;
    }
}
