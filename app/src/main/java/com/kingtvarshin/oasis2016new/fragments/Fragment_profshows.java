package com.kingtvarshin.oasis2016new.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.kingtvarshin.oasis2016new.Adapter.Developers_cardAdapter;
import com.kingtvarshin.oasis2016new.Adapter.Profshow_cardAdapter;
import com.kingtvarshin.oasis2016new.Profshowdetail;
import com.kingtvarshin.oasis2016new.R;

import java.util.ArrayList;

/**
 * Created by lenovo on 11-10-2016.
 */

public class Fragment_profshows extends Fragment {

    private ArrayList<String> profshowname;
    private ArrayList<String> profshowimgurl;
    private ArrayList<String> profshowlocation;
    private ArrayList<String> profshowtime;
    private ArrayList<String> profshowdesc;
    private ArrayList<String> profshowdate;
    private Context context;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_profshows, container, false);

        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.card_recycler_view_profshow);

        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
//        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(),3);
//        RecyclerView.LayoutManager layoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        profshowname = new ArrayList<>();
        profshowname.add("Amit Trivedi");
        profshowname.add("Bla Bla Bla");

        profshowimgurl = new ArrayList<>();
        profshowimgurl.add("http://i.imgur.com/QYq9lh5.jpg");
        profshowimgurl.add("http://i.imgur.com/QYq9lh5.jpg");

        profshowlocation = new ArrayList<>();
        profshowlocation.add("Audi");
        profshowlocation.add("Gym G");

        profshowtime = new ArrayList<>();
        profshowtime.add("8:00 pm");
        profshowtime.add("9:00 pm");

        profshowdesc = new ArrayList<>();
        profshowdesc.add("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        profshowdesc.add("dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd");

        profshowdate = new ArrayList<>();
        profshowdate.add("14-10-2016");
        profshowdate.add("14-10-2016");

        RecyclerView.Adapter adapter = new Profshow_cardAdapter(getContext(),profshowname,profshowimgurl);
        recyclerView.setAdapter(adapter);

        recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            GestureDetector gestureDetector = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() {

                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

            });

            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {

                View child = rv.findChildViewUnder(e.getX(), e.getY());
                if (child != null && gestureDetector.onTouchEvent(e)) {
                    int position = rv.getChildAdapterPosition(child);
                    profDetails(position);
                    Toast.makeText(getContext(), profshowname.get(position), Toast.LENGTH_SHORT).show();
                }

                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });

        return rootView;
    }

    public void profDetails(int profNum)
    {
        Intent i=new Intent(getActivity(),Profshowdetail.class);
        i.putExtra("profNum",profNum);
        i.putExtra("name",profshowname.get(profNum));
        i.putExtra("location",profshowlocation.get(profNum));
        i.putExtra("Image",profshowimgurl.get(profNum));
        i.putExtra("time",profshowtime.get(profNum));
        i.putExtra("desc",profshowdesc.get(profNum));
        i.putExtra("date",profshowdate.get(profNum));
        startActivity(i);
    }

}