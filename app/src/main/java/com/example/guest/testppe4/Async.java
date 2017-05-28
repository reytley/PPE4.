package com.example.guest.testppe4;
import android.widget.Toast;
import android.app.Activity;
import android.os.AsyncTask;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Async extends AsyncTask<String, String, Boolean> {
    // Référence à l'activité qui appelle
    private WeakReference<Activity> activityAppelante = null;
    private String classActivityAppelante;
    private StringBuilder stringBuilder = new StringBuilder();

    private final String USER_AGENT = "Mozilla/5.0";
    public Async(Activity pActivity) {
        activityAppelante = new WeakReference<Activity>(pActivity);
        classActivityAppelante = pActivity.getClass().toString();
    }

    @Override
    protected void onPreExecute() {// Au lancement, on envoie un message à l'appelant
        if (activityAppelante.get() != null)
            Toast.makeText(activityAppelante.get(), "Thread démarré",
                    Toast.LENGTH_SHORT).show();
    }


    @Override
    protected void onPostExecute(Boolean result) {
        if (activityAppelante.get() != null) {
            if (result) {
                Toast.makeText(activityAppelante.get(), "Fin ok",
                        Toast.LENGTH_SHORT).show();
//pour exemple on appelle une méthode de l'appelant qui va gérer la fin ok du thread
                if (classActivityAppelante.contains("ActImport")) {
                    ((ActImport) activityAppelante.get()).retourImport(stringBuilder);
                }
                if (classActivityAppelante.contains("MainActivity")) {
                    ((MainActivity) activityAppelante.get()).retourImport(stringBuilder);
                }
            } else
                Toast.makeText(activityAppelante.get(), "Fin ko",
                        Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected Boolean doInBackground (String... params) {// Exécution en arrière plan
        String identifiant = "", password = "", vUrl = "", sListClient = "";
int type=0;

        vUrl = params[0];





        HttpURLConnection urlConnection = null;
        try {
            URL url = new URL(vUrl);


            urlConnection = (HttpURLConnection) url.openConnection();

            urlConnection
                    .setRequestProperty("Content-Type", "application/json");
            urlConnection.setRequestProperty("Accept", "application/json");
            urlConnection.setRequestMethod("GET");



            urlConnection.setConnectTimeout(2000);
            if(type==1) {
                urlConnection.setRequestMethod("PUT");
                urlConnection.setDoOutput(true);

                OutputStreamWriter out = new OutputStreamWriter(
                        urlConnection.getOutputStream());
                if (classActivityAppelante.contains("????")) {
                    JSONObject jsonParam = new JSONObject();
                    jsonParam.put("aaa", "");
                    out.write(jsonParam.toString());
                    out.flush();
                }



            out.close();
            // récupération du serveur
            }
            int HttpResult = urlConnection.getResponseCode();
            if (HttpResult == HttpURLConnection.HTTP_OK) {
                BufferedReader br = new BufferedReader(new InputStreamReader(
                        urlConnection.getInputStream(), "utf-8"));
                String line = null;
                while ((line = br.readLine()) != null) {
                    stringBuilder.append(line);
                }
                br.close();
            } else {
                String[] vstring0 = { "Erreur",
                        urlConnection.getResponseMessage() };
                publishProgress(vstring0);
            }
        } catch (MalformedURLException e) {

            String[] vstring0 = { "Erreur", "Pbs url" };
            publishProgress(vstring0);
            return false;
        } catch (java.net.SocketTimeoutException e) {
            String[] vstring0 = { "Erreur", "temps trop long" };
            publishProgress(vstring0);
            return false;
        } catch (IOException e) {

            String[] vstring0 = { "Erreur", "Pbs IO" };
            publishProgress(vstring0);
            return false;
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally {
            if (urlConnection != null)
                urlConnection.disconnect();
        }
        return true;
    }

    @Override
    protected void onProgressUpdate(String... param) {
        // utilisation de on progress pour afficher des message pendant le
        // doInBackground


       /* if (classActivityAppelante.contains("ActImport")) {
            ((ActImport) activityAppelante.get()).alertmsg(
                    param[0].toString(), param[1].toString());
        }*/


    }


    @Override
    protected void onCancelled() {
        if (activityAppelante.get() != null)
            Toast.makeText(activityAppelante.get(), "Annulation", Toast.LENGTH_SHORT).show();
    }

}