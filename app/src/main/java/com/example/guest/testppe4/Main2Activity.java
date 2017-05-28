package com.example.guest.testppe4;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    private ListView listView;
    private String param1;
    Button btn_jour;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        btn_jour=(Button) findViewById(R.id.affichelisteVisiteAuj);
        btn_jour.setOnClickListener(btnclick);

        Bundle b = getIntent().getExtras();
        param1 = b.getString("param1");
        Toast.makeText(getApplicationContext(),param1,Toast.LENGTH_LONG).show();


        Modele M = new Modele(this.getApplicationContext());




        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.


        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    private View.OnClickListener btnclick =  new View.OnClickListener() {
        public void onClick(View v) {
            switch (v.getId()) {


                case R.id.affichelisteVisiteAuj:
                    Toast.makeText(getApplicationContext(),"Bonjour1",Toast.LENGTH_LONG).show();
                    Intent myIntent3 = new Intent(getApplicationContext(), affichelisteVisiteAuj.class);
                    startActivity(myIntent3);

                    break;
            }
        }
    };

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {



            case R.id.menu_listV:

                Intent myIntent3 = new Intent(getApplicationContext(), AfficheListeVisite.class);
                startActivity(myIntent3);
                return true;
            /*
            case R.id.menu_list:

                Intent myIntent = new Intent(getApplicationContext(), AfficheListePatient.class);
                startActivity(myIntent);
                return true;*/

            case R.id.menu_import:

                Intent myIntent2 = new Intent(getApplicationContext(), ActImport.class);
                myIntent2.putExtra("param1", param1);
                startActivity(myIntent2);


                return true;
            case R.id.menu_export:

                Intent myIntent4 = new Intent(getApplicationContext(), ActExport.class);
                myIntent4.putExtra("param1", param1 );
                startActivity(myIntent4);

                return true;


            case R.id.menu_listVP:

                Intent myIntent10 = new Intent(getApplicationContext(), recherhePatient.class);
                myIntent10.putExtra("param1", param1 );
                startActivity(myIntent10);

                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
