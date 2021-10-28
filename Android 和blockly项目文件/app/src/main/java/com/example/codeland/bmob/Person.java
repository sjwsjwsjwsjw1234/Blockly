package com.example.codeland.bmob;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.datatype.BmobFile;

public class Person extends BmobObject {

    private String name;
    //头像
    BmobFile Photo;
    private String password;
    //手机号码
    String Number;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }
    public BmobFile getPhoto() {
        return Photo;
    }

    public void setPhoto(BmobFile photo) {
        Photo = photo;
    }
}