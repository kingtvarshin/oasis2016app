package com.kingtvarshin.oasis2016new.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.kingtvarshin.oasis2016new.Adapter.Eventcatogary_cardAdapter;
import com.kingtvarshin.oasis2016new.Eventtabs.Art;
import com.kingtvarshin.oasis2016new.Eventtabs.Dance;
import com.kingtvarshin.oasis2016new.Eventtabs.Drama;
import com.kingtvarshin.oasis2016new.Eventtabs.Misc;
import com.kingtvarshin.oasis2016new.Eventtabs.Music;
import com.kingtvarshin.oasis2016new.Eventtabs.Online;
import com.kingtvarshin.oasis2016new.Eventtabs.Oratory;
import com.kingtvarshin.oasis2016new.Eventtabs.Quizzing;
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

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_events, container, false);

        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.card_recycler_view_eventcatogary);

        recyclerView.setHasFixedSize(true);
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(),2);
//        RecyclerView.LayoutManager layoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        eventcatogary = new ArrayList<>();
        eventcatogary.add("Dance");
        eventcatogary.add("Drama");
        eventcatogary.add("Music");
        eventcatogary.add("Online");
        eventcatogary.add("Quizzing");
        eventcatogary.add("Misc");
        eventcatogary.add("Oratory");
        eventcatogary.add("Art");

        eventicon = new ArrayList<>();
        eventicon.add("http://i.imgur.com/QYq9lh5.jpg");
        eventicon.add("http://i.imgur.com/QYq9lh5.jpg");
        eventicon.add("http://i.imgur.com/QYq9lh5.jpg");
        eventicon.add("http://i.imgur.com/QYq9lh5.jpg");
        eventicon.add("http://i.imgur.com/QYq9lh5.jpg");
        eventicon.add("http://i.imgur.com/QYq9lh5.jpg");
        eventicon.add("http://i.imgur.com/QYq9lh5.jpg");
        eventicon.add("http://i.imgur.com/QYq9lh5.jpg");

        RecyclerView.Adapter adapter = new Eventcatogary_cardAdapter(getContext(),eventcatogary,eventicon);
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
                    switch(position){
                        case 0:
                        {
                            getActivity().setTitle("Dance");
                            final FragmentTransaction ft = getFragmentManager().beginTransaction();
                            ft.replace(R.id.content_frame, new Dance());
                            ft.commit();
                        }
                        break;
                        case 1:
                        {
                            final FragmentTransaction ft = getFragmentManager().beginTransaction();
                            ft.replace(R.id.content_frame, new Drama());
                            ft.commit();
                        }
                        break;
                        case 2:
                        {
                            final FragmentTransaction ft = getFragmentManager().beginTransaction();
                            ft.replace(R.id.content_frame, new Music());
                            ft.commit();
                        }
                        break;
                        case 3:
                        {
                            final FragmentTransaction ft = getFragmentManager().beginTransaction();
                            ft.replace(R.id.content_frame, new Online());
                            ft.commit();
                        }
                        break;
                        case 4:
                        {
                            final FragmentTransaction ft = getFragmentManager().beginTransaction();
                            ft.replace(R.id.content_frame, new Quizzing());
                            ft.commit();
                        }
                        break;
                        case 5:
                        {
                            final FragmentTransaction ft = getFragmentManager().beginTransaction();
                            ft.replace(R.id.content_frame, new Misc());
                            ft.commit();
                        }
                        break;
                        case 6:
                        {
                            final FragmentTransaction ft = getFragmentManager().beginTransaction();
                            ft.replace(R.id.content_frame, new Oratory());
                            ft.commit();
                        }
                        break;
                        case 7:
                        {
                            final FragmentTransaction ft = getFragmentManager().beginTransaction();
                            ft.replace(R.id.content_frame, new Art());
                            ft.commit();
                        }
                        break;
                    }
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



//        revolveImage = (ImageButton) rootView.findViewById(R.id.imageButton3);
//        Animation startRotateAnimation1 = AnimationUtils.loadAnimation(getContext(), R.anim.revolution);
//        revolveImage.startAnimation(startRotateAnimation1);

        return rootView;
    }

}