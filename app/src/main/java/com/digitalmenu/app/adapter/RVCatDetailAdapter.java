package com.digitalmenu.app.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.digitalmenu.app.R;
import com.digitalmenu.app.view.CategoryDetailActivity;
import com.digitalmenu.app.view.SubItemsActivity;

public class RVCatDetailAdapter extends RecyclerView.Adapter<RVCatDetailAdapter.RVCatDetailAdapterHolder> {
    CategoryDetailActivity context;
    public RVCatDetailAdapter(CategoryDetailActivity context) {
        this.context=context;
    }

    @NonNull
    @Override
    public RVCatDetailAdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.
                rv_cat_detail, parent, false);
        return new RVCatDetailAdapterHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RVCatDetailAdapterHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class RVCatDetailAdapterHolder extends RecyclerView.ViewHolder {
        public RVCatDetailAdapterHolder(@NonNull View itemView) {
            super(itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(context, SubItemsActivity.class);
                    context.startActivity(i);
                }
            });
        }
    }
}
