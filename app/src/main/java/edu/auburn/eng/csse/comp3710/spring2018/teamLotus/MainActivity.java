package edu.auburn.eng.csse.comp3710.spring2018.teamLotus;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

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
    Button game_over;
    TextView high_score;
    Random mRandom = new Random();


    private float x;
    private float y;
    final Handler mHandler = new Handler();
    int max;
    int current;
    int difficulty;
    boolean soundOff;
    int highscore = 0;
    boolean correct = true;
    int i = 0;
    int[] array = new int[9];
    boolean same = true;
    int rand;
    Bundle extras = new Bundle();

    /*  TODO: maybe make a loop to keep displaying the patterns
        TODO: And it only plays again if the user input is correct
        Todo: otherwise it displays a game over message and sends them back to the main menu
        todo:
     */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getIntent().getIntExtra("speed", difficulty);

        myLayout = (RelativeLayout) findViewById(R.id.myLayout);
        blue_button = (ImageView) findViewById(R.id.blue_button);
        red_button = (ImageView) findViewById(R.id.red_button);
        yellow_button = (ImageView) findViewById(R.id.yellow_button);
        green_button = (ImageView) findViewById(R.id.green_button);
        game_over = (Button) findViewById(R.id.game_over);
        high_score = (TextView) findViewById(R.id.highscore);



        blue_clicked = findViewById(R.id.blue_clicked);
        red_clicked = findViewById(R.id.red_clicked);
        yellow_clicked = findViewById(R.id.yellow_clicked);
        green_clicked = findViewById(R.id.green_clicked);

        max = 9;


        difficulty = 3000;
        current = 0;



        myLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                high_score.setText("Highscore: " + highscore);

                if (correct == true) {
                    rand = mRandom.nextInt(4);
                    array[current] = rand;
                    same = true;
                    highscore++;

                    if (i != 0) {
                        i--;
                        while (same) {
                            if (rand == array[i]) {
                                rand = mRandom.nextInt(4);
                                array[current] = rand;
                            } else
                                same = false;
                        }
                    }

                    Toast.makeText(getApplicationContext(), Integer.toString(current), Toast.LENGTH_SHORT).show();
                    i = 0;
                    correct = false;

                    for (int index = 0; index <= current; index++) {
                                lightUp(index);
                    }
                    current++;
                }
                if (i == current)
                {
                    correct = true;
                }

                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN ){

                    //Toast.makeText(getApplicationContext(), "Daddy Yas", Toast.LENGTH_SHORT).show();

                    x = motionEvent.getX();
                    y = motionEvent.getY();



                    //if blue is released
                    if (x > 700 && x < 1240) {
                        if (y > 1145 && y < 1700) {
                            if (array[i] == 3) {


                                i++;

                                blue_clicked.setVisibility(View.VISIBLE);

                                mHandler.postDelayed(new Runnable() {
                                    //@Override
                                    public void run() {
                                        blue_clicked.setVisibility(View.INVISIBLE);


                                    }
                                }, 500);
                            }
                            else{
                                gameOver();
                            }
                        }
                    }
                    //if green is released
                    if (x > 140 && x < 699) {
                        if (y > 1145 && y < 1700) {
                            if (array[i] == 2) {

                                i++;

                                green_clicked.setVisibility(View.VISIBLE);

                                mHandler.postDelayed(new Runnable() {
                                    //@Override
                                    public void run() {
                                        green_clicked.setVisibility(View.INVISIBLE);
                                    }
                                }, 500);
                            }
                            else{
                                gameOver();
                            }

                        }
                    }
                    //red
                    if (x > 140 && x < 699) {
                        if (y > 590 && y < 1144) {
                            if (array[i] == 0) {

                                i++;

                                red_clicked.setVisibility(View.VISIBLE);

                                mHandler.postDelayed(new Runnable() {
                                    //@Override
                                    public void run() {
                                        red_clicked.setVisibility(View.INVISIBLE);


                                    }
                                }, 500);
                            }
                            else{
                                gameOver();
                            }
                        }
                    }
                    //yellow
                    if (x > 700 && x < 1240) {
                        if (y > 590 && y < 1144) {
                            if (array[i] == 1) {

                                i++;

                                yellow_clicked.setVisibility(View.VISIBLE);

                                mHandler.postDelayed(new Runnable() {
                                    //@Override
                                    public void run() {
                                        yellow_clicked.setVisibility(View.INVISIBLE);


                                    }
                                }, 500);
                            }
                            else{
                                gameOver();
                            }
                        }
                    }

                }





                if (motionEvent.getAction() == MotionEvent.ACTION_UP && !correct) {
                    x = motionEvent.getX();
                    y = motionEvent.getY();



                    //if blue is released
                    if (x > 700 && x < 1240) {
                        if (y > 1145 && y < 1700) {
                            if (array[i] == 3) {


                                i++;

                                blue_clicked.setVisibility(View.VISIBLE);

                                mHandler.postDelayed(new Runnable() {
                                    //@Override
                                    public void run() {
                                        blue_clicked.setVisibility(View.INVISIBLE);


                                    }
                                }, 500);
                            }
                            else{
                                gameOver();
                            }
                        }
                    }
                    //if green is released
                     if (x > 140 && x < 699) {
                        if (y > 1145 && y < 1700) {
                            if (array[i] == 2) {

                                i++;

                                green_clicked.setVisibility(View.VISIBLE);

                                mHandler.postDelayed(new Runnable() {
                                    //@Override
                                    public void run() {
                                        green_clicked.setVisibility(View.INVISIBLE);
                                    }
                                }, 500);
                            }
                            else{
                                gameOver();
                            }

                        }
                    }
                    //red
                    if (x > 140 && x < 699) {
                        if (y > 590 && y < 1144) {
                            if (array[i] == 0) {

                                i++;

                                red_clicked.setVisibility(View.VISIBLE);

                                mHandler.postDelayed(new Runnable() {
                                    //@Override
                                    public void run() {
                                        red_clicked.setVisibility(View.INVISIBLE);


                                    }
                                }, 500);
                            }
                            else{
                                gameOver();
                            }
                        }
                    }
                    //yellow
                     if (x > 700 && x < 1240) {
                        if (y > 590 && y < 1144) {
                            if (array[i] == 1) {

                                i++;

                                yellow_clicked.setVisibility(View.VISIBLE);

                                mHandler.postDelayed(new Runnable() {
                                    //@Override
                                    public void run() {
                                        yellow_clicked.setVisibility(View.INVISIBLE);


                                    }
                                }, 500);
                            }
                            else{
                                gameOver();
                            }
                        }
                    }

                }
                return true;
            }
        });

    }

    private void gameOver(){

        game_over.setVisibility(View.VISIBLE);

        highscore--;
        high_score.setText("Highscore: " + highscore);

        game_over.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //go back to main menu
                Intent return_home = new Intent(MainActivity.this, HomeActivity.class);
                extras.putBoolean("sound_off", soundOff);
                MainActivity.this.startActivity(return_home);
            }
        });
    }

    private void lightUp(final int index) {
        final Runnable r = new Runnable() {
            @Override
            public void run() {
                switch (array[index]){
                    case 0:
                        red_clicked.setVisibility(View.VISIBLE);
                        //Toast.makeText(getApplicationContext(), "r", Toast.LENGTH_SHORT).show();
                        turnOffLight(0);
                        break;
                    case 1:
                        yellow_clicked.setVisibility(View.VISIBLE);
                        //Toast.makeText(getApplicationContext(), "y", Toast.LENGTH_SHORT).show();
                        turnOffLight(1);
                        break;
                    case 2:
                        green_clicked.setVisibility(View.VISIBLE);
                        //Toast.makeText(getApplicationContext(), "g", Toast.LENGTH_SHORT).show();
                        turnOffLight(2);
                        break;
                    case 3:
                        blue_clicked.setVisibility(View.VISIBLE);
                        //Toast.makeText(getApplicationContext(), "b", Toast.LENGTH_SHORT).show();
                        turnOffLight(3);
                        break;
                }
            }
        };

        mHandler.postDelayed(r, (difficulty*index));

    }

    private void turnOffLight(final int num){

        //if (red_clicked.getVisibility() == View.VISIBLE || yellow_clicked.getVisibility() == View.VISIBLE || green_clicked.getVisibility() == View.VISIBLE || blue_clicked.getVisibility() == View.VISIBLE) {
            final Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    switch (num) {
                        case 0:
                            red_clicked.setVisibility(View.INVISIBLE);
                            Toast.makeText(getApplicationContext(), "off red", Toast.LENGTH_SHORT).show();
                            break;
                        case 1:
                            yellow_clicked.setVisibility(View.INVISIBLE);
                            Toast.makeText(getApplicationContext(), "off yellow", Toast.LENGTH_SHORT).show();
                            break;
                        case 2:
                            green_clicked.setVisibility(View.INVISIBLE);
                            Toast.makeText(getApplicationContext(), "off green", Toast.LENGTH_SHORT).show();
                            break;
                        case 3:
                            blue_clicked.setVisibility(View.INVISIBLE);
                            Toast.makeText(getApplicationContext(), "off blue", Toast.LENGTH_SHORT).show();
                            break;

                    }

                }
            };
            mHandler.postDelayed(runnable, difficulty);

                    //Toast.makeText(getApplicationContext(), Integer.toString(current), Toast.LENGTH_SHORT).show();

       // }
    }
}

