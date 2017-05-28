package com.example.guest.testppe4;

/**
 * Created by guest on 06/05/17.
 */

public class voiture {

    private String modele;
    private int taille;
    private int puissance;
    private String composant;
    private int poid;

    public voiture(String Vmodele, int taille, int puissance, String composant, int poid) {
        this.modele = Vmodele;
        this.taille = taille;
        this.puissance = puissance;
        this.composant = composant;
        this.poid = poid;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public int getTaille() {
        return taille;
    }

    public void setTaille(int taille) {
        this.taille = taille;
    }

    public int getPuissance() {
        return puissance;
    }

    public void setPuissance(int puissance) {
        this.puissance = puissance;
    }

    public String getComposant() {
        return composant;
    }

    public void setComposant(String composant) {
        this.composant = composant;
    }

    public int getPoid() {
        return poid;
    }

    public void setPoid(int poid) {
        this.poid = poid;
    }


}



