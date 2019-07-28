package com.aqurd.app.models;

public class Brand {
    String nameBrand;

    public Brand(){
        this.nameBrand = null;
    }

    public  Brand(String tmpName){
        this.nameBrand = tmpName;
    }

    public String getNameBrand() {
        return nameBrand;
    }

    public void setNameBrand(String nameBrand) {
        this.nameBrand = nameBrand;
    }
}
