package com.example.codeland.entity;
import org.litepal.LitePal;
import org.litepal.crud.LitePalSupport;

public class Coding extends LitePalSupport {
    private String date;
    private String code;
    private String name;
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
