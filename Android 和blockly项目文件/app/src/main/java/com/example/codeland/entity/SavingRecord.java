package com.example.codeland.entity;

import org.litepal.LitePal;
import org.litepal.crud.LitePalSupport;

public class SavingRecord extends LitePalSupport {
    //public class SavingRecord {
    private String savingName;
    private String savingDate;
    private String savingWorkspace;

    public void setSavingWorkspace(String savingWorkspace) {
        this.savingWorkspace = savingWorkspace;
    }

    public String getSavingWorkspace() {

        return savingWorkspace;
    }

    public String getSavingDate() {
        return savingDate;
    }

    public void setSavingDate(String savingDate) {
        this.savingDate = savingDate;
    }

    public void setSavingName(String savingName) {
        this.savingName = savingName;
    }

    public String getSavingName() {
        return savingName;
    }

    public SavingRecord() {
    }

    public SavingRecord(String savingName, String savingDate) {
        this.savingName = savingName;
        this.savingDate = savingDate;

        this.savingWorkspace="";
    }
}
