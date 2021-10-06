package com.emad11.Sebha;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.emad11.Sebha.Adapter.azkarAdapter;
import com.emad11.Sebha.Model.azkarModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class azkar extends AppCompatActivity {

    RecyclerView ARV ;
    private List<Object> viewItems = new ArrayList<>();

    private RecyclerView.Adapter azkarAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private static final String TAG = "azkar";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_azkar);

        ARV=findViewById(R.id.azkarrecycler);
        ARV.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        ARV.setLayoutManager(layoutManager);
        azkarAdapter = new azkarAdapter(this,viewItems);
        ARV.setAdapter(azkarAdapter);

        addItemsFromJSON();
    }

    private void addItemsFromJSON() {

        try {
            String jsonDataString = readJSONDataFromFile();
            JSONArray jsonArray = new JSONArray(jsonDataString);

            for (int i =0 ; i <jsonArray.length(); ++i){
                JSONObject itemObj = jsonArray.getJSONObject(i);
                String title = itemObj.getString("title");
                String count = itemObj.getString("count");
                azkarModel azkarModel = new azkarModel(title,count);
                viewItems.add(azkarModel);
            }

        }catch (JSONException | IOException e)
        {
            Log.d(TAG,"addItemFromJSON",e);
        }
    }

    private String readJSONDataFromFile() throws IOException{
        InputStream inputStream =null;
        StringBuilder builder=new StringBuilder();

        try {
            String jsonString = null;
            inputStream = getResources().openRawResource(R.raw.azkar);
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