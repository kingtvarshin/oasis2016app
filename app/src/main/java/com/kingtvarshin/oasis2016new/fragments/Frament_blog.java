package com.kingtvarshin.oasis2016new.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.kingtvarshin.oasis2016new.Adapter.Blog_cardAdapter;
import com.kingtvarshin.oasis2016new.Adapter.Eventselect_cardAdapter;
import com.kingtvarshin.oasis2016new.R;

import java.util.ArrayList;

/**
 * Created by lenovo on 14-09-2016.
 */
public class Frament_blog extends Fragment {

    private ArrayList<String> blogimage;
    private ArrayList<String> blogtitle;
    private ArrayList<String> blogtext;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_blog, container, false);

        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.card_recycler_view_blog);

        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
//        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(),2);
//        RecyclerView.LayoutManager layoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        blogimage = new ArrayList<>();
        blogimage.add("http://i.imgur.com/QYq9lh5.jpg");
        blogimage.add("http://i.imgur.com/QYq9lh5.jpg");
        blogimage.add("http://i.imgur.com/QYq9lh5.jpg");
        blogimage.add("http://i.imgur.com/QYq9lh5.jpg");
        blogimage.add("http://i.imgur.com/QYq9lh5.jpg");
        blogimage.add("http://i.imgur.com/QYq9lh5.jpg");
        blogimage.add("http://i.imgur.com/QYq9lh5.jpg");
        blogimage.add("http://i.imgur.com/QYq9lh5.jpg");
        blogimage.add("http://i.imgur.com/QYq9lh5.jpg");
        blogimage.add("http://i.imgur.com/QYq9lh5.jpg");
        blogimage.add("http://i.imgur.com/QYq9lh5.jpg");
        blogimage.add("http://i.imgur.com/QYq9lh5.jpg");

        blogtitle = new ArrayList<>();
        blogtitle.add("Dance");
        blogtitle.add("Dance");
        blogtitle.add("Dance");
        blogtitle.add("Dance");
        blogtitle.add("Dance");
        blogtitle.add("Dance");
        blogtitle.add("Drama");
        blogtitle.add("Drama");
        blogtitle.add("Drama");
        blogtitle.add("Drama");
        blogtitle.add("Drama");
        blogtitle.add("Drama");

        blogtext = new ArrayList<>();
        blogtext.add("Choreo*Choreo*Choreo*Choreo*Choreo*Choreo*Choreo*Choreo*Choreo*Choreo*Choreo*Choreo*");
        blogtext.add("Street Dance*Street Dance*" +
                "Street Dance*Street Dance*Street Dance*Street Dance*Street Dance*Street Dance*Street Dance*" +
                "Street Dance*Street Dance*Street Dance*Street Dance*Street Dance*Street Dance*Street Dance*Street Dance*" +
                "Street Dance*Street Dance*Street Dance*Street Dance*Street Dance*Street Dance*Street Dance*Street Dance*" +
                "Street Dance*Street Dance*Street Dance*Street Dance*Street Dance*Street Dance*Street Dance*Street Dance*" +
                "Street Dance*Street Dance*Street Dance*Street Dance*Street Dance*Street Dance*Street Dance*Street Dance*Street Dance*" +
                "Street Dance*Street Dance*Street Dance*Street Dance*" +
                "Street Dance*Street Dance*Street Dance*Street Dance*");
        blogtext.add("Tandav");
        blogtext.add("Desert Duel*");
        blogtext.add("Razzmatazz*");
        blogtext.add("");
        blogtext.add("FashP*");
        blogtext.add("Mime*");
        blogtext.add("Stage play*");
        blogtext.add("Street Play*");
        blogtext.add("Metamorphosis*");
        blogtext.add("Apt To Act");

        RecyclerView.Adapter adapter = new Blog_cardAdapter(blogimage,blogtitle, blogtext);
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
                    Toast.makeText(getContext(), blogtitle.get(position), Toast.LENGTH_SHORT).show();
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