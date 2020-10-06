package com.example.ticktackpro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int gameState [] = {2, 2, 2, 2, 2, 2, 2, 2, 2} ;
    int winningState [][] = { {0,1,2}, {3,4,5}, {6,7,8}, {0,3,6}, {2,5,8}, {1,4,7}, {0,4,8}, {2,4,6} };
    int player = 0;
    boolean isActive = true;
//    boolean isLocked = false;
    public void dropIn(View view) {


        ImageView counter = (ImageView) view;
        int tapped = Integer.parseInt(counter.getTag().toString());
        if (gameState[tapped] == 2 && isActive) {
        gameState[tapped] = player;

//        Log.i("info", String.valueOf(gameState[0]));
            counter.setTranslationY(-1000);

            if (player == 0) {
                counter.setImageResource(R.drawable.yellow);
                player = 1;
            } else {
                counter.setImageResource(R.drawable.red);
                player = 0;
            }
            counter.animate().translationYBy(1000).rotation(1800).setDuration(600);

            for (int w[] : winningState) {
                if (gameState[w[0]] == gameState[w[1]] && gameState[w[1]] == gameState[w[2]] && gameState[w[0]] != 2) {
                    String m;
                    isActive = false;
                    if (player == 0) {
                        m = "Red";
                    } else {
                        m = "Yellow";
                    }
//                    Toast.makeText(this, "Congratulations " + m + "  has won", Toast.LENGTH_LONG).show();
                    TextView textView = (TextView)findViewById(R.id.textView);
                    textView.setText("Congratulation!! " + m +" has won");
                    textView.setVisibility(view.VISIBLE);
                    Button button =(Button)findViewById(R.id.button);
                    button.setVisibility(view.VISIBLE);
                }

                    if(gameState[1]<=1 && gameState[2]<=1 && gameState[3]<=1 && gameState[4]<=1 && gameState[5]<=1 && gameState[6]<=1 && gameState[7]<=1 && gameState[8]<=1 && gameState[0]<=1 ){
                        TextView textView = (TextView)findViewById(R.id.textView);
                        textView.setText("Opps!! No one has won ");
                        textView.setVisibility(view.VISIBLE);
                        Button button =(Button)findViewById(R.id.button);
                        button.setVisibility(view.VISIBLE);
                    }

            }

        }
    }

    public void playAgain(View view) {
        TextView textView = (TextView)findViewById(R.id.textView);
        textView.setVisibility(view.INVISIBLE);
        Button button =(Button)findViewById(R.id.button);
        button.setVisibility(view.INVISIBLE);


            androidx.gridlayout.widget.GridLayout gridLayout = findViewById(R.id.gridLayout);

            for (int i = 0; i < gridLayout.getChildCount(); i++) {

                ImageView counter = (ImageView) gridLayout.getChildAt(i);

                counter.setImageDrawable(null);

            }



            for (int i = 0; i < gameState.length; i++) {

                gameState[i] = 2;

            }

            player = 0;

            isActive = true;

        }

    }

