package com.example.guest.testppe4;

import java.util.Date;


/**
 * Created by guest on 06/03/17.
 */

public class Infirmier extends Personne {


    private String id;
    private  String fichier_photo;


    //Constructeur
    public Infirmier(){}
    public  Infirmier(Personne linfirmier,String Fichier_photo){
        this.id = linfirmier.getId();
        this.fichier_photo = Fichier_photo;

    }
    public  Infirmier(String Id,String Fichier_photo,String Nom,String Prenom,String Sexe,Date Date_naiss,Date Date_deces,
                      String Ad1,String Ad2,String Cp,String Ville ,String Tel_fixe,String Tel_port,String Mail){
        super(Id,Nom, Prenom, Sexe, Date_naiss, Date_deces,
                 Ad1, Ad2, Cp, Ville , Tel_fixe, Tel_port, Mail);
        this.id = Id;
        this.fichier_photo = Fichier_photo;

    }


    //GETTER SETTER

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public String getFichier_photo() {
        return fichier_photo;
    }

    public void setFichier_photo(String fichier_photo) {
        this.fichier_photo = fichier_photo;
    }

}
