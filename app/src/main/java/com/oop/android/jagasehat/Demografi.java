package com.oop.android.jagasehat;

/**
 * Created by Asus on 30/05/2018.
 */

public class Demografi {
    String dataJk;
    String dataUsia;
    String dataEdu;
    String dataJob;
    String dataEmail;

    public Demografi(){

    }

    public Demografi(String dataJk, String dataUsia, String dataEdu, String dataJob, String dataEmail){
        this.dataJk = dataJk;
        this.dataUsia = dataUsia;
        this.dataEdu = dataEdu;
        this.dataJob = dataJob;
        this.dataEmail = dataEmail;
    }

    public String getDataJk() {
        return dataJk;
    }

    public String getDataUsia() {
        return dataUsia;
    }

    public String getDataEdu() {
        return dataEdu;
    }

    public String getDataJob() {
        return dataJob;
    }

    public String getDataEmail() {
        return dataEmail;
    }
}
