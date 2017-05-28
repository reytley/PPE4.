package com.example.guest.testppe4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class AfficheListeVisite extends AppCompatActivity {
    private ListView listView;
    public ArrayList<visite> listeVisite;
    public ArrayList<Personne> listePersonne;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.affiche_liste_visite);


        Modele M = new Modele(this.getApplicationContext());
        listeVisite = M.listeVisite();
        listView = (ListView)findViewById(R.id.lv1Liste);

        listePersonne= M.listePersonne();
         visiteAdapter visiteAdapter = new visiteAdapter(this, listeVisite);



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
