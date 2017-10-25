package com.example.dell.myapplication.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dell.myapplication.CircleImageView;
import com.example.dell.myapplication.R;

/**
 * Created by dell on 2017/10/25.
 */
public class Fragment12 extends Fragment {

    private CircleImageView aa;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=View.inflate(getActivity(),R.layout.item12,null);
aa=v.findViewById(R.id.aa);
       // aa.setScaleType();



        return  v;
    }
}
