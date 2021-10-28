package com.example.codeland.bmob;


import cn.bmob.v3.BmobObject;

public class Content extends BmobObject {

    private String name;
    private String date;
    private String content;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String address) {
        this.date = address;
    }

    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
}