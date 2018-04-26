package edu.auburn.eng.csse.comp3710.spring2018.teamLotus;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.Random;


public class MainActivity extends AppCompatActivity {

    private RelativeLayout myLayout = null;
    ImageView blue_button;
    ImageView blue_clicked;
    Random mRandom = new Random();


    private float x;
    private float y;
    final Handler mHandler = new Handler();
    int max;
    int current;
    long difficulty;
    boolean correct = true;

    /*  TODO: The loop is not waiting for touch from the user. fix that
        TODO:
        Todo:
        todo:
     */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myLayout = (RelativeLayout) findViewById(R.id.myLayout);
        blue_button = (ImageView) findViewById(R.id.blue_button);
        blue_clicked = findViewById(R.id.blue_clicked);

        max = 9;


        difficulty = 3000;
        current = 0;


                for (;current <= max;current++) {


                    myLayout.setOnTouchListener(new View.OnTouchListener() {
                        @Override
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            int rand;
                            rand = mRandom.nextInt(4);

                            int i = 0;
                            int[] array = new int[40];


                            y = motionEvent.getY();

                            if (correct) {
                                correct = false;

                                if (i <= current) {
                                    array[i] = rand;

                                    switch (rand) {
                                        case 0:
                                            Toast.makeText(getApplicationContext(), "red", Toast.LENGTH_SHORT).show();
                                            break;
                                        case 1:
                                            Toast.makeText(getApplicationContext(), "yellow", Toast.LENGTH_SHORT).show();
                                            break;
                                        case 2:
                                            Toast.makeText(getApplicationContext(), "green", Toast.LENGTH_SHORT).show();
                                            break;
                                        case 3: //blue. change to red when you're done testing
                                            blue_clicked.setVisibility(View.VISIBLE);
                                            Toast.makeText(getApplicationContext(), "blue", Toast.LENGTH_SHORT).show();
                                            break;
                                        default:
                                            break;

                                    }
                                    if (blue_clicked.getVisibility() == View.VISIBLE) {

                                        mHandler.postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                blue_clicked.setVisibility(View.INVISIBLE);
                                            }
                                        }, difficulty);
                                    }

                                }

                                i++;
                            }



                            if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                                x = motionEvent.getX();

                                if (x > 778 && x < 1337) {

                                    correct = true;
                                    current++;

                                    Toast.makeText(getApplicationContext(), String.valueOf(x), Toast.LENGTH_SHORT).show();
                                    blue_clicked.setVisibility(View.VISIBLE);

                                    mHandler.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            blue_clicked.setVisibility(View.INVISIBLE);


                                        }
                                    }, 500);

                                }

                            }



                            return true;
                        }
                    });



                }




    }
}
