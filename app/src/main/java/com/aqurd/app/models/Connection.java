package com.aqurd.app.models;

import java.util.ArrayList;

public class Connection {
    String nameModel;
    String nameBrand;
    int numberOfCabels = 0;

    ArrayList<String> NakladkaList;
    ArrayList<String> SMETList;

    public Connection() {
        NakladkaList = new ArrayList<String>();
        SMETList = new ArrayList<String>();
    }

    public void addConnection(String nakladka, String smet){
        this.NakladkaList.add(nakladka);
        this.SMETList.add(smet);
        numberOfCabels++;
    }


}
