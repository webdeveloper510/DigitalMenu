package com.digitalmenu.app.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.digitalmenu.app.R;
import com.digitalmenu.app.view.CartActivity;

public class RVCartlAdapter extends RecyclerView.Adapter<RVCartlAdapter.RVSubDetailAdapterHolder> {

    CartActivity context;
    int i = 1;
    int pos = 0;
    public RVCartlAdapter(CartActivity context) {
        this.context=context;
    }

    @NonNull
    @Override
    public RVSubDetailAdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.
                rv_cart, parent, false);
        return new RVSubDetailAdapterHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RVSubDetailAdapterHolder holder, int position) {

        if(position==0){
            holder.tv_items.setText("2x");
            holder.tv_name.setText("Mini Yoshi Roll Menu");
            holder.tv_price.setText("28,20 €");
        }else if(position==1){
            holder.tv_items.setText("1x");
            holder.tv_name.setText("Lochs Menu");
            holder.tv_price.setText("22,20 €");
        }else if(position==2){
            holder.tv_items.setText("4x");
            holder.tv_name.setText("Vegetaria Menu");
            holder.tv_price.setText("36,50 €");
        }else {
            holder.tv_items.setText("5x");
            holder.tv_name.setText("Pizza");
            holder.tv_price.setText("78,20 €");
        }
        pos = position;
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    public class RVSubDetailAdapterHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        LinearLayout ll_plus_minus, ll_add;
        ImageView iv_add, iv_minus;
        TextView tv_items, tv_name,tv_price;
        public RVSubDetailAdapterHolder(@NonNull View itemView) {
            super(itemView);
            ll_plus_minus = itemView.findViewById(R.id.ll_plus_minus);
            ll_add = itemView.findViewById(R.id.ll_add);


            iv_add = itemView.findViewById(R.id.iv_add);
            iv_minus = itemView.findViewById(R.id.iv_minus);
            tv_items = itemView.findViewById(R.id.tv_items);
            tv_name=itemView.findViewById(R.id.tv_name);
            tv_price=itemView.findViewById(R.id.tv_price);
         //   ll_add.setOnClickListener(this);
            ll_plus_minus.setOnClickListener(this);

            iv_add.setOnClickListener(this);
            iv_minus.setOnClickListener(this);
            //  tv_items.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
              /*  case R.id.ll_add:
                    i = 1;
                    ll_plus_minus.setVisibility(View.VISIBLE);
                    ll_add.setVisibility(View.GONE);
                    break;*/

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

