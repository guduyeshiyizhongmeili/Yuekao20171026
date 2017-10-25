package com.example.dell.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dell.myapplication.fragment.Fragment11;
import com.example.dell.myapplication.fragment.Fragment12;
import com.example.dell.myapplication.fragment.Fragment13;
import com.example.dell.myapplication.fragment.Fragment14;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 2017/10/25.
 */
public class Fragment1 extends Fragment {

    private TabLayout tab;
    private ViewPager tabvp;
    private List<Fragment> fragments;
    private List<String> list;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=View.inflate(getActivity(),R.layout.item,null);
       tab= v.findViewById(R.id.tab);
       tabvp= v.findViewById(R.id.tabvp);
        fragments=new ArrayList<>();
        fragments.add(new Fragment11());
        fragments.add(new Fragment12());
        fragments.add(new Fragment13());
        fragments.add(new Fragment14());
        list=new ArrayList<>();
        list.add("推荐");
        list.add("视频");
        list.add("音乐");
        list.add("机试");
        tabvp.setAdapter(new NewsAdapter(getActivity().getSupportFragmentManager(),fragments,list));
        tabvp.setCurrentItem(0);
        tab.setupWithViewPager(tabvp);





        return  v;
    }
     class NewsAdapter  extends FragmentPagerAdapter {

             private List<Fragment> list_fragment;                         //fragment列表
             private List<String> list_Title;                              //tab名的列表

             public NewsAdapter(FragmentManager fm) {
                 super(fm);
             }

             public NewsAdapter(FragmentManager fm, List<Fragment> list_fragment, List<String> list_Title) {
                 super(fm);
                 this.list_fragment = list_fragment;
                 this.list_Title = list_Title;
             }

             @Override
             public Fragment getItem(int position) {
                 return list_fragment.get(position);
             }
             @Override
             public int getCount() {
                 return list_fragment.size();
             }
             //此方法用来显示tab上的名字
             @Override
             public CharSequence getPageTitle(int position) {
                 return (CharSequence) list_Title.get(position % list_Title.size());
             }
         }
}
