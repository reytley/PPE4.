package com.example.guest.testppe4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;
import android.content.Intent;


import java.util.ArrayList;


public class AfficheListePatient extends AppCompatActivity {
    private ListView listView;
    public ArrayList<Personne> listePatient;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.affiche_liste_patient);
        Modele M = new Modele(this.getApplicationContext());

        listePatient = M.listePersonne();


        listView = (ListView)findViewById(R.id.lvListe);

        PatientAdapter patientAdapter = new PatientAdapter(this, listePatient);

        listView.setAdapter(patientAdapter);
        //listView.setOnClickListener(btnclick);


        listView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {

                Intent myIntent = new Intent(getApplicationContext(), ModificationPatient.class);
                myIntent.putExtra("param1",listePatient.get(position).getId());
                startActivity(myIntent);


            }
        });


    }






}
