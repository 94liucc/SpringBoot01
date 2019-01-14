package com.example.myspring.springboot1.Beans;

import org.springframework.data.annotation.Id;

import java.io.Serializable;

public class User  implements Serializable {
    private  String name;
    @Id
    private  int id;
    private  String phone;
    private  String token;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", phone='" + phone + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
