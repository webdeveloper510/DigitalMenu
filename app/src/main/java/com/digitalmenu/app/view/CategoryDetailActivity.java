package com.digitalmenu.app.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.digitalmenu.app.R;
import com.digitalmenu.app.adapter.RVCatDetailAdapter;

public class CategoryDetailActivity extends AppCompatActivity {

    private RVCatDetailAdapter rvCatDetailAdapter;
    private RecyclerView rvCatDetail;
    ImageView ivBackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_detail);

        rvCatDetail=findViewById(R.id.rvCatDetail);
        ivBackButton=findViewById(R.id.ivBackButton);

        LinearLayoutManager manager = new LinearLayoutManager(this);
        rvCatDetailAdapter = new RVCatDetailAdapter(CategoryDetailActivity.this);
        rvCatDetail.setLayoutManager(manager);
        rvCatDetail.setAdapter(rvCatDetailAdapter);

        ivBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}