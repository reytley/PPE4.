package com.example.guest.testppe4;

/**
 * Created by guest on 16/03/17.
 */

public class categ_soins {


    private int id;
    private  String libel;
    private String mediumtext;

    public categ_soins(){}

    private  categ_soins(int Id,String Libel,String Mediumtext ){
        this.id = Id;
        this.libel = Libel;
        this.mediumtext = Mediumtext;


    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibel() {
        return libel;
    }

    public void setLibel(String libel) {
        this.libel = libel;
    }

    public String getMediumtext() {
        return mediumtext;
    }

    public void setMediumtext(String mediumtext) {
        this.mediumtext = mediumtext;
    }




}
