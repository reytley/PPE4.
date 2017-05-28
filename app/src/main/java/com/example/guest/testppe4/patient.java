package com.example.guest.testppe4;

import java.util.Date;

/**
 * Created by guest on 08/03/17.
 */

public class patient{


    private String id;
    private String informations_medicales;
    //etrangaire
    private String personne_de_confiance;
    private  String infirmiere_souhait;

    public patient(){}

    public patient(String id ,String Informations_medicales, String Personne_de_confiance, String Infirmiere_souhait){


        this.id = id ;
        this.informations_medicales = Informations_medicales;
        this.infirmiere_souhait = Infirmiere_souhait;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInformations_medicales() {
        return informations_medicales;
    }

    public void setInformations_medicales(String informations_medicales) {
        this.informations_medicales = informations_medicales;
    }

    public String getPersonne_de_confiance() {
        return personne_de_confiance;
    }

    public void setPersonne_de_confiance(String personne_de_confiance) {
        this.personne_de_confiance = personne_de_confiance;
    }

    public String getInfirmiere_souhait() {
        return infirmiere_souhait;
    }

    public void setInfirmiere_souhait(String infirmiere_souhait) {
        this.infirmiere_souhait = infirmiere_souhait;
    }

}
