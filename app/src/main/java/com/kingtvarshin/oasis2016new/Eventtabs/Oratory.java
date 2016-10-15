package com.kingtvarshin.oasis2016new.Eventtabs;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.kingtvarshin.oasis2016new.Adapter.Event_cardAdapter;
import com.kingtvarshin.oasis2016new.R;

import java.util.ArrayList;

/**
 * Created by hp1 on 21-01-2015.
 */
public class Oratory extends Fragment {

    public ArrayList<String> eventtitle;
    private ArrayList<String> eventdesc;
    private Context context;
    Firebase mRef, mRef2;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        Firebase.setAndroidContext(getActivity());

        View v =inflater.inflate(R.layout.tab_oratory,container,false);

        RecyclerView recyclerView = (RecyclerView) v.findViewById(R.id.card_recycler_view_oratorytab);

        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
//        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(),3);
//        RecyclerView.LayoutManager layoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        mRef = new Firebase("https://oasis-81d10.firebaseio.com/event/oratory");

        mRef2 = new Firebase("https://oasis-81d10.firebaseio.com/event/Description/oratory");

        eventtitle = new ArrayList<>();

//        mRef.addChildEventListener(new ChildEventListener() {
//            @Override
//            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
//                String value = dataSnapshot.getValue(String.class);
//                eventtitle.add(value);
//                eventtitle.add("Choreo*");
////                Log.v("array list", eventtitle.toString());
//            }
//
//            @Override
//            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
//
//            }
//
//            @Override
//            public void onChildRemoved(DataSnapshot dataSnapshot) {
//
//            }
//
//            @Override
//            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
//
//            }
//
//            @Override
//            public void onCancelled(FirebaseError firebaseError) {
//
//            }
//        });

//        eventtitle.add("Choreo*");
//        eventtitle.add("Street Dance*");
//        eventtitle.add("Tandav");
//        eventtitle.add("Desert Duel*");
//        eventtitle.add("Razzmatazz*");

        eventdesc = new ArrayList<>();
//        eventdesc.add("blablablablablablablablablabla" +
//                "blablablablablablablablablablablabla" +
//                "bla");
//        eventdesc.add("Street Dance*Street Dance*Street Dance*Street Dance*" +
//                "Street Dance*Street Dance*Street Dance*Street Dance*" +
//                "Street Dance*vStreet Dance*");
//        eventdesc.add("TandavTandavTandavTandav" +
//                "TandavTandavTandavTandavTandavTandav" +
//                "TandavTandavTandavTandav");
//        eventdesc.add("Desert Duel*");
//        eventdesc.add("Razzmatazz*");


        final RecyclerView.Adapter adapter = new Event_cardAdapter(getContext(),eventtitle, eventdesc);
        recyclerView.setAdapter(adapter);


        mRef2.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String value = dataSnapshot.getValue(String.class);
                eventdesc.add(value);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        mRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String value = dataSnapshot.getValue(String.class);
                eventtitle.add(value);
                Log.v("array list of Oratory", eventtitle.toString());
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

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