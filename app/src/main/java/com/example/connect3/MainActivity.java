package com.example.connect3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.material.animation.AnimationUtils;

public class MainActivity extends AppCompatActivity {

    // green = 0, blue = 1;
    int activePlayer = 0;
    // Memory for the slots: 2 means there's nothing initially on that slot
    // 9 two's for nine slots(3*3)
    int[] gameState = {2,2,2,2,2,2,2,2,2};
    // There are 8 different ways of wining this game(3 rows, 3 columns, and 2 diagonals). Let's define them:
    int [][] winningPositions = {{0,1,2}, {3,4,5}, {6,7,8}, {0,3,6}, {1,4,7}, {2,5,8}, {0,4,8}, {2,4,6}};
    public void dropIn(View view){
        //Get the image tapped on
        ImageView counter = (ImageView) view;
        //Pushes the image up the screen by 1000 pixels

        //Displaying the selected tag to the console
        System.out.println(counter.getTag().toString());
        int tappedTag = Integer.parseInt(counter.getTag().toString());

        if (gameState[tappedTag] == 2){
            gameState[tappedTag] = activePlayer;
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
        //Loop through the winningPositions
            for (int[] winningPosition : winningPositions){
                if(gameState[winningPosition[0]] == gameState[winningPosition[1]] &&
                        gameState[winningPosition[1]] == gameState[winningPosition[2]]
                && gameState[winningPosition[0]]!=2){
                    //Display in the console the winner just to check that our logic's working

                    System.out.println(gameState[winningPosition[0]]);
                    //Display the playAgainLayout when someone has won
                    LinearLayout layout = (LinearLayout)findViewById(R.id.playAgainLayout);
                    if (layout != null) {
                        layout.setVisibility(View.VISIBLE);
                        layout.setScaleX(0.7f);
                        layout.setScaleY(0.7f);
                        layout.setAlpha(0f);
                        layout.animate()
                                .scaleX(1f)
                                .scaleY(1f)
                                .alpha(1f)
                                .setDuration(500)
                                .setStartDelay(0)
                                .start();
                    }
                }


            }


    }}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}