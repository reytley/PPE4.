package com.example.guest.testppe4;

/**
 * Created by guest on 16/03/17.
 */

public class type_soins {



    int id_categ_soins;
    int id_type_soins;
    String libel;
    String description;


    // id_type_soins reference à id_type_soins de  categ_soins



    //Constructeur

    public type_soins(){}

    public type_soins(int id_categ_soins, int id_type_soins, String libel, String description) {
        this.id_categ_soins = id_categ_soins;
        this.id_type_soins = id_type_soins;
        this.libel = libel;
        this.description = description;
    }



    public int getId_categ_soins() {
        return id_categ_soins;
    }

    public void setId_categ_soins(int id_categ_soins) {
        this.id_categ_soins = id_categ_soins;
    }

    public int getId_type_soins() {
        return id_type_soins;
    }

    public void setId_type_soins(int id_type_soins) {
        this.id_type_soins = id_type_soins;
    }

    public String getLibel() {
        return libel;
    }

    public void setLibel(String libel) {
        this.libel = libel;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }




}
