package com.kingtvarshin.oasis2016new.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.kingtvarshin.oasis2016new.R;

import java.util.ArrayList;

import static com.kingtvarshin.oasis2016new.R.id.eventtitle;

/**
 * Created by lenovo on 11-10-2016.
 */

public class Fragment_updates extends Fragment {

    private Firebase mRef;
    private ListView mListView;

    private static final String TAG = "FavoritesActivity";

    //    ListView l4;
    ArrayList<String> updatess = new ArrayList<>();

    ProgressBar loading;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.fragment_updates, container, false);

//        l4 = (ListView)rootView.findViewById(R.id.listView4);

        Firebase.setAndroidContext(getActivity());

        loading = (ProgressBar) rootView.findViewById(R.id.loading);
        loading.setVisibility(View.VISIBLE);


        Firebase.setAndroidContext(getActivity());

        mRef = new Firebase("https://oasis-81d10.firebaseio.com/updates");

        mRef.addChildEventListener(new com.firebase.client.ChildEventListener() {
            @Override
            public void onChildAdded(com.firebase.client.DataSnapshot dataSnapshot, String s) {
                String value = dataSnapshot.getValue(String.class);
                updatess.add(value);
                Log.v("Array list", updatess.toString());

                //TODO put the arraylist "updatess" into an adapter

                loading.setVisibility(View.GONE);

            }

            @Override
            public void onChildChanged(com.firebase.client.DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(com.firebase.client.DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(com.firebase.client.DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        return rootView;
    }

}