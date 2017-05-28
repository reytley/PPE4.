package com.example.guest.testppe4;
import java.util.Date;
/**
 * Created by guest on 16/03/17.
 */

public class indisponibilite {



    //proprietés
    int infirmiere;



    Date date_debut;
    Date date_fin;
    String categorie;

    //  infirmiere en reference à infirmiere de la table  infirmere
    // cles primaire concatenation de infirmere et date_debut


    //constructeur
    public  indisponibilite(){}

    public indisponibilite(int infirmiere, Date date_debut, Date date_fin, String categorie) {
        this.infirmiere = infirmiere;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.categorie = categorie;
    }

    //Constructeur

    public int getInfirmiere() {
        return infirmiere;
    }

    public void setInfirmiere(int infirmiere) {
        this.infirmiere = infirmiere;
    }

    public Date getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

    public Date getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }



}
