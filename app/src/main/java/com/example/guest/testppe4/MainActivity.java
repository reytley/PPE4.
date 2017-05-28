package com.example.guest.testppe4;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import  android.widget.TextView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View.OnClickListener;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;


import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {


    personne_login pl ;


    personne_login unUtilisateur;
    Modele M;
    String loginSaisi;
    String mpSaisi;
    EditText mp;
    EditText identifiant;
    TextView text_identi;
    TextView text_password;
    Modele unm;
   Button btn_conex;

    ImageButton imBut;
    AsyncTask<String,String,Boolean> mThreadCon = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);





        unm = new Modele(this.getApplicationContext());
        text_identi =(TextView)findViewById(R.id.tv_login);
        text_password =(TextView)findViewById(R.id.tv_password);
        btn_conex=(Button) findViewById(R.id.btn_conex);
        imBut=(ImageButton) findViewById(R.id.imageButton);
        identifiant = (EditText) findViewById(R.id.eT_login);
        mp = (EditText) findViewById(R.id.eT_password);

        imBut.setOnClickListener(btnclick);

        btn_conex.setOnClickListener(btnclick);








    }
/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.


        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }*/






    private OnClickListener btnclick =  new OnClickListener() {
        public void onClick(View v) {
            switch (v.getId()) {


                case R.id.imageButton:
                    Toast.makeText(getApplicationContext(),"Bonjour1",Toast.LENGTH_LONG).show();
                    Intent myIntent1= new Intent(getApplicationContext(), Main2Activity.class);
                    myIntent1.putExtra("param1",1);
                    startActivity(myIntent1);

                break;
                case R.id.btn_conex:

                    mpSaisi = mp.getText().toString();
                    loginSaisi = identifiant.getText().toString();



                 pl = unm.trouvePersonne_login(loginSaisi,mpSaisi);
                    if(pl == null){


                        /*
                         String[] mesparams = {"http://172.16.4.66/ppe4/public/"+loginSaisi+"/"+mpSaisi};
                        //""
                        mThreadCon = new Async (MainActivity.this).execute(mesparams);

                     */
                        String[] mesparams = {"http://149.91.88.62/service/public/connect/"+loginSaisi.toString()+"/"+mpSaisi.toString()};
                        mThreadCon = new Async (MainActivity.this).execute(mesparams);


                    }else  {

                        Toast.makeText(getApplicationContext(),"Bonjour "+",vous êtes bien connecté",Toast.LENGTH_LONG).show();
                        Intent myIntent4 = new Intent(getApplicationContext(), Main2Activity.class);
                        myIntent4.putExtra("param1", pl.getId());
                        startActivity(myIntent4);


                    }
                    break;
            }
        }
    };

/*
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_listV:

                Intent myIntent3 = new Intent(getApplicationContext(), AfficheListeVisite.class);
                startActivity(myIntent3);
                return true;


            case R.id.menu_import:

                Intent myIntent2 = new Intent(getApplicationContext(), ActImport.class);
                startActivity(myIntent2);


                return true;
            case R.id.menu_export:

                Toast.makeText(getApplicationContext(),	"clic sur export",Toast.LENGTH_LONG).show();
                Intent myIntent4= new Intent(getApplicationContext(), Main2Activity.class);
                startActivity(myIntent4);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
    */
public void retourImport(StringBuilder sb)
{
    if(sb.toString().equals("false")){
        Toast.makeText(getApplicationContext(),"erreur identifiant ou mot de passe",Toast.LENGTH_LONG).show();

    }else {
        personne_login lutilisateur;
        JsonElement json = new JsonParser().parse(sb.toString());

        //   JsonArray varray = json.getAsJsonArray();
        Gson gson = new GsonBuilder().setDateFormat("yyyy-mm-dd").create();
        ArrayList<Personne> listePersonne = new ArrayList<Personne>();
        //    for (JsonElement obj : varray) {
        Personne vpersonne = gson.fromJson(json.getAsJsonObject(), Personne.class);
        listePersonne.add(vpersonne);
        //   }
        unm.addPersonne(listePersonne);





        Toast.makeText(getApplicationContext(),json.getAsJsonObject().get("id").toString(),Toast.LENGTH_LONG).show();
        lutilisateur = new personne_login(json.getAsJsonObject().get("id").getAsString() ,loginSaisi,mpSaisi);
        unm.savePersonne_login(lutilisateur);


        mpSaisi = mp.getText().toString();
        loginSaisi = identifiant.getText().toString();



        pl = unm.trouvePersonne_login(loginSaisi,mpSaisi);

        Toast.makeText(getApplicationContext(),"Bonjour "+",vous êtes bien connecté" ,Toast.LENGTH_LONG).show();
        Intent myIntent4 = new Intent(getApplicationContext(), Main2Activity.class);
       // myIntent4.putExtra("param1", ));


        startActivity(myIntent4);


    }



//....
}

}
