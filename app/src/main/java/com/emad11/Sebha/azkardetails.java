package com.emad11.Sebha;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import com.emad11.Sebha.Adapter.azkarDAdapter;
import com.emad11.Sebha.Model.azkarDModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class azkardetails extends AppCompatActivity {
    RecyclerView DRV;
    List<azkarDModel> arraylist;
    int position;
    String content = "content";
    private List<Object> viewItems = new ArrayList<>();
    private RecyclerView.Adapter azkarDAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private static final String TAG = "azkar";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_azkardetails);

        DRV = findViewById(R.id.azkardetailsrecycler);
        DRV.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        DRV.setLayoutManager(layoutManager);
        azkarDAdapter = new azkarDAdapter(this , viewItems);
        DRV.setAdapter(azkarDAdapter);

        if(getIntent().hasExtra("pos")){
            position = getIntent().getIntExtra("pos", 0);
        }


        getJsonFileFromLocally();

    }

    private String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = azkardetails.this.getAssets().open("azkar.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;

    }

    private void getJsonFileFromLocally() {

        try {
            JSONObject object = new JSONObject(loadJSONFromAsset());
            JSONArray Barray = object.getJSONArray("array");
           // Toast.makeText(this, Ititle, Toast.LENGTH_SHORT).show();


            for (int i =0 ; i <Barray.length(); ++i){

                JSONObject obj = Barray.getJSONObject(i);

             //   String title = obj.getString("title");

                if (position == i){
                    JSONArray Sarray = obj.getJSONArray("content");
                    for (int j = 0 ; j <Sarray.length();++j){
                        JSONObject itemObj = Sarray.getJSONObject(j);
                        String text = itemObj.getString("text");
                        String src = itemObj.getString("source");

                        azkarDModel azkarDModel = new azkarDModel(text,src);
                        viewItems.add(azkarDModel);
                    }
                    //Toast.makeText(this, obj.getString("title"), Toast.LENGTH_SHORT).show();
                }



            }

        } catch (JSONException e){
            e.printStackTrace();
        }
    }





}