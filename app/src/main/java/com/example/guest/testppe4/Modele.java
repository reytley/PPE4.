package com.example.guest.testppe4;

import android.os.Environment;
import android.provider.ContactsContract;
import android.content.Context;
import com.db4o.ObjectContainer;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectSet;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


/**
 * Created by guest on 06/03/17.
 */

public class Modele {
    private String db4oFileName;
    private  ObjectContainer  dataBase;
    private File appDir;
    private Context moncontext;


    public Modele() {
        createDirectory();
        open();
        // si partie import non développée
        chargeDataBase();
        dataBase.close();
    }
    public Modele(Context mycontext) {
        moncontext=mycontext;
        createDirectory();
        open();
        // si partie import non développée
        chargeDataBase();
        dataBase.close();
    }


    public void open() {

        db4oFileName = moncontext.getExternalFilesDir(null).getAbsolutePath() + "/baseDB4o"  + "/BasePersonne.db4o";
        //db4oFileName =  "/data/baseDB4o"  + "/BasePersonne.db4o";
        dataBase = com.db4o.Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),
                db4oFileName);

    }


    public void createDirectory() {
        appDir = new File(moncontext.getExternalFilesDir(null).getAbsolutePath() + "/baseDB4o");
      //  appDir = new File ("/data/baseDB4o");
        // Ligne suivant à enlever si pas génymotion car pas de sdcard sur GM


        if (!appDir.exists() && !appDir.isDirectory()) {
            int i;
            boolean result=appDir.mkdirs();
           i=1;
        }
    }



    public ArrayList<Personne> listePersonne() {
        open();
        ArrayList<Personne> listePersonne = new ArrayList<Personne>();
        ObjectSet<Personne> result = dataBase.queryByExample(Personne.class);
        while (result.hasNext()) {
            listePersonne.add(result.next());
        }
        dataBase.close();
        return listePersonne;
    }
    public ArrayList<visite> listeVisite() {
        open();
        ArrayList<visite> listeVisite = new ArrayList<visite>();
        ObjectSet<visite> result = dataBase.queryByExample(visite.class);
        while (result.hasNext()) {
            listeVisite.add(result.next());
        }
        dataBase.close();
        return listeVisite;
    }



    public Personne trouvePersonne (String id) {
        open();
        Personne vretour = new Personne();
        vretour.setId(id);
        ObjectSet<Personne> result = dataBase.queryByExample(vretour);
        vretour = (Personne) result.next();
        dataBase.close();
        return vretour;
    }



    public Infirmier trouveInfimiere (String id) {
        open();
        Infirmier vretour = new Infirmier();
        vretour.setId(id);
        ObjectSet<Infirmier> result = dataBase.queryByExample(vretour);
        vretour = (Infirmier) result.next();
        dataBase.close();
        return vretour;
    }
    public patient trouvePatient(String id) {
        open();
        patient vretour = new patient();
        vretour.setId(id);
        ObjectSet<patient> result = dataBase.queryByExample(vretour);
        vretour = (patient) result.next();
        dataBase.close();
        return vretour;
    }
    public visite trouveVisite(String id) {
        open();
        visite vretour = new visite();
        vretour.setId(id);
        ObjectSet<visite> result = dataBase.queryByExample(vretour);
        vretour = (visite) result.next();
        dataBase.close();
        return vretour;
    }


    public visite trouveVisiteSaisi(Date d) {
        open();
        visite vretour = new visite();
        vretour.setDate_prevue(d);
        ObjectSet<visite> result = dataBase.queryByExample(vretour);
        vretour = (visite) result.next();
        dataBase.close();
        return vretour;
    }

    public personne_login trouvePersonne_login(String identifiant,String mdp){
        open();
        personne_login vretour = new personne_login();
        vretour.setLogin(identifiant);
        vretour.setMp(mdp);
        ObjectSet<personne_login> result = dataBase.queryByExample(vretour);
        if(result.size() == 0){vretour = null;}else{ vretour = (personne_login) result.next();}
        dataBase.close();
        return vretour;


    }





    public void savePatient(Personne personne) {
        open();
        Personne vretour = new Personne();
        vretour.setId(personne.getId());
        ObjectSet<Personne> result = dataBase.queryByExample(vretour);
        if (result.size() == 0) {
            dataBase.store(personne);
        } else {
            vretour = (Personne) result.next();
            vretour.recopiePersonne(personne);
            dataBase.store(vretour);
        }
        dataBase.close();
    }



    public void savePersonne_login(personne_login personne) {
        open();
        personne_login vretour = new personne_login();
        vretour.setId(personne.getId());
        ObjectSet<personne_login> result = dataBase.queryByExample(vretour);
        if (result.size() == 0) {
            dataBase.store(personne);

        } else {
            vretour = (personne_login) result.next();
            vretour.recopiePersonne_login(personne);
            dataBase.store(vretour);
        }
        dataBase.close();
    }

    public void deleteVisite(){
        open();
       ObjectSet<visite> result = dataBase.queryByExample(visite.class);
       while (result.hasNext()){
           dataBase.delete(result.next());
       }
        dataBase.close();

    }

    public void deletePatient(){
        open();
        ObjectSet<patient> result = dataBase.queryByExample(patient.class);
        while (result.hasNext()){
            dataBase.delete(result.next());
        }
        dataBase.close();

    }

    public void deletePersonne(){
        open();
        ObjectSet<Personne> result = dataBase.queryByExample(Personne.class);
        while (result.hasNext()){
            dataBase.delete(result.next());
        }
        dataBase.close();

    }





    public void addPersonne(ArrayList<Personne> vPersonne) {
        open();
        for (Personne v : vPersonne) {
            dataBase.store(v);
        }
        dataBase.close();
    }

    public void addPatient(ArrayList<patient> vPatient) {
        open();
        for (patient v : vPatient) {
            dataBase.store(v);
        }
        dataBase.close();
    }

    public void addVisite(ArrayList<visite> vvisite) {
        open();
        for (visite v : vvisite) {
            dataBase.store(v);
        }
        dataBase.close();
    }



    public void saveVisite(visite unvisite) {
        open();
        visite vretour = new visite();
        vretour.setId(unvisite.getIdV());
        ObjectSet<visite> result = dataBase.queryByExample(vretour);
        if (result.size() == 0) {
            dataBase.store(unvisite);
        } else {
            vretour = (visite) result.next();
            vretour.recopievisite(unvisite);
            dataBase.store(vretour);
        }
        dataBase.close();
    }

    public void chargeDataBase() {

    }



}

