package com.emad11.Sebha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView quran ;
    ImageView tasbeh ;
    ImageView azkar ;
    ImageView wrong ;
    ImageView talab ;
    ImageView about ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        quran  = findViewById(R.id.quran);
        tasbeh = findViewById(R.id.tasbeh);
        azkar = findViewById(R.id.azkar);
         wrong = findViewById(R.id.wrong);
         talab = findViewById(R.id.notifi);
         about = findViewById(R.id.about);


        about.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, About.class);
                startActivity(intent);
            }
        });

        talab.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this , talab.class);
                startActivity(intent);
            }
        });

        tasbeh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this , tasbeh.class);
                startActivity(intent);
            }
        });
        wrong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this , hadith.class);
                startActivity(intent);
            }
        });
       quran.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent = new Intent(MainActivity.this, quran.class);
                startActivity(intent);
           }
       });
        azkar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,azkar.class);
                startActivity(intent);
            }
        });

    }
}