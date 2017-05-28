package com.example.guest.testppe4;

/**
 * Created by guest on 16/03/17.
 */

public class specialisation {

   //propriete
    int id_infirmiere;
    int id_categ_soins;
    int id_type_soins;

    //constructeur
    public specialisation(int id_infirmiere, int id_categ_soins, int id_type_soins) {
        this.id_infirmiere = id_infirmiere;
        this.id_categ_soins = id_categ_soins;
        this.id_type_soins = id_type_soins;
    }


    //getter setter
    public int getId_infirmiere() {
        return id_infirmiere;
    }

    public void setId_infirmiere(int id_infirmiere) {
        this.id_infirmiere = id_infirmiere;
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




}
