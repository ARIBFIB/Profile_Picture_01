package com.example.mysticstreetdicegame2;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;

public class ImagesliderPLayofflinemode extends AppCompatActivity {

    private ViewPager2 viewPager2;
    private List<image> imageList;
    private ImageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imageslider_playofflinemode);

        viewPager2 = findViewById(R.id.viewPager2);
        imageList = new ArrayList<>();

        imageList.add(new image(R.drawable.background2));
        imageList.add(new image(R.drawable.friend));
        imageList.add(new image(R.drawable.dice1));
        imageList.add(new image(R.drawable.friend));
        imageList.add(new image(R.drawable.friend));
        imageList.add(new image(R.drawable.friend));
        imageList.add(new image(R.drawable.friend));

        adapter = new ImageAdapter(imageList , viewPager2);
        viewPager2.setAdapter(adapter);

        viewPager2.setOffscreenPageLimit(3);
        viewPager2.setClipChildren(false);
        viewPager2.setClipToPadding(false);

        viewPager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_ALWAYS);

        CompositePageTransformer transformer = new CompositePageTransformer();
        transformer.addTransformer(new MarginPageTransformer(40));
        transformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r=1 - Math.abs(position);
                page.setScaleY(0.85f + r * 0.14f);
            }
        });
        viewPager2.setPageTransformer(transformer);
    }
}