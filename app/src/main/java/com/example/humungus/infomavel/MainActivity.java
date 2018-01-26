package com.example.humungus.infomavel;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

//    splashscreen timmer
    private static int SPLASH_TIME_OUT = 3000;

    private TextView mAppNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        adding custom font
        mAppNameTextView = (TextView) findViewById(R.id.appNameTextView);

        Typeface ostrichFont = Typeface.createFromAsset(getAssets(), "fonts/AVENGEANCE.ttf");
        mAppNameTextView.setTypeface(ostrichFont);

//        splashscreen code
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeintent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(homeintent);
                finish();
            }

        },SPLASH_TIME_OUT);
    }
}
