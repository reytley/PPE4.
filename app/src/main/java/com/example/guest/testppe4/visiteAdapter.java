package com.example.guest.testppe4;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import  	java.util.Date;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by guest on 07/04/17.
 */

public class visiteAdapter extends BaseAdapter {
    private LayoutInflater layoutInflater; ;
    private List<visite> listVisite;
    private Modele unm;
    public visiteAdapter(Context context, ArrayList<visite> vListVisite) {
        layoutInflater = LayoutInflater.from(context);
        listVisite = vListVisite;
        unm = new Modele(context);
    }



    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return listVisite.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return listVisite.get(position);
    }
    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        visiteAdapter.ViewHolder holder;
        if (convertView == null) {
            holder = new visiteAdapter.ViewHolder();
            convertView = layoutInflater.inflate(R.layout.vue_visite, null);
            holder.textViewIdentifiant = (TextView) convertView
                    .findViewById(R.id.vueIdentifiantVis);
            holder.textViewPatient = (TextView) convertView
                    .findViewById(R.id.vuePatientVis);
            holder.textViewInfirmiere = (TextView) convertView
                    .findViewById(R.id.vueInfirmiereVis);
            holder.textViewDate_prevue = (TextView) convertView
                    .findViewById(R.id.vueDate_prevue);
            holder.textViewDate_reel = (TextView) convertView
                    .findViewById(R.id.vueDate_reelle);
            holder.textViewDuree = (TextView) convertView
                    .findViewById(R.id.vueDuree);
            holder.textViewCompte_rendu_infirmiere = (TextView) convertView
                    .findViewById(R.id.vueCompte_rendu_infirmiere);
            holder.textViewCompte_rendu_patient = (TextView) convertView
                    .findViewById(R.id.vueCompte_rendu_patient);
            convertView.setTag(holder);
        } else {
            holder = (visiteAdapter.ViewHolder) convertView.getTag();
        }
        if (position % 2 == 0) {
            convertView.setBackgroundColor(Color.rgb(238, 233, 233));
        } else {
            convertView.setBackgroundColor(Color.rgb(255, 255, 255));
        }


        Personne linfimiere;
        Personne   lepatient;
        Date une =  listVisite.get(position).getDate_prevue();
      linfimiere =  unm.trouvePersonne(listVisite.get(position).getInfirmiere());
        lepatient = unm.trouvePersonne(listVisite.get(position).getPatient());


        holder.textViewDuree.setText("Duree: "+ listVisite.get(position).getDuree()+"H ");

        holder.textViewIdentifiant.setText(listVisite.get(position).getIdV());

        holder.textViewPatient.setText("Patient: "+lepatient.getNom()+" "+lepatient.getPrenom());

        holder.textViewInfirmiere.setText("Infirmier: "+linfimiere.getNom()+" "+linfimiere.getPrenom());
        holder.textViewDate_prevue.setText(une.toString());
        holder.textViewDate_reel.setText( listVisite.get(position).getDate_reelle().toString());
        holder.textViewCompte_rendu_infirmiere.setText(listVisite.get(position).getCompte_rendu_infirmiere());
        holder.textViewCompte_rendu_patient.setText(listVisite.get(position).getCompte_rendu_patient());

        //

        /*



        String s = listPatient.get(position).getTel_fixe();
        s = String.format("%s.%s.%s.%s.%s", s.substring(0, 2),
                s.substring(2, 4), s.substring(4, 6), s.substring(6, 8),
                s.substring(8, 10));
        holder.textViewTelephone.setText(s);*/

        return convertView;
    }

    private class ViewHolder {

        TextView textViewIdentifiant;
        TextView textViewPatient;
        TextView textViewInfirmiere;
        TextView textViewDate_prevue;
        TextView textViewDate_reel;
        TextView textViewDuree;
        TextView textViewCompte_rendu_infirmiere;
        TextView textViewCompte_rendu_patient;
    }
}