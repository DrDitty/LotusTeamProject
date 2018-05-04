package edu.auburn.eng.csse.comp3710.spring2018.teamLotus;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ToggleButton;
import android.os.Bundle;

public class HomeActivity extends AppCompatActivity {
    short x = 0, y = 0;
    boolean muted=false;
    Bundle extras = new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        AudioManager audio = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        int currentVolume = audio.getStreamVolume(AudioManager.STREAM_MUSIC);
        if(currentVolume==0)
            muted = true;
        else muted = false;
        final Button easy = findViewById(R.id.easy_button);
        final boolean finalMuted = muted;
        easy.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent_e = new Intent(HomeActivity.this, MainActivity.class);
                x = 3000;
                y = 10;
                extras.putFloat("speed", x);
                extras.putFloat("difficulty", y);
                extras.putBoolean("sound_off", finalMuted);
                myIntent_e.putExtras(extras);
                HomeActivity.this.startActivity(myIntent_e);
            }
        });
        final Button medium = findViewById(R.id.medium_button);
        medium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent_m = new Intent(HomeActivity.this, MainActivity.class);
                x = 2000;
                y = 20;
                extras.putFloat("speed", x);
                extras.putFloat("difficulty", y);
                myIntent_m.putExtras(extras); //20
                HomeActivity.this.startActivity(myIntent_m);
            }
        });
        final Button expert = findViewById(R.id.expert_button);
        expert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent_exp = new Intent(HomeActivity.this, MainActivity.class);
                x = 1000;
                y = 30;
                extras.putFloat("speed", x);
                extras.putFloat("difficulty", y);
                myIntent_exp.putExtras(extras);
                HomeActivity.this.startActivity(myIntent_exp);
            }
        });

        final ToggleButton mute = findViewById(R.id.sound_toggle);
        mute.setOnClickListener(new View.OnClickListener() {
            
            @Override
            public void onClick(View view) {


            }
        });
    };

    protected void onPause(Bundle savedInstanceState) {
        super.onPause();
    };
};
