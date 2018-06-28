package com.example.ender.terracota;

import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {

    private ImageView logoSplash;
    private TextView tvSplash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        logoSplash = findViewById(R.id.logoSplash);
        tvSplash = findViewById(R.id.tvSplash);
        Animation splashFade = AnimationUtils.loadAnimation(this, R.anim.splash_transition);

        logoSplash.startAnimation(splashFade);
        tvSplash.startAnimation(splashFade);

        new Thread(new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(4000);
                iniciarAplicacao();
            }
        }).start();


    }

    private void iniciarAplicacao() {
       startActivity(new Intent(this, MainActivity.class));
       finish();
    }


}
