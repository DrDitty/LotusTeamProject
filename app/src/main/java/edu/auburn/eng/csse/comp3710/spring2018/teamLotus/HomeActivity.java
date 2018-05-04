<<<<<<< HEAD
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
    Bundle extras = new Bundle();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        final AudioManager mAudioManager = (AudioManager) this.getSystemService(Context.AUDIO_SERVICE);

        MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.colors);
        mediaPlayer.start();

        final Button easy = findViewById(R.id.easy_button);
        easy.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent_e = new Intent(HomeActivity.this, MainActivity.class);
                x = 3;
                y = 10;
                extras.putShort("speed", x);
                extras.putShort("difficulty", y);
                myIntent_e.putExtras(extras);
                HomeActivity.this.startActivity(myIntent_e);
            }
        });
        final Button medium = findViewById(R.id.medium_button);
        medium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent_m = new Intent(HomeActivity.this, MainActivity.class);
                x = 2;
                y = 20;
                extras.putShort("speed", x);
                extras.putShort("difficulty", y);
                myIntent_m.putExtras(extras); //20
                HomeActivity.this.startActivity(myIntent_m);
            }
        });
        final Button expert = findViewById(R.id.expert_button);
        expert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent_exp = new Intent(HomeActivity.this, MainActivity.class);
                x = 1;
                y = 30;
                extras.putShort("speed", x);
                extras.putShort("difficulty", y);
                myIntent_exp.putExtras(extras);
                HomeActivity.this.startActivity(myIntent_exp);
            }
        });

        final ToggleButton mute = findViewById(R.id.sound_toggle);
        mute.setOnClickListener(new View.OnClickListener() {
            int x=0;
            @Override
            public void onClick(View view) {
                if (mute.isChecked() == true) {
                    mAudioManager.setStreamVolume(AudioManager.ADJUST_MUTE, 0, 0);
                } else if (mute.isChecked() == false) {
                    mAudioManager.setStreamVolume(AudioManager.ADJUST_UNMUTE, 0, 0);

                }
                ;
            }
        });
    };
};
=======
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
>>>>>>> Aaditya
