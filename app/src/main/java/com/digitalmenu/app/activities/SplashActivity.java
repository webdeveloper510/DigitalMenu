package com.digitalmenu.app.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;
import android.widget.TextView;

import com.digitalmenu.app.R;

import java.util.Locale;

import utils.Constants;

public class SplashActivity extends AppCompatActivity {

    private TextView tv;
    SharedPreferences sharedPreferences;
    private String userId, language;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        tv = findViewById(R.id.tv);

        Typeface custom_font1 = Typeface.createFromAsset(getAssets(), "bebas.ttf");
        tv.setTypeface(custom_font1);


        sharedPreferences = getSharedPreferences(Constants.pref, MODE_PRIVATE);
        userId = sharedPreferences.getString("userId", "");
        language = sharedPreferences.getString("Language", "English");
       // preSelectedLang();
      //  setLocale(preSelectedLang());
        Log.e("value", "This is" + language);
        int SPLASH_DISPLAY_LENGTH = 2500;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashActivity.this, EnterTableNOActivity.class);
                startActivity(i);
                finish();
            }

        }, SPLASH_DISPLAY_LENGTH);
    }

   /* private String preSelectedLang() {
        if (language.equalsIgnoreCase("English")) {
            return "en";
        } else if (language.equalsIgnoreCase("Chinese")) {
            return "zh";
        } else {
            return "it";
        }
    }*/

   /* @SuppressLint("NewApi")
    public void setLocale(String lang) {
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        android.content.res.Configuration conf = res.getConfiguration();
        conf.setLocale(new Locale(lang.toLowerCase())); // API 17+ only.
        res.updateConfiguration(conf, dm);
    }*/
}
