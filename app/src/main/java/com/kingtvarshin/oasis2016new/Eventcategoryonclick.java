package com.kingtvarshin.oasis2016new;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.kingtvarshin.oasis2016new.Adapter.Event_cardAdapter;

import java.util.ArrayList;

/**
 * Created by lenovo on 17-10-2016.
 */

public class Eventcategoryonclick extends AppCompatActivity {

    private ArrayList<String> eventtitle;
    private ArrayList<String> eventtime;
    private ArrayList<String> eventlocation;
    private Context context;
    String myParam;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventcategoryonclick);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar3);
        setSupportActionBar(toolbar);
        Bundle extras = getIntent().getExtras();
        if (extras != null)
        {
            myParam = extras.getString("eventcatogary");

        }
        else
        {
            //..oops!
        }
        setTitle(myParam);


        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.card_recycler_view_eventcategoryonclick);

        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
//        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(),3);
//        RecyclerView.LayoutManager layoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        eventtitle = new ArrayList<>();
        eventtitle.add("Aditya Shetty");
        eventtitle.add("Aditya Ruia");
        eventtitle.add("Mudit Marda");
        eventtitle.add("Tarun Kumar");
        eventtitle.add("Ketul Mathuria");
        eventtitle.add("Abhishek Prasad");
        eventtitle.add("Nalin Mujumdar");

        eventtime = new ArrayList<>();
        eventtime.add("Registration and Other Enquiries");
        eventtime.add("Sponsorship and Marketing");
        eventtime.add("Controls");
        eventtime.add("Website and Online Payments");
        eventtime.add("Reception and Accommodation");
        eventtime.add("Art, Design and Publicity");
        eventtime.add("Stage Controls");

        eventlocation = new ArrayList<>();
        eventlocation.add("Registration and Other Enquiries");
        eventlocation.add("Sponsorship and Marketing");
        eventlocation.add("Controls");
        eventlocation.add("Website and Online Payments");
        eventlocation.add("Reception and Accommodation");
        eventlocation.add("Art, Design and Publicity");
        eventlocation.add("Stage Controls");

        final RecyclerView.Adapter adapter = new Event_cardAdapter(this,eventtitle,eventtime, eventlocation);
        recyclerView.setAdapter(adapter);

        recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            GestureDetector gestureDetector = new GestureDetector(Eventcategoryonclick.this, new GestureDetector.SimpleOnGestureListener() {

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
                    Intent i=new Intent(Eventcategoryonclick.this,Eventonclick.class);
                    i.putExtra("eventtitle",eventtitle.get(position));
                    startActivity(i);
                    Toast.makeText(Eventcategoryonclick.this, eventtitle.get(position), Toast.LENGTH_SHORT).show();
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




    }



}
