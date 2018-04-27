package edu.auburn.eng.csse.comp3710.spring2018.teamLotus;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.Random;


public class MainActivity extends AppCompatActivity {

    private RelativeLayout myLayout = null;
    ImageView blue_button;
    ImageView red_button;
    ImageView yellow_button;
    ImageView green_button;
    ImageView red_clicked;
    ImageView yellow_clicked;
    ImageView green_clicked;
    ImageView blue_clicked;
    Random mRandom = new Random();


    private float x;
    private float y;
    final Handler mHandler = new Handler();
    int max;
    int current;
    long difficulty;
    boolean correct = true;

    /*  TODO: maybe make a loop to keep displaying the patterns
        TODO: And it only plays again if the user input is correct
        Todo: otherwise it displays a game over message and sends them back to the main menu
        todo:
     */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myLayout = (RelativeLayout) findViewById(R.id.myLayout);
        blue_button = (ImageView) findViewById(R.id.blue_button);
        red_button = (ImageView) findViewById(R.id.red_button);
        yellow_button = (ImageView) findViewById(R.id.yellow_button);
        green_button = (ImageView) findViewById(R.id.green_button);

        blue_clicked = findViewById(R.id.blue_clicked);
        red_clicked = findViewById(R.id.red_clicked);
        yellow_clicked = findViewById(R.id.yellow_clicked);
        green_clicked = findViewById(R.id.green_clicked);

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
                    int[] array = new int[max];


                    if (correct) {
                        correct = false;

                        if (i <= current) {
                            array[i] = rand;

                            switch (rand) {
                                case 0:
                                    red_clicked.setVisibility(View.VISIBLE);
                                    break;
                                case 1:
                                    yellow_clicked.setVisibility(View.VISIBLE);
                                    break;
                                case 2:
                                    green_clicked.setVisibility(View.VISIBLE);
                                    break;
                                case 3: //blue. change to red when you're done testing
                                    blue_clicked.setVisibility(View.VISIBLE);
                                    break;
                                default:
                                    break;

                            }
                            if (blue_clicked.getVisibility() == View.VISIBLE || green_clicked.getVisibility() == View.VISIBLE || red_clicked.getVisibility() == View.VISIBLE || yellow_clicked.getVisibility() == View.VISIBLE ) {

                                mHandler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        blue_clicked.setVisibility(View.INVISIBLE);
                                        red_clicked.setVisibility(View.INVISIBLE);
                                        yellow_clicked.setVisibility(View.INVISIBLE);
                                        green_clicked.setVisibility(View.INVISIBLE);
                                    }
                                }, difficulty);
                            }

                        }

                        i++;
                    }

                    if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                        x = motionEvent.getX();
                        y = motionEvent.getY();

                        //Toast.makeText(getApplicationContext(), String.valueOf(y), Toast.LENGTH_SHORT).show();

                        //if blue is released
                        if (x > 700 && x < 1240) {
                            if (y > 1145 && y < 1700) {

                                correct = true;
                                current++;

                                blue_clicked.setVisibility(View.VISIBLE);

                                mHandler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        blue_clicked.setVisibility(View.INVISIBLE);


                                    }
                                }, 500);
                            }
                        }
                        //if green is released
                        if (x > 140 && x < 699) {
                            if (y > 1145 && y < 1700) {
                                correct = true;
                                current++;

                                green_clicked.setVisibility(View.VISIBLE);

                                mHandler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        green_clicked.setVisibility(View.INVISIBLE);


                                    }
                                }, 500);

                            }
                        }
                        //red
                        if (x > 140 && x < 699) {
                            if (y > 590 && y < 1144) {
                                correct = true;
                                current++;

                                red_clicked.setVisibility(View.VISIBLE);

                                mHandler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        red_clicked.setVisibility(View.INVISIBLE);


                                    }
                                }, 500);

                            }
                        }
                        //yellow
                        if (x > 700 && x < 1240) {
                            if (y > 590 && y < 1144) {
                                correct = true;
                                current++;

                                yellow_clicked.setVisibility(View.VISIBLE);

                                mHandler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        yellow_clicked.setVisibility(View.INVISIBLE);


                                    }
                                }, 500);

                            }
                        }

                    }



                    return true;
                }
            });



        }




    }
}
