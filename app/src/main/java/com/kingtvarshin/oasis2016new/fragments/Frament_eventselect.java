package com.kingtvarshin.oasis2016new.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.kingtvarshin.oasis2016new.Adapter.Eventselect_cardAdapter;
import com.kingtvarshin.oasis2016new.R;

import java.util.ArrayList;

/**
 * Created by lenovo on 14-09-2016.
 *
 */
public class Frament_eventselect extends Fragment {

    private ArrayList<String> eventid;
    private ArrayList<String> eventcatogary;
    private ArrayList<String> eventname;
    private ArrayList<String> catogarycolor;
    Button register;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_eventselect, container, false);

//        CardView card = (CardView)rootView.findViewById(R.id.card);

        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.card_recycler_view_eventselector);
        register = (Button)rootView.findViewById(R.id.button3);
        register.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                }
        );

//        card.setCardBackgroundColor(Color.BLUE);

        recyclerView.setHasFixedSize(true);
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(),3);
//        RecyclerView.LayoutManager layoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        catogarycolor = new ArrayList<>();
        catogarycolor.add("#000000");
        catogarycolor.add("#000000");
        catogarycolor.add("#000000");
        catogarycolor.add("#000000");
        catogarycolor.add("#000000");
        catogarycolor.add("#000000");
        catogarycolor.add("#000000");
        catogarycolor.add("#000000");
        catogarycolor.add("#000000");
        catogarycolor.add("#000000");
        catogarycolor.add("#000000");
        catogarycolor.add("#000000");

        eventid = new ArrayList<>();
        eventid.add("Dance");
        eventid.add("");
        eventid.add("");
        eventid.add("");
        eventid.add("");
        eventid.add("");
        eventid.add("Drama");
        eventid.add("");
        eventid.add("");
        eventid.add("");
        eventid.add("");
        eventid.add("");

        eventcatogary = new ArrayList<>();
        eventcatogary.add("Dance");
        eventcatogary.add("");
        eventcatogary.add("");
        eventcatogary.add("");
        eventcatogary.add("");
        eventcatogary.add("");
        eventcatogary.add("Drama");
        eventcatogary.add("");
        eventcatogary.add("");
        eventcatogary.add("");
        eventcatogary.add("");
        eventcatogary.add("");

        eventname = new ArrayList<>();
        eventname.add("Choreo*");
        eventname.add("Street Dance*");
        eventname.add("Tandav");
        eventname.add("Desert Duel*");
        eventname.add("Razzmatazz*");
        eventname.add("");
        eventname.add("FashP*");
        eventname.add("Mime*");
        eventname.add("Stage play*");
        eventname.add("Street Play*");
        eventname.add("Metamorphosis*");
        eventname.add("Apt To Act");

        RecyclerView.Adapter adapter = new Eventselect_cardAdapter(catogarycolor,eventid,eventcatogary, eventname);
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
//                    dialContactPhone(number.get(position));
                    Toast.makeText(getContext(), eventcatogary.get(position), Toast.LENGTH_SHORT).show();
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

}