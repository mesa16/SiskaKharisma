package com.example.asus.siskakharisma;

import android.util.Log;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

/**
 * Created by ASUS on 2/23/2018.
 */

public class MahasiswaData {
    private static String jsondata = " ";

    public  void setJsonData(String json){
        jsondata = json;
        Log.i("data", jsondata);
    }

    public static ArrayList<Mahasiswa> getListMahasiswa(){
        String response = null;
        Mahasiswa mahasiswa = null;

        FetchMahasiswaData conn = (FetchMahasiswaData) new FetchMahasiswaData();
        conn.execute();
        try {
            jsondata = conn.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }catch (ExecutionException e){
            e.printStackTrace();
        }

        ArrayList<Mahasiswa> list = new ArrayList<>();

        try {
            String result = new String( jsondata );
            JSONObject responseObject = new JSONObject( result );

            Integer jumlah = responseObject.getInt("jumlah");
            JSONArray listmhs = responseObject.getJSONArray( "list_mahasiswa" );

            Gson gson = new Gson();
            int i = 0;
            while (i < listmhs.length()){
                list.add(gson.fromJson(listmhs.getJSONObject(i).toString(), Mahasiswa.class)); i++;
            }

            //            Log.d("JSONDATA >>>>>>", jsondata);
//            JSONArray jsonArray = new JSONArray(jsondata);
//            Gson gson = new Gson();
//            int i = 0;
//            while (i < jsonArray.length()){
//                list.add(gson.fromJson(jsonArray.getJSONObject(i).toString(), Mahasiswa.class)); i++;
//            }
        }catch (JSONException e){
            e.printStackTrace();
        }
        return list;
    }
}
