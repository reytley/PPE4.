package com.example.guest.testppe4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;

public class affichelisteVisiteAuj extends AppCompatActivity {
    private ListView listView;
    public ArrayList<visite> listeVisite;
    public ArrayList<Personne> listePersonne;
    public   ArrayList<visite> listeVisiteAuj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afficheliste_visite_saisi);

        Modele M = new Modele(this.getApplicationContext());
        listeVisite = M.listeVisite();
        listView = (ListView)findViewById(R.id.lv1Liste);
        listeVisiteAuj = new  ArrayList<visite>();


        Date d = new Date();
        for(visite une:listeVisite){
            if (une.getDate_prevue().getYear() == d.getYear() &&  une.getDate_prevue().getMonth() == d.getMonth()&&  une.getDate_prevue().getDay() == d.getDay()){
                listeVisiteAuj.add(une);

            }

        }

        visiteAdapter visiteAdapter = new visiteAdapter(this, listeVisiteAuj);



        listView.setAdapter(visiteAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {

                Intent myIntent = new Intent(getApplicationContext(), modification_visite.class);
                myIntent.putExtra("param1",listeVisite.get(position).getIdV());
                startActivity(myIntent);


            }
        });
    }
}
