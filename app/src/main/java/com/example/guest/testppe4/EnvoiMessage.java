package com.example.guest.testppe4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.view.View;
import  android.widget.TextView;

import java.util.ArrayList;

public class EnvoiMessage extends AppCompatActivity {
    private ListView listView;
    public ArrayList<Personne> listeMembre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.envoi_message);
        Modele M = new Modele(this.getApplicationContext());
        listeMembre = M.listePersonne();

        listView = (ListView)findViewById(R.id.lvListe3);


        PatientAdapter patientAdapters = new PatientAdapter(this,listeMembre);
        listView.setAdapter(patientAdapters);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {

            }
        });

    }
}
