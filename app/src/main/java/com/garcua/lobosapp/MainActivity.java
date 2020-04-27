package com.garcua.lobosapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

public class MainActivity extends Activity {
    private final int duracion = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable(){
            //cambio de actividad
            public void run(){
               Intent intent = new Intent(MainActivity.this, login.class);
                getIntent().setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
                finish();
            };
        }, duracion);

    }
}
