package com.example.android.Common;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.R;
import com.example.android.User.UserDashboard;
public class SplashScreen extends AppCompatActivity
{
    private static int SPLASH_TIME = 5000;
    //Variables
    ImageView backgroundImage;
    TextView madeBy;
//Animation
    Animation sideAnim, bottomAnim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN); // the status bar to be gone.
        setContentView(R.layout.splash_screen);

        //Hooks
        backgroundImage = findViewById(R.id.background_image);
        madeBy = findViewById(R.id.made_by_line);

        //Animation
        sideAnim = AnimationUtils.loadAnimation(this, R.anim.side_anim);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_anim);
        //set Animation on elements
        backgroundImage.setAnimation(sideAnim);
        madeBy.setAnimation(bottomAnim);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, UserDashboard.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_TIME);
    }
}