package com.renoside.testproject;

import android.content.Context;
import android.os.Bundle;

import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.renoside.banner.Banner;
import com.renoside.banner.ImageLoader;
import com.renoside.banner.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public List<Integer> images;
    public List<String> titles;
    public Banner banner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        banner = findViewById(R.id.test_banner);
        images = new ArrayList<>();
        titles = new ArrayList<>();
        images.add(R.drawable.banner_1);
        images.add(R.drawable.banner_2);
        images.add(R.drawable.banner_3);
        images.add(R.drawable.banner_4);
        images.add(R.drawable.banner_5);
        for (int i = 0; i < 5; i++) {
            titles.add("这是第" + (i + 1) + "个页面");
        }
        banner.setImageLoader(new ImageLoader() {
            @Override
            public void conImageLoader(Context context, Object path, ImageView imageView) {
                Glide.with(context).load(path).into(imageView);
            }
        });
        banner.setPointSize(20);
        banner.setRelay(2000);
        banner.setTitleColor(0xFFFFFFFF);
        banner.setImages(images);
        banner.setTitles(titles);
        banner.start();

        banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void onClick(int position) {
                Toast.makeText(MainActivity.this, String.valueOf(position), Toast.LENGTH_SHORT).show();
            }
        });
    }

}
