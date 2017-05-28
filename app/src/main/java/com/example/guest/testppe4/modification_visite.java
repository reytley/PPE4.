package com.example.guest.testppe4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;
import android.widget.EditText;
import  	android.view.View;
public class modification_visite extends AppCompatActivity {
    visite unv;
    Modele unm ;
    Personne linfimiere;
    Personne lepatient;
    Button buttonCancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modification_visite);


        Bundle b = getIntent().getExtras();
        String param1 = b.getString("param1");

        //creation d'objet
        final Modele unm = new Modele(this.getApplicationContext());
        unv =   unm.trouveVisite(param1);
        linfimiere =  unm.trouvePersonne(unv.getInfirmiere());
        lepatient = unm.trouvePersonne(unv.getPatient());


        TextView c_Infirmiere = (TextView )findViewById(R.id.c_Infirmiere);
        TextView c_patient = (TextView )findViewById(R.id.c_patient);
        TextView c_date_prevue = (TextView )findViewById(R.id.c_date_prevue);
        TextView c_date_reel = (TextView )findViewById(R.id.c_date_reel);
        TextView c_duree = (TextView )findViewById(R.id.c_duree);
        TextView c_commentaire_patient = (TextView )findViewById(R.id.c_commentaire_patient);
        TextView c_commentaire = (TextView )findViewById(R.id.c_commentaire);



        c_Infirmiere.setText(linfimiere.getNom()+" "+linfimiere.getPrenom());
        c_patient.setText(lepatient.getNom()+" "+lepatient.getPrenom());
        c_date_prevue.setText(unv.getDate_prevue().toString());
        c_date_reel.setText(unv.getDate_reelle().toString()+"H");
        c_duree.setText(unv.getDuree());
        c_commentaire_patient.setText(unv.getCompte_rendu_patient());
       c_commentaire.setText(unv.getCompte_rendu_infirmiere());



        Button buttonCancel = (Button) findViewById(R.id.bcanc);
        buttonCancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });

        Button buttonOk = (Button) findViewById(R.id.bok);
        buttonOk.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                unv.setCompte_rendu_infirmiere(((EditText) findViewById(R.id.c_commentaire))
                        .getText().toString());
               unm.saveVisite(unv);

                Intent myIntent3 = new Intent(getApplicationContext(), AfficheListeVisite.class);
                startActivity(myIntent3);
            }
        });

    }



}

