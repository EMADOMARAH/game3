package com.emad11.Sebha;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.emad11.Sebha.Adapter.quranAdapter;
import com.emad11.Sebha.Model.quranModel;
import com.emad11.Sebha.utils.PreferenceUtil;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class quran extends AppCompatActivity {

    RecyclerView QRV ;
    private List<Object> viewItems = new ArrayList<>();

    private RecyclerView.Adapter quranAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private static final String TAG = "quran";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quran);
        QRV=findViewById(R.id.quranrecycler);
        layoutManager = new LinearLayoutManager(this);
        QRV.setLayoutManager(layoutManager);
        QRV.setHasFixedSize(true);
        QRV.getRecycledViewPool().setMaxRecycledViews(0,0);
        quranAdapter = new quranAdapter(this,viewItems);
        QRV.setAdapter(quranAdapter);
        QRV.scrollToPosition(PreferenceUtil.getInstance(this).getAppPref().getInt("pos",0));
        addItemsFromJSON();
    }

    private void addItemsFromJSON() {
        try {
            String jsonDataString = readJSONDataFromFile();
            JSONArray jsonArray = new JSONArray(jsonDataString);

            for (int i =0 ; i <jsonArray.length(); ++i){
                JSONObject itemObj = jsonArray.getJSONObject(i);
                String content = itemObj.getString("content");
                String sora = itemObj.getString("surah_number");
                String aya = itemObj.getString("verse_number");

                quranModel quranModel = new quranModel(sora,aya,content);
                viewItems.add(quranModel);
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
            inputStream = getResources().openRawResource(R.raw.qk);
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