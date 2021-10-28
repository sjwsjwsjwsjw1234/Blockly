package com.example.codeland.bmob;

import org.litepal.crud.LitePalSupport;

import cn.bmob.v3.BmobObject;

public class CodingPlace extends BmobObject {
    private String name;
    private String date;
    private String code;

    public String getDate()
    {
        return date;
    }
    public String getCode()
    {
        return code;
    }
    public String getName()
    {
        return name;
    }
    public void setDate(String date)
    {
        this.date=date;
    }
    public void setCode(String code)
    {
        this.code=code;
    }
    public void setName(String name)
    {
        this.name=name;
    }

}