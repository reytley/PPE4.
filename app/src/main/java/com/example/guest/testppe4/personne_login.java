package com.example.guest.testppe4;

import java.util.Date;

/**
 * Created by guest on 08/03/17.
 */

public class personne_login  {

    //propriete
    private String id ;
    private  String login;
    private String mp;


    //constructeur
    public  personne_login(){}

    public  personne_login(String id,String Login,String Mp){
      this.id = id;
        this.login = Login;
        this.mp = Mp;

    }


    //fonction

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMp() {
        return mp;
    }

    public void setMp(String mp) {
        this.mp = mp;
    }

    public void recopiePersonne_login(personne_login personne)
    {
        id = personne.id;
        login = personne.login;
        mp = personne.mp;


    }


}
