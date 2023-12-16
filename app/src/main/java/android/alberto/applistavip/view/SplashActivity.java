package android.alberto.applistavip.view;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.alberto.applistavip.R;
import android.os.Handler;
import android.os.Looper;

@SuppressLint("CustomSplashScreen")
public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        timeOutSplash();
    }

    private void timeOutSplash() {
        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            Intent mainActivity = new Intent(SplashActivity.this, MainActivity.class); //Intent(whereAmI, whereDoIGo);
            startActivity(mainActivity);
            finish(); //screen does not return
        }, 3000);
    }
}