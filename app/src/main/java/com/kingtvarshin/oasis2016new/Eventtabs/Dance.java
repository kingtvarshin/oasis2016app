package com.kingtvarshin.oasis2016new.Eventtabs;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.kingtvarshin.oasis2016new.Adapter.Event_cardAdapter;
import com.kingtvarshin.oasis2016new.Adapter.Eventselect_cardAdapter;
import com.kingtvarshin.oasis2016new.R;

import java.util.ArrayList;

/**
 * Created by hp1 on 21-01-2015.
 */
public class Dance extends Fragment {

    private ArrayList<String> eventtitle;
    private ArrayList<String> eventdesc;


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v =inflater.inflate(R.layout.tab_dance,container,false);

        RecyclerView recyclerView = (RecyclerView) v.findViewById(R.id.card_recycler_view_dancetab);

        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
//        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(),3);
//        RecyclerView.LayoutManager layoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        eventtitle = new ArrayList<>();
        eventtitle.add("Choreo*");
        eventtitle.add("Street Dance*");
        eventtitle.add("Tandav");
        eventtitle.add("Desert Duel*");
        eventtitle.add("Razzmatazz*");

        eventdesc = new ArrayList<>();
        eventdesc.add("blablablablablablablablablabla" +
                "blablablablablablablablablablablabla" +
                "bla");
        eventdesc.add("Street Dance*Street Dance*Street Dance*Street Dance*" +
                "Street Dance*Street Dance*Street Dance*Street Dance*" +
                "Street Dance*vStreet Dance*");
        eventdesc.add("TandavTandavTandavTandav" +
                "TandavTandavTandavTandavTandavTandav" +
                "TandavTandavTandavTandav");
        eventdesc.add("Desert Duel*");
        eventdesc.add("Razzmatazz*");

        RecyclerView.Adapter adapter = new Event_cardAdapter(eventtitle, eventdesc);
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
                    Toast.makeText(getContext(), eventtitle.get(position), Toast.LENGTH_SHORT).show();
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

        return v;
    }

}