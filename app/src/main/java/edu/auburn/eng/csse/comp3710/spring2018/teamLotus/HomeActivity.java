package edu.auburn.eng.csse.comp3710.spring2018.teamLotus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ToggleButton;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        final Button easy = findViewById(R.id.easy_button);
        easy.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent_e = new Intent(HomeActivity.this, MainActivity.class);
                myIntent_e.putExtra("speed", 3);
                HomeActivity.this.startActivity(myIntent_e);
            }
        });
        final Button medium = findViewById(R.id.medium_button);
        medium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent_m = new Intent(HomeActivity.this, MainActivity.class);
                myIntent_m.putExtra("speed", 2);
                HomeActivity.this.startActivity(myIntent_m);
            }
            });
        final Button expert = findViewById(R.id.expert_button);
        expert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent_exp = new Intent(HomeActivity.this, MainActivity.class);
                myIntent_exp.putExtra("speed", 1);
                HomeActivity.this.startActivity(myIntent_exp);
            }
        });

        final ToggleButton mute = findViewById(R.id.sound_toggle);

    }

    protected void onPause(Bundle savedInstanceState) {
        super.onPause();
    }

    protected void onResume(Bundle savedInstanceState) {
        super.onResume();
    }

}
