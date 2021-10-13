package com.digitalmenu.app.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.digitalmenu.app.R;
import com.digitalmenu.app.adapter.RVSubItemAdapter;

public class SubItemsActivity extends AppCompatActivity {

    RVSubItemAdapter rvSubItemAdapter;
    RecyclerView rv_subItem;
    ImageView ivBackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_items);

        rv_subItem=findViewById(R.id.rv_subItem);
        ivBackButton=findViewById(R.id.ivBackButton);

        LinearLayoutManager manager = new LinearLayoutManager(this);
        rvSubItemAdapter = new RVSubItemAdapter(SubItemsActivity.this);
        rv_subItem.setLayoutManager(manager);
        rv_subItem.setAdapter(rvSubItemAdapter);
        rv_subItem.setNestedScrollingEnabled(false);

        ivBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}