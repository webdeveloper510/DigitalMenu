package com.digitalmenu.app.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.digitalmenu.app.R;
import com.digitalmenu.app.adapters.RVHomeAdapter;

import java.util.Calendar;
import java.util.Timer;

public class MainActivity extends AppCompatActivity {

    RVHomeAdapter rvHomeAdapter;
    RecyclerView rvHome;
    private RelativeLayout rv_top,rl_cart;
    private TextView tv_menu;
    int i = 0;
    private int[] images = new int[]{R.mipmap.bgclient1, R.mipmap.bgclient2, R.mipmap.bgclient3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //disable deafult buttons
        /*getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // hide nav bar
                        | View.SYSTEM_UI_FLAG_FULLSCREEN // hide status bar
                        | View.SYSTEM_UI_FLAG_IMMERSIVE);*/
        rv_top = findViewById(R.id.rv_top);
        rl_cart=findViewById(R.id.rl_cart);
        rvHome = findViewById(R.id.rvHome);
        LinearLayoutManager manager = new GridLayoutManager(this, 3);
        rvHome.setHasFixedSize(false);
        rvHome.setNestedScrollingEnabled(false);


        rvHomeAdapter = new RVHomeAdapter(MainActivity.this);
        rvHome.setLayoutManager(manager);
        rvHome.setAdapter(rvHomeAdapter);



        rl_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, CartActivity.class);
                startActivity(i);
            }
        });


        new CountDownTimer(5000, 5000) {
            @Override
            public void onTick(long millisUntilFinished) {
            }

            @SuppressLint("UseCompatLoadingForDrawables")
            @Override
            public void onFinish() {
                rv_top.setBackgroundResource(images[i]);
                i++;
                if (i == images.length - 1) i = 0;
                start();
            }
        }.start();

    }


    private void initUI() {
        tv_menu = findViewById(R.id.tv_menu);

        Typeface custom_font1 = Typeface.createFromAsset(getAssets(), "SwistblnkNeaments Free.ttf");
        tv_menu.setTypeface(custom_font1);
    }

   /* protected void onPause() {
        super.onPause();
        Intent intent = new Intent(this,MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT |Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }*/

   /* @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // Do nothing or catch the keys you want to block
        return true;
    };*/

}