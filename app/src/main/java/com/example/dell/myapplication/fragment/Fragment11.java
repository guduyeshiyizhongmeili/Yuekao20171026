package com.example.dell.myapplication.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dell.myapplication.R;
import com.example.dell.myapplication.ScorImageView;

/**
 * Created by dell on 2017/10/25.
 */
public class Fragment11 extends Fragment {

    private ScorImageView imgs;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=View.inflate(getActivity(),R.layout.item11,null);
      imgs=  v.findViewById(R.id.imgs);
        imgs.setType(ScorImageView.TYPE_ROUND);
        imgs.setRoundBorderRadius(50);
        return  v;
    }
}
