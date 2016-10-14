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

/**
 * Created by lenovo on 14-10-2016.
 */

public class Profshowdetail extends AppCompatActivity {

    private CollapsingToolbarLayout ctbl = null;
    String myParam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profshowdetail);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        Bundle extras = getIntent().getExtras();
        if (extras != null)
        {
            myParam = extras.getString("name");
        }
        else
        {
            //..oops!
        }


        ctbl = (CollapsingToolbarLayout)findViewById(R.id.collapsing_toolbar);
        ctbl.setTitle(myParam);

        dynamicToolbarColor();

        toolbarTextAppearnce();

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();//What to do on back clicked
            }
        });

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
