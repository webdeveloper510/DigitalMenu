package com.digitalmenu.app.adapter;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.digitalmenu.app.R;
import com.digitalmenu.app.model.HomeModel;
import com.digitalmenu.app.view.CategoryDetailActivity;
import com.digitalmenu.app.view.MainActivity;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

public class RVHomeAdapter extends RecyclerView.Adapter<RVHomeAdapter.RVHomeAdapterHolder> {
    MainActivity context;
    ArrayList<HomeModel> homeModelList;
//    private int[] images = new int[]{R.mipmap.vorspeisen, R.mipmap.salate, R.mipmap.hauptspeisen, R.mipmap.pizza,
//            R.mipmap.burger, R.mipmap.hotdog, R.mipmap.pasta, R.mipmap.gerichte, R.mipmap.kinder, R.mipmap.snacks,
//            R.mipmap.dessert};
//    private String[] title = new String[]{"Vorspeisen", "Salate", "Hauptspeisen", "Pizza & Flammkuchen",
//            "Burger", "Hot Dogs, Wraps und Sandwiches", "Pasta und Schupfnudeln", "DDR-Gerichte",
//            "Kindergerichte", "Bailagen und Snacks", "Dessert"};


    public RVHomeAdapter(MainActivity context, ArrayList<HomeModel> homeModelList) {
        this.context = context;
        this.homeModelList = homeModelList;
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
          Typeface custom_font1 = Typeface.createFromAsset(context.getAssets(), "bebas.ttf");
//           holder.tv_title.setTypeface(custom_font1);
//        holder.iv_dish.setImageResource(images[position]);

    //   Log.e("llllll",names.get(position));
       // holder.tv_title.setText(names.get(position));
        Log.d("rcbindcalled", ": "+"rcbindcalled"+homeModelList.size());
        Log.d("rcbindcalled", ": "+homeModelList.get(position).getName());

        holder.tv_title.setText(homeModelList.get(position).getName());


        byte[] data = homeModelList.get(position).getImage().getBytes();
        Bitmap bmp = BitmapFactory.decodeByteArray(data, 0, data.length);
        holder.iv_dish.setImageBitmap(bmp);



        Log.e("popo", String.valueOf(bmp));


    }

    @Override
    public int getItemCount() {
        return homeModelList.size();
    }

    public class RVHomeAdapterHolder extends RecyclerView.ViewHolder {
        ImageView iv_dish;
        TextView tv_title;

        public RVHomeAdapterHolder(@NonNull View itemView) {
            super(itemView);
            iv_dish = itemView.findViewById(R.id.iv_dish);
            tv_title = itemView.findViewById(R.id.tv_title);

//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    Intent i = new Intent(context, CategoryDetailActivity.class);
//                    context.startActivity(i);
//                }
//            });
        }
    }
}
