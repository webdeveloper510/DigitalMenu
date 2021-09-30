package com.digitalmenu.app.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.digitalmenu.app.R;
import com.digitalmenu.app.activities.SubItemsActivity;

public class RVSubItemAdapter extends RecyclerView.Adapter<RVSubItemAdapter.SubItemAdapterHolder> {

    int i = 1;
    int pos = 0;

    public RVSubItemAdapter(SubItemsActivity subItemsActivity) {
    }

    @NonNull
    @Override
    public SubItemAdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.
                rv_sub_item, parent, false);
        return new SubItemAdapterHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SubItemAdapterHolder holder, int position) {
        pos = position;
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class SubItemAdapterHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        LinearLayout ll_plus_minus, ll_add;
        ImageView iv_add, iv_minus;
        TextView tv_items, tv_slected;

        public SubItemAdapterHolder(@NonNull View itemView) {
            super(itemView);
            ll_plus_minus = itemView.findViewById(R.id.ll_plus_minus);
            ll_add = itemView.findViewById(R.id.ll_add);


            iv_add = itemView.findViewById(R.id.iv_add);
            iv_minus = itemView.findViewById(R.id.iv_minus);
            tv_items = itemView.findViewById(R.id.tv_slected);

            ll_add.setOnClickListener(this);
            ll_plus_minus.setOnClickListener(this);

            iv_add.setOnClickListener(this);
            iv_minus.setOnClickListener(this);
          //  tv_items.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.ll_add:
                    i = 1;
                    ll_plus_minus.setVisibility(View.VISIBLE);
                    ll_add.setVisibility(View.GONE);
                    break;

                case R.id.ll_plus_minus:
                 //   ll_plus_minus.setVisibility(View.GONE);
                //    ll_add.setVisibility(View.VISIBLE);
                    break;

                case R.id.iv_add:
                    if (i > 0) {
                        i++;
                        tv_items.setText(String.valueOf(i));
                        notifyDataSetChanged();
                    }
                    break;

                case R.id.iv_minus:
                    if (i > 1) {
                        i--;
                        tv_items.setText(String.valueOf(i));
                        notifyDataSetChanged();
                    }
                    break;


            }
        }
    }
}
