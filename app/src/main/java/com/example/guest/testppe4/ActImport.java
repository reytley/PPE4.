package com.example.guest.testppe4;

import android.content.Intent;
import android.os.AsyncTask;
import android.content.DialogInterface;
import  android.app.AlertDialog;
import android.os.Build;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import android.widget.Toast;
import android.widget.EditText;
import android.view.WindowManager;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;



public class ActImport extends AppCompatActivity {

    Modele unm ;
    private String param1;

    Button mButton = null;
    private EditText dateFin;
    private EditText datedebut;
    AsyncTask<String,String,Boolean> mThreadCon = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        unm = new Modele(this.getApplicationContext());
        setContentView(R.layout.act_import);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
   if (!Settings.canDrawOverlays(this)) {
            // Show alert dialog to the user saying a separate permission is needed
            // Launch the settings activity if the user prefers
            Intent myIntent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION);
            startActivity(myIntent);
            }
        }


        datedebut = (EditText) findViewById(R.id.saisiDataDebut);
        dateFin = (EditText) findViewById(R.id.saisiDataDebut);

        Bundle b = getIntent().getExtras();
        param1 = b.getString("param1");


        Button vimport=(Button) findViewById(R.id.vimport);
        vimport.setOnClickListener(btnimport);

    }


    private View.OnClickListener btnimport = new View.OnClickListener() {
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.vimport:
                    // String[] mesparams = {"http://149.91.88.62/service/public/visite2/"+datedebut.getText().toString()+"/"+datedebut.getText().toString()+"/"+param1};
                    String[] mesparams = {"http://149.91.88.62/service/public/visite2/2016-06-05/2019-06-06/2"};
                    mThreadCon = new Async (ActImport.this).execute(mesparams);
                    String[] mesparams2 = {"http://149.91.88.62/service/public/lesvisite/4"};
                    mThreadCon = new Async (ActImport.this).execute(mesparams2);
                    String[] mesparams3 = {"http://149.91.88.62/service/public/tapa/1"};
                    mThreadCon = new Async (ActImport.this).execute(mesparams3);
                    break;

            }
        }
    };




    public void alertmsg(String title, String msg) {


        AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
        builder.setMessage(msg)
                .setTitle(title);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User clicked OK button
            }
        });
        AlertDialog dialog = builder.create();
        dialog.getWindow().setType(WindowManager.LayoutParams.
                TYPE_SYSTEM_ALERT);
        dialog.show();
    }

    public void retourImport(StringBuilder sb)
    {
        boolean vaction=false;
        alertmsg("retour import",sb.toString());
        if(sb.toString().equals("false")){
            Toast.makeText(getApplicationContext(),"erreur identifiant ou mot de passe",Toast.LENGTH_LONG).show();

        }else {

            JsonElement json = new JsonParser().parse(sb.toString());
            JsonArray varray = json.getAsJsonArray();

            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                @Override
                public Date deserialize(final JsonElement json, final Type typeOfT, final JsonDeserializationContext context)
                        throws JsonParseException {
                    try {
                        return df.parse(json.getAsString());
                    } catch (ParseException e) {
                        return null;
                    }
                }
            });
            Gson gson = gsonBuilder.create();

            try{ ArrayList<Personne> listepersonne  = new ArrayList<Personne>();
                for (JsonElement obj : varray) {
                    Personne vpersonne = gson.fromJson(obj.getAsJsonObject(), Personne.class);

                    listepersonne.add(vpersonne);
                }
                if(!listepersonne.isEmpty()) {
                    if (listepersonne.get(0).getNom() != null) {
                        unm.deletePersonne();
                        unm.addPersonne(listepersonne);
                        vaction=true;
                    }
                }
                }
            catch (ClassCastException e){
                Toast.makeText(getApplicationContext(),"erreur imp",Toast.LENGTH_LONG).show();
            }


            try{ ArrayList<visite> listevisite  = new ArrayList<visite>();
                for (JsonElement obj : varray) {
                    visite vvisite = gson.fromJson(obj.getAsJsonObject(), visite.class);
                    listevisite.add(vvisite);
                }
                if(!listevisite.isEmpty()) {
                    if (listevisite.get(0).getInfirmiere() != null) {
                        unm.deleteVisite();
                        unm.addVisite(listevisite);
                        vaction=true;
                    }
                    }
                }


            catch (Exception e){
                Toast.makeText(getApplicationContext(),"erreur imp",Toast.LENGTH_LONG).show();
            }



            try{ ArrayList<patient> listepatient = new ArrayList<patient>();
                for (JsonElement obj : varray) {
                    patient vpatient = gson.fromJson(obj.getAsJsonObject(), patient.class);
                    listepatient.add(vpatient);
                }
                if(!listepatient.isEmpty()) {
                    if (listepatient.get(0).getId() != null && !vaction) {
                        unm.deletePatient();
                        unm.addPatient(listepatient);
                    }
                }
            }

            catch (ClassCastException e)
            {
                Toast.makeText(getApplicationContext(),"erreur imp",Toast.LENGTH_LONG).show();
            }






        }



//....
    }
}
