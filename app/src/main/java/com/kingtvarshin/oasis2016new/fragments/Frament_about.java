package com.kingtvarshin.oasis2016new.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kingtvarshin.oasis2016new.R;

/**
 * Created by lenovo on 14-09-2016.
 */
public class Frament_about extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.fragment_about, container, false);

        return rootView;
    }

}