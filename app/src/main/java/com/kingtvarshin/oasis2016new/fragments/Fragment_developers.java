package com.kingtvarshin.oasis2016new.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.kingtvarshin.oasis2016new.Adapter.Developers_listAdapter;
import com.kingtvarshin.oasis2016new.R;

import java.util.ArrayList;

/**
 * Created by lenovo on 14-09-2016.
 */
public class Fragment_developers extends Fragment {

    private ArrayList<String> name;
    private ArrayList<String> work;
    private ArrayList<String> number;
    ListView lv;
    private Context context;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_developers, container, false);

//        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.card_recycler_view_developers);

        lv = (ListView)rootView.findViewById(R.id.listview_developers);

//        recyclerView.setHasFixedSize(true);
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
//        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(),3);
//        RecyclerView.LayoutManager layoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
//        recyclerView.setLayoutManager(layoutManager);

        name = new ArrayList<>();
        name.add("Vikrant Singh");
        name.add("Aditya Raj Agarwal");

        work = new ArrayList<>();
        work.add("Registration and Other Enquiries");
        work.add("Registration and Other Enquiries");

        number = new ArrayList<>();
        number.add("+91-7240105044");
        number.add("+91-8826248944");

//        RecyclerView.Adapter adapter = new Developers_cardAdapter(getContext(),name,work);
//        recyclerView.setAdapter(adapter);

        lv.setAdapter(
                new Developers_listAdapter(getContext(),name,work)
        );

        lv.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        dialContactPhone(number.get(position));
                    }
                }
        );
        return rootView;
    }

    private void dialContactPhone(final String phoneNumber) {
        startActivity(new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phoneNumber, null)));
    }

}