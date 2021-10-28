package com.example.codeland.util;


import java.util.ArrayList;

public class Temp {
    ArrayList<String> tt=new ArrayList<>();
    public void addtt(String string){
        tt.add(string);
    }
    public boolean equal(String string){
        if(tt.indexOf(string)==-1){
            return false;
        }
        else{
            return true;
        }
    }
    public String getsth(){
        return tt.get(0);
    }
}
