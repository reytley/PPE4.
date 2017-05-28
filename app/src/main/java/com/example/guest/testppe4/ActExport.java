package com.example.guest.testppe4;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.guest.testppe4.R;

import java.util.ArrayList;

public class ActExport extends AppCompatActivity {
    Modele unm ;
    private String param1;
    private String sPatient="";
    Button mButton = null;
    ArrayList<visite> listVisite;
    AsyncTask<String,String,Boolean> mThreadCon = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_export);
        unm = new Modele(this.getApplicationContext());
        listVisite = unm.listeVisite();

        unm = new Modele(this.getApplicationContext());
        Button btnexport =(Button) findViewById(R.id.btnExport);
        btnexport.setOnClickListener(Export);



    }



    private View.OnClickListener Export = new View.OnClickListener() {
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.vimport:

                    for (visite vis : listVisite) {

                        String[] mesparams = {"http://149.91.88.62/service/public/modifVisiteId/"};
                        mThreadCon = new Async (ActExport.this).execute(mesparams);
                    }


                    break;

            }
        }
    };
}
