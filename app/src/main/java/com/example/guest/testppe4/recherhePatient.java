package com.example.guest.testppe4;
import android.widget.ArrayAdapter;
import  android.widget.Spinner;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;


public class recherhePatient extends AppCompatActivity {
    private String array_spinner[];
    Modele unm;
    public ArrayList<Personne> listePersonne;
    public ArrayList<String> listeNom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recherhe_patient);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        unm = new Modele(this.getApplicationContext());
        listePersonne = unm.listePersonne();
        listeNom = new  ArrayList<String>();
        for(Personne un:listePersonne){
            listeNom.add(un.getNom()+" "+un.getPrenom());


        }



        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listeNom);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);

    }




}
