package com.example.dell.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView tv1;
    private TextView tv2;
    private TextView tv3;
    private TextView tv4;
    private ViewPager vp;
    private List<Fragment> fragments;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        tv1.setOnClickListener(this);
        tv2.setOnClickListener(this);
        tv3.setOnClickListener(this);
        addlist();
        vp.setAdapter(new Myadapter(getSupportFragmentManager()));
        vp.setCurrentItem(0);
    }
    private void addlist() {
        fragments=new ArrayList<>();
        fragments.add(new Fragment1());
        fragments.add(new Fragment2());
        fragments.add(new Fragment3());
    }
    private void initView() {
        tv1= (TextView) findViewById(R.id.tv1);
        tv2= (TextView) findViewById(R.id.tv2);
        tv3= (TextView) findViewById(R.id.tv3);
        vp= (ViewPager) findViewById(R.id.vp);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv1:tv1.setBackgroundColor(Color.RED);
                 tv2.setBackgroundColor(Color.BLUE);
                tv3.setBackgroundColor(Color.BLUE);
                vp.setCurrentItem(0);
                break;
            case R.id.tv2:tv1.setBackgroundColor(Color.BLUE);
                tv2.setBackgroundColor(Color.RED);
                tv3.setBackgroundColor(Color.BLUE);
                vp.setCurrentItem(1);
                break;
            case R.id.tv3:tv1.setBackgroundColor(Color.BLUE);
                tv2.setBackgroundColor(Color.BLUE);
                tv3.setBackgroundColor(Color.RED);
                vp.setCurrentItem(2);
                break;

        }
    }

    class Myadapter extends FragmentPagerAdapter{

        public Myadapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }
    }
}
