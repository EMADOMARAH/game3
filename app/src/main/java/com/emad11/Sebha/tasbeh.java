package com.emad11.Sebha;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class tasbeh extends AppCompatActivity {

    int counter=0;
    TextView text , zkr1 , zkr2,zkr3 ;
    ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasbeh);

        text =findViewById(R.id.text);
        image = findViewById(R.id.clickimage);
        zkr1 = findViewById(R.id.zkr1);
        zkr2 = findViewById(R.id.zkr2);
        zkr3 = findViewById(R.id.zkr3);

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter =counter +1;

                text.setText(counter +"");
                switch (counter){
                    case 33 :
                        zkr1.setVisibility(View.INVISIBLE);
                        break;
                    case 66 :
                        zkr2.setVisibility(View.INVISIBLE);
                        break;
                    case 99 :
                        zkr3.setVisibility(View.INVISIBLE);
                        break;
                }
            }
        });
    }
}