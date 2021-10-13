package com.digitalmenu.app.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.digitalmenu.app.R;

public class ReceiptActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tv_forgo_order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipt);
        initUI();
    }

    private void initUI() {
        tv_forgo_order=findViewById(R.id.tv_forgo_order);
        tv_forgo_order.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_forgo_order:
                Intent intent=new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
        }
    }
}