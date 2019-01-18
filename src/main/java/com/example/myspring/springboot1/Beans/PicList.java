package com.example.myspring.springboot1.Beans;

import java.io.Serializable;
import java.util.List;

public class PicList implements Serializable {
    private List<String> piclist;
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    public void addPic(String address){
        this.piclist.add(address);
    }
    public void deletPic(String pic){

    }
    public List<String> getPiclist() {
        return piclist;
    }

    public void setPiclist(List<String> piclist) {
        this.piclist = piclist;
    }

    @Override
    public String toString() {
        return "PicList{" +
                "piclist=" + piclist +
                ", token='" + token + '\'' +
                '}';
    }
}
