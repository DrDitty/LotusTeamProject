package edu.auburn.eng.csse.comp3710.spring2018.teamLotus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RelativeLayout myLayout = null;

    float x;
    private float y;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myLayout = (RelativeLayout) findViewById(R.id.myLayout);

        myLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {


                y = motionEvent.getY();

                if (motionEvent.getAction() == MotionEvent.ACTION_UP)
                {
                    x = motionEvent.getX();
                    Toast.makeText(getApplicationContext(), String.valueOf(x) , Toast.LENGTH_SHORT).show();
                }

                return true;
            }
        });
    }
}
