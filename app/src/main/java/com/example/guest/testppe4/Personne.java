package com.example.guest.testppe4;

import java.util.Date;

/**
 * Created by guest on 06/03/17.
 */

public class Personne {


    private String id;
    private String nom;
    private String prenom;
    private String sexe;
    private Date date_naiss;
    private Date date_deces;
    private String ad1;
    private String ad2;
    private String cp;
    private String ville ;
    private String tel_fixe;
    private String tel_port;
    private String mail;
   //constructeur
    public  Personne(){
    }
    public Personne(String Id,String Nom,String Prenom,String Sexe,
                    String Ad1,String Ad2,String Cp,String Ville ,String Tel_fixe,String Tel_port,String Mail
    ) {
      id = Id;
         nom = Nom;
         prenom = Prenom;
       sexe = Sexe;
         ad1 = Ad1;
        ad2 = Ad2;
        cp = Cp;
        ville = Ville;
         tel_fixe = Tel_fixe;
        tel_port = Tel_port;
        mail = Mail;


    }
    //ad1 ad2 adresse 1 et 2
    public Personne(String Id,String Nom,String Prenom,String Sexe,Date Date_naiss,Date Date_deces,
                String Ad1,String Ad2,String Cp,String Ville ,String Tel_fixe,String Tel_port,String Mail
    ) {
           id = Id;
             nom = Nom;
            prenom = Prenom;
           sexe = Sexe;
            date_naiss = Date_naiss;
            date_deces = Date_deces;
             ad1 = Ad1;
             ad2 = Ad2;
            cp = Cp;
             ville = Ville;
             tel_fixe = Tel_fixe;
            tel_port = Tel_port;
            mail = Mail;


    }


    public void recopiePersonne(Personne personne)
    {
         id = personne.id;
       nom = personne.nom;
       prenom = personne.prenom;
        sexe = personne.sexe;
        date_naiss =  personne.date_naiss;
       date_deces = personne.date_deces;
       ad1 = personne.ad1;
        ad2 = personne.ad2;
        cp = personne.cp;
        ville = personne.ville;
        tel_fixe = personne.tel_fixe;
        tel_port =  personne.tel_port;
         mail = personne.mail;


    }



    //getter setter


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public Date getDate_naiss() {
        return date_naiss;
    }

    public void setDate_naiss(Date date_naiss) {
        this.date_naiss = date_naiss;
    }

    public Date getDate_deces() {
        return date_deces;
    }

    public void setDate_deces(Date date_deces) {
        this.date_deces = date_deces;
    }
    public void setDate_deces(String date_deces) {

    }

    public String getAd1() {
        return ad1;
    }

    public void setAd1(String ad1) {
        this.ad1 = ad1;
    }

    public String getAd2() {
        return ad2;
    }

    public void setAd2(String ad2) {
        this.ad2 = ad2;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getTel_fixe() {
        return tel_fixe;
    }

    public void setTel_fixe(String tel_fixe) {
        this.tel_fixe = tel_fixe;
    }

    public String getTel_port() {
        return tel_port;
    }

    public void setTel_port(String tel_port) {
        this.tel_port = tel_port;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

}
