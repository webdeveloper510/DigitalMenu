package com.digitalmenu.app.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.digitalmenu.app.R;

public class EnterTableNOActivity extends AppCompatActivity implements View.OnClickListener {
    private Button iv_next;
    private EditText et_enter_table;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_table_noactivity);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        initUI();
    }

    private void initUI() {
        iv_next=findViewById(R.id.iv_next);
        et_enter_table=findViewById(R.id.et_enter_table);

        Typeface custom_font1 = Typeface.createFromAsset(getAssets(), "bebas.ttf");
        Typeface custom_font2 = Typeface.createFromAsset(getAssets(), "bebas.ttf");

        et_enter_table.setTypeface(custom_font1);
        iv_next.setTypeface(custom_font2);
        iv_next.setOnClickListener(this);
       // et_enter_table.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.iv_next:
                if(validation()){
                    Intent i = new Intent(EnterTableNOActivity.this, MainActivity.class);
                    startActivity(i);
                }
                break;
        }
    }

    private boolean validation(){

        if(et_enter_table.getText().toString().isEmpty()){
            et_enter_table.setError("Please enter table number");
          //  Toast.makeText(this, "Please enter table number", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}