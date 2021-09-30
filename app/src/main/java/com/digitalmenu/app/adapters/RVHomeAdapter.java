package com.digitalmenu.app.adapters;

import android.content.Intent;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.digitalmenu.app.R;
import com.digitalmenu.app.activities.CategoryDetailActivity;
import com.digitalmenu.app.activities.EnterTableNOActivity;
import com.digitalmenu.app.activities.MainActivity;
import com.digitalmenu.app.activities.SplashActivity;

public class RVHomeAdapter extends RecyclerView.Adapter<RVHomeAdapter.RVHomeAdapterHolder> {
    MainActivity context;
    private int[] images = new int[]{R.mipmap.vorspeisen, R.mipmap.salate, R.mipmap.hauptspeisen, R.mipmap.pizza,
            R.mipmap.burger, R.mipmap.hotdog, R.mipmap.pasta, R.mipmap.gerichte, R.mipmap.kinder, R.mipmap.snacks,
            R.mipmap.dessert};
    private String[] title = new String[]{"Vorspeisen", "Salate", "Hauptspeisen", "Pizza & Flammkuchen",
            "Burger", "Hot Dogs, Wraps und Sandwiches", "Pasta und Schupfnudeln", "DDR-Gerichte",
            "Kindergerichte", "Bailagen und Snacks", "Dessert"};

    public RVHomeAdapter(MainActivity mainActivity) {
        this.context = mainActivity;
    }

    @NonNull
    @Override
    public RVHomeAdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.
                rv_home1, parent, false);
        return new RVHomeAdapterHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RVHomeAdapterHolder holder, int position) {
        //  Typeface custom_font1 = Typeface.createFromAsset(context.getAssets(), "bebas.ttf");
        //   holder.tv_title.setTypeface(custom_font1);
        holder.iv_dish.setImageResource(images[position]);
        holder.tv_title.setText(title[position]);
    }

    @Override
    public int getItemCount() {
        return 11;
    }

    public class RVHomeAdapterHolder extends RecyclerView.ViewHolder {
        ImageView iv_dish;
        TextView tv_title;

        public RVHomeAdapterHolder(@NonNull View itemView) {
            super(itemView);
            iv_dish = itemView.findViewById(R.id.iv_dish);
            tv_title = itemView.findViewById(R.id.tv_title);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(context, CategoryDetailActivity.class);
                    context.startActivity(i);
                }
            });
        }
    }
}
