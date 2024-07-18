package com.example.connect3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    // green = 0, blue = 1;
    int activePlayer = 0;
    public void dropIn(View view){
        //Get the image tapped on
        ImageView counter = (ImageView) view;
        //Pushes the image up the screen by 1000 pixels
        counter.setTranslationY(-1000f);
        if (activePlayer == 0){
            // Set the green circle to the ImageView
            counter.setImageResource(R.drawable.green);
            activePlayer = 1;
        } else{
            // Set the blue circle to the ImageView
            counter.setImageResource(R.drawable.blue);
            activePlayer = 0;

        }

        //Animate the ImageView back down
        counter.animate().translationYBy(1000f).setDuration(200);


    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}