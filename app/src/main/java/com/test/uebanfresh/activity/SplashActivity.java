package com.test.uebanfresh.activity;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;

import com.test.uebanfresh.R;

/**
 * This Activity is use for Showing splash screen
 *
 */
public class SplashActivity extends AppCompatActivity {
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        fullScreen();
        splashScreenTimer();
    }
    /**
     * Method is used for set splash screen time
     */
    private void splashScreenTimer() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, HomeScreenActivity.class);
                startActivity(intent);
                finish();
            }
        },2000);
    }
    /**
     * Method is used to get full screen
     */
    private void fullScreen() {
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );
    }
}