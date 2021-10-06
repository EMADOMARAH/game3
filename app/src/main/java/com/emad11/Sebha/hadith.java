package com.emad11.Sebha;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.emad11.Sebha.Adapter.hadithAdapter;
import com.emad11.Sebha.Model.hadithModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class hadith extends AppCompatActivity {
    RecyclerView HRV ;
    private List<Object> viewItems = new ArrayList<>();

    private RecyclerView.Adapter hadithAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private static final String TAG = "hadith";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hadith);

        HRV = findViewById(R.id.hadithrecycler);
        HRV.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        HRV.setLayoutManager(layoutManager);

       hadithAdapter = new hadithAdapter(this,viewItems);

        HRV.setAdapter(hadithAdapter);
        
        addItemsFromJSON();
    }

    private void addItemsFromJSON() {
        try {
            String jsonDataString = readJSONDataFromFile();
            JSONArray jsonArray = new JSONArray(jsonDataString);

            for (int i =0 ; i <jsonArray.length(); ++i){
                JSONObject itemObj = jsonArray.getJSONObject(i);
                String text = itemObj.getString("text");
                String daraga = itemObj.getString("darga");
                String source = itemObj.getString("source");

                hadithModel hadithModel = new hadithModel(text,daraga,source);
                viewItems.add(hadithModel);
            }

        }catch (IOException | JSONException e)
        {
            Log.d(TAG,"addItemFromJSON",e);
        }
    }

    private String readJSONDataFromFile() throws IOException{
        InputStream inputStream =null;
        StringBuilder builder=new StringBuilder();

        try {
            String jsonString = null;
            inputStream = getResources().openRawResource(R.raw.fakehadith);
            BufferedReader bufferedReader = new BufferedReader (
                new InputStreamReader(inputStream, "UTF-8"));
                while ((jsonString = bufferedReader.readLine()) != null) {
                    builder.append(jsonString);
                }

        }finally {
            if (inputStream!=null){
                    inputStream.close();
            }
        }
        return new String(builder);
    }
}