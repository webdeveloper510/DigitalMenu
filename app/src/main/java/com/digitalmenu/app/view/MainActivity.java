package com.digitalmenu.app.view;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.digitalmenu.app.R;
import com.digitalmenu.app.adapter.DishsHomeAdapter;
import com.digitalmenu.app.adapter.RVHomeAdapter;
import com.digitalmenu.app.constants.JsonUtil;
import com.digitalmenu.app.model.Article;
import com.digitalmenu.app.model.HomeModel;
import com.digitalmenu.app.view_model.ArticleViewModel;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    RVHomeAdapter rvHomeAdapter;
    RecyclerView rvHomeRecyclerview;
    ArrayList<HomeModel> homeModel;

    private RelativeLayout rv_top, rl_cart;
    private TextView tv_menu;
    int i = 0;
    List<String> image1;
    private int[] images = new int[]{R.mipmap.bgclient1, R.mipmap.bgclient2, R.mipmap.bgclient3};

    private RecyclerView my_recycler_view;
    private ProgressBar progress_circular_movie_article;
    private LinearLayoutManager layoutManager;
    private DishsHomeAdapter adapter;
    private ArrayList<Article> articleArrayList = new ArrayList<>();
    ArticleViewModel articleViewModel;




    List<String> names=new ArrayList<>();
    List<String> name1;
    HomeModel homeModel1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        initUI();
        setCounter();
        homeModel = new ArrayList<>();


        hitAPI();



//        setMVVMdata();

    }

    private void hitAPI() {

        LinearLayoutManager manager = new GridLayoutManager(MainActivity.this, 3);
        rvHomeRecyclerview.setHasFixedSize(false);
        rvHomeRecyclerview.setNestedScrollingEnabled(false);
        rvHomeRecyclerview.setLayoutManager(manager);


        Thread thread = new Thread(new Runnable() {

            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void run() {
                try {
                    homeModel = new ArrayList<>();
                    JsonObject jsonObject = new JsonObject();
                    jsonObject.addProperty("module", "HOME_PAGE");
                    try {
                        JsonArray response = JsonUtil.request(jsonObject);
                        if (response.size()>0){
                            homeModel = getValuesForGivenKey(response.getAsJsonArray().toString(), "name");

                            Log.d("myjsondata", ": "+homeModel.size());
                                  //m taking some tim solve it hope its ok ..





                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        rvHomeAdapter = new RVHomeAdapter(MainActivity.this,homeModel);
                        rvHomeRecyclerview.setAdapter(rvHomeAdapter);
                        // run this
                    }
                });
            }
        });
        thread.start();



    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public ArrayList<HomeModel> getValuesForGivenKey(String jsonArrayStr, String key) throws JSONException {
        ArrayList<HomeModel> homeModelList = new ArrayList<>();
        JSONArray jsonArray = new JSONArray(jsonArrayStr);
         for (int i =0;i<jsonArray.length();i++){
             String image = jsonArray.getJSONObject(i).getString("image");
             String name = jsonArray.getJSONObject(i).getString("name");
             HomeModel homeModel = new HomeModel(image,name);
             homeModelList.add(homeModel);
         }
         return homeModelList;
    }


    private void setMVVMdata() {
        adapter = new DishsHomeAdapter(MainActivity.this, articleArrayList);
        my_recycler_view.setAdapter(adapter);

        // View Model

        articleViewModel = new ViewModelProvider(this).get(ArticleViewModel.class);
    }

    private void setCounter() {
        new CountDownTimer(5000, 5000) {
            @Override
            public void onTick(long millisUntilFinished) {
            }

            @SuppressLint("UseCompatLoadingForDrawables")
            @Override
            public void onFinish() {
                rv_top.setBackgroundResource(images[i]);
                i++;
                if (i == images.length - 1) i = 0;
                start();
            }
        }.start();
    }



    private void initUI() {
        tv_menu = findViewById(R.id.tv_menu);
        rv_top = findViewById(R.id.rv_top);
        rl_cart = findViewById(R.id.rl_cart);
        rvHomeRecyclerview = findViewById(R.id.rvHome);

        rl_cart.setOnClickListener(this);

        Typeface custom_font1 = Typeface.createFromAsset(getAssets(), "SwistblnkNeaments Free.ttf");
        tv_menu.setTypeface(custom_font1);

    }




    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rl_cart:
                Intent i = new Intent(MainActivity.this, CartActivity.class);
                startActivity(i);
                break;
        }
    }

    private void getMovieArticles() {
        articleViewModel.getArticleResponseLiveData().observe(this, articleResponse -> {
            if (articleResponse != null) {
                progress_circular_movie_article.setVisibility(View.GONE);
                List<Article> articles = articleResponse.getArticles();
                articleArrayList.addAll(articles);
                rvHomeAdapter.notifyDataSetChanged();
            }
        });
    }
}