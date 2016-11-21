package com.example.nailul.iternak.Adapter;

import java.util.Map;

/**
 * Created by Nailul on 11/18/2016.
 */

public class SapiAda {
    private String IDSapi, BB, TB, LB;

    public SapiAda(){

    }

    public SapiAda(String IDSapi, String BB, String TB, String LB){
        this.IDSapi = IDSapi;
        this.BB = BB;
        this.TB = TB;
        this.LB = LB;
    }

    public String getIDSapi(){
        return IDSapi;
    }

    public void setIDSapi(String nomorSapi){
        this.IDSapi = nomorSapi;
    }

    public String getBB(){
        return BB;
    }

    public void setBB(String berat){
        this.BB = berat;
    }

    public String getTB(){
        return TB;
    }

    public void setTB(String tinggi){
        this.BB = tinggi;
    }

    public String getLB(){
        return LB;
    }

    public void setLB(String lingkar){
        this.BB = lingkar;
    }

    public Map<String, Object> toMap() {
        return null;
    }
}
