package com.kingtvarshin.oasis2016new.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.kingtvarshin.oasis2016new.Adapter.Developers_cardAdapter;
import com.kingtvarshin.oasis2016new.Adapter.Sponsors_cardAdapter;
import com.kingtvarshin.oasis2016new.R;

import java.util.ArrayList;

/**
 * Created by lenovo on 14-09-2016.
 */
public class Frament_sponsors extends Fragment {

    private Firebase mRef;
    private ArrayList<String> sponsorsname;
    private ArrayList<String> sponsorslink;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_sponsors, container, false);

        Firebase.setAndroidContext(getContext());

        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.card_recycler_view_sponsors);

        recyclerView.setHasFixedSize(true);
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(),2);
//        RecyclerView.LayoutManager layoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        mRef = new Firebase("https://oasis-81d10.firebaseio.com/sponsors");

        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                sponsorsname = new ArrayList<String>();
                sponsorslink = new ArrayList<String>();

                int length = Integer.parseInt(dataSnapshot.getValue().toString());

                for(int i=0;i<length;i++) {
                    Firebase myFirebaseRef = new Firebase("https://oasis-81d10.firebaseio.com/sponsors/n" + i + "/name");
                    myFirebaseRef.addValueEventListener(
                            new ValueEventListener() {
                                @Override
                                public void onDataChange(DataSnapshot dataSnapshot1) {
                                    String value = dataSnapshot1.getValue(String.class);

                                    sponsorsname.add(value);
                                }

                                @Override
                                public void onCancelled(FirebaseError firebaseError) {

                                }
                            }
                    );

                }
                for(int i=0;i<length;i++) {
                    Firebase myFirebaseRef = new Firebase("https://oasis-81d10.firebaseio.com/sponsors/n" + i + "/url");
                    myFirebaseRef.addValueEventListener(
                            new ValueEventListener() {
                                @Override
                                public void onDataChange(DataSnapshot dataSnapshot1) {
                                    String value = dataSnapshot1.getValue(String.class);
                                    sponsorslink.add(value);
                                }

                                @Override
                                public void onCancelled(FirebaseError firebaseError) {

                                }
                            }
                    );

                }

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        RecyclerView.Adapter adapter = new Sponsors_cardAdapter(sponsorsname,sponsorslink);
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
                    Toast.makeText(getContext(), sponsorsname.get(position), Toast.LENGTH_SHORT).show();
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