package com.example.guest.testppe4;
import java.util.Date;
/**
 * Created by guest on 16/03/17.
 */

public class token {



    //proprieté
    int id;
    int id_login;
    Date datetime;
    String jeton;


    //constructeur

    public token(int id, int id_login, Date datetime, String jeton) {
        this.id = id;
        this.id_login = id_login;
        this.datetime = datetime;
        this.jeton = jeton;
    }


    //getter setter


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_login() {
        return id_login;
    }

    public void setId_login(int id_login) {
        this.id_login = id_login;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public String getJeton() {
        return jeton;
    }

    public void setJeton(String jeton) {
        this.jeton = jeton;
    }

}
