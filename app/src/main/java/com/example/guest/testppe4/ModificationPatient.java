package com.example.guest.testppe4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

public class ModificationPatient extends AppCompatActivity {


    Personne unp;
    Modele unm ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modification_patient);

        //recupere valeur envoyer depuis AfficheListePatient
        Bundle b = getIntent().getExtras();
        String param1 = b.getString("param1");

        //creation d'objet
        Modele unm = new Modele(this.getApplicationContext());
        unp =   unm.trouvePersonne(param1);

       TextView c_nom = (TextView )findViewById(R.id.c_nom);
        TextView c_prenom = (TextView )findViewById(R.id.c_prenom);
        TextView c_ad = (TextView )findViewById(R.id.c_ad);
        TextView c_cp = (TextView )findViewById(R.id.c_cp);
        TextView c_datenaiss = (TextView )findViewById(R.id.c_datenaiss);
        TextView c_tl = (TextView )findViewById(R.id.c_tl);
        TextView c_ville = (TextView )findViewById(R.id.c_ville);

        c_nom.setText(unp.getNom());
         c_ad.setText(   unp.getAd1());
        c_cp.setText(unp.getCp());
      c_datenaiss.setText( unp.getDate_naiss().toString());
       c_tl.setText(unp.getTel_fixe());
       c_ville.setText(unp.getVille());


    }


}
