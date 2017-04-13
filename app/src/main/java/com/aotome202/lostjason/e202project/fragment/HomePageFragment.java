package com.aotome202.lostjason.e202project.fragment;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aotome202.lostjason.e202project.R;

/**
 * Created by LostJason on 2017/4/10.
 */

public class HomePageFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {



        return inflater.inflate(R.layout.fragment_home, container,false);
    }
}
