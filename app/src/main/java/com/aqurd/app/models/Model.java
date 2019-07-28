package com.aqurd.app.models;

public class Model {
    String nameModel;
    String nameBrand;

    public Model(String nameModel) {
        this.nameModel = nameModel;
        this.nameBrand = null;
    }

    public Model() {
        this.nameModel = null;
        this.nameBrand = null;
    }

    public Model(String nameModel, String nameBrand) {
        this.nameModel = nameModel;
        this.nameBrand = nameBrand;
    }
}
