package com.example.guest.testppe4; /**
 * Created by guest on 07/04/17.
 */
import  	java.util.Date;

public class visite {
    //propriété
    private String id;
    private String patient;
    private String infirmiere;
    private Date  date_prevue;
    private Date  date_reelle;
    private String duree;
    private String  compte_rendu_infirmiere;
    private String  compte_rendu_patient;



    //constructeur

    public  visite(){}


    public visite(String id, String patient, String idInfirmiere, Date date_prevue, Date date_reelle, String duree) {
        this.id = id;
        this.patient = patient;
        this.infirmiere = idInfirmiere;
        this.date_prevue = date_prevue;
        this.date_reelle = date_reelle;
        this.duree = duree;

    }

    public visite(String id, String patient, String idInfirmiere, Date date_prevue, Date date_reelle, String duree, String compte_rendu_infirmiere, String compte_rendu_patient) {
        this.id = id;
        this.patient = patient;
        this.infirmiere = idInfirmiere;
        this.date_prevue = date_prevue;
        this.date_reelle = date_reelle;
        this.duree = duree;
        this.compte_rendu_infirmiere = compte_rendu_infirmiere;
        this.compte_rendu_patient = compte_rendu_patient;
    }
    //getter setter

    public String getIdV() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPatient() {
        return patient;
    }

    public void setPatient(String patient) {
        this.patient = patient;
    }

    public String getInfirmiere() {
        return infirmiere;
    }

    public void setInfirmiere(String infirmiere) {
        this.infirmiere = infirmiere;
    }

    public Date getDate_prevue() {
        return date_prevue;
    }

    public void setDate_prevue(Date date_prevue) {
        this.date_prevue = date_prevue;
    }

    public Date getDate_reelle() {
        return date_reelle;
    }

    public void setDate_reelle(Date date_reelle) {
        this.date_reelle = date_reelle;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public String getCompte_rendu_infirmiere() {
        return compte_rendu_infirmiere;
    }

    public void setCompte_rendu_infirmiere(String compte_rendu_infirmiere) {
        this.compte_rendu_infirmiere = compte_rendu_infirmiere;
    }

    public String getCompte_rendu_patient() {
        return compte_rendu_patient;
    }

    public void setCompte_rendu_patient(String compte_rendu_patient) {
        this.compte_rendu_patient = compte_rendu_patient;
    }


    public void recopievisite(visite unvisite)
    {
        id = unvisite.id;
        patient = unvisite.patient;
        infirmiere = unvisite.infirmiere;
        date_prevue = unvisite.date_prevue;
        date_reelle =  unvisite.date_reelle;
        duree = unvisite.duree;
        compte_rendu_infirmiere = unvisite.compte_rendu_infirmiere;
        compte_rendu_patient = unvisite.compte_rendu_patient;



    }


}
