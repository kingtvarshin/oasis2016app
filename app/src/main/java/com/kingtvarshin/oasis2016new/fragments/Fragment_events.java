package com.kingtvarshin.oasis2016new.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.astuetz.PagerSlidingTabStrip;
import com.kingtvarshin.oasis2016new.Adapter.CatogaryTabPagerAdapter;
import com.kingtvarshin.oasis2016new.Adapter.Eventcatogary_cardAdapter;
import com.kingtvarshin.oasis2016new.Adapter.TabPagerAdapter;
import com.kingtvarshin.oasis2016new.Eventcategoryonclick;
import com.kingtvarshin.oasis2016new.Profshowdetail;
import com.kingtvarshin.oasis2016new.R;

import java.util.ArrayList;

/**
 * Created by lenovo on 14-09-2016.
 */
public class Fragment_events extends Fragment {

//    ImageButton revolveImage;

    private ArrayList<String> eventcatogary;
    private ArrayList<String> eventicon;
    private Context context;
    ViewPager Tab;
    CatogaryTabPagerAdapter TabAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_events, container, false);

        TabAdapter = new CatogaryTabPagerAdapter(getChildFragmentManager());
        Tab = (ViewPager)rootView.findViewById(R.id.pager1);
        Tab.setOffscreenPageLimit(9);
        Tab.setAdapter(new CatogaryTabPagerAdapter(getChildFragmentManager()));
        PagerSlidingTabStrip tabs = (PagerSlidingTabStrip)rootView.findViewById(R.id.tabs1);

        tabs.setViewPager(Tab);
        return rootView;
    }

}