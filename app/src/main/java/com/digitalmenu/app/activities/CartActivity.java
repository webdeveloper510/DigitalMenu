package com.digitalmenu.app.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.digitalmenu.app.R;
import com.digitalmenu.app.adapters.RVCartlAdapter;
import com.digitalmenu.app.adapters.RVCatDetailAdapter;

public class CartActivity extends AppCompatActivity {

    private RecyclerView rv_sub_detail;
    private RVCartlAdapter rvCartlAdapter;
    private ImageView ivBackButton;
    private TextView tv_place_order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_detail);
        rv_sub_detail=findViewById(R.id.rvCatDetail);
        ivBackButton=findViewById(R.id.ivBackButton);
        tv_place_order=findViewById(R.id.tv_place_order);

        LinearLayoutManager manager = new LinearLayoutManager(this);
        rvCartlAdapter = new RVCartlAdapter(CartActivity.this);
        rv_sub_detail.setLayoutManager(manager);
        rv_sub_detail.setAdapter(rvCartlAdapter);

        ivBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        tv_place_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(CartActivity.this, ReceiptActivity.class);
                startActivity(intent);
            }
        });

    }
}