package com.kingtvarshin.oasis2016new;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

/**
 * Created by lenovo on 17-10-2016.
 */

public class Eventonclick extends AppCompatActivity {

    private CollapsingToolbarLayout ctbl = null;
    String myParam;
    TextView location;
    TextView time;
    TextView description;
    TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventonclick);

    Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar2);
    setSupportActionBar(toolbar);
    ActionBar actionBar = getSupportActionBar();
    actionBar.setDisplayHomeAsUpEnabled(true);

    Bundle extras = getIntent().getExtras();
    if (extras != null) {
        myParam = extras.getString("eventtitle");

    } else {
        //..oops!
    }


    ctbl = (CollapsingToolbarLayout)findViewById(R.id.collapsing_toolbar);
    setTitle(myParam);


//        dynamicToolbarColor();

    toolbarTextAppearnce();

    toolbar.setNavigationOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();//What to do on back clicked
        }
    });

        name = (TextView)findViewById(R.id.eventnametf);
        location = (TextView)findViewById(R.id.locationtf);
        time = (TextView)findViewById(R.id.timetf);
        description = (TextView)findViewById(R.id.descripstiontf);
        name.setText("blablabla");
        location.setText("Gym Grounds");
        time.setText("8:00 PM");
        description.setText("blablablablablablablablablablablablablablablablablablablablabla" +
                "blablablablablablablablablablablablablablablablablablablablablablablablablablabla" +
                "blablablablablablablablablablablablablablablablablablablablablablablablablablablablablabla" +
                "blablablablablablablablablablablablablablablablablablablablablablablabla");

}

    private void dynamicToolbarColor() {

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),
                R.drawable.eventmanager2);
        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(Palette palette) {
                ctbl.setContentScrimColor(palette.getMutedColor(R.attr.colorPrimary));
                ctbl.setStatusBarScrimColor(palette.getMutedColor(R.attr.colorPrimaryDark));
            }
        });
    }

    private void toolbarTextAppearnce() {
        ctbl.setCollapsedTitleTextAppearance(R.style.collapsedappbar);
        ctbl.setExpandedTitleTextAppearance(R.style.expandedappbar);

    }


}
