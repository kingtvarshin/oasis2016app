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
import android.widget.ListView;

import com.kingtvarshin.oasis2016new.Adapter.Contactus_listAdapter;
import com.kingtvarshin.oasis2016new.R;

import java.util.ArrayList;

/**
 * Created by lenovo on 14-09-2016.
 */
public class Fragment_contactus extends Fragment {

    private ArrayList<String> name;
    private ArrayList<String> post;
    private ArrayList<String> mail;
    private ArrayList<String> number;
    private Context context;
    ListView lv;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_contactus, container, false);

        lv = (ListView)rootView.findViewById(R.id.listview_contactus);

        name = new ArrayList<>();
        name.add("Emergency Contact");
        name.add("Emergency Contact");
        name.add("Emergency Contact");
        name.add("Aditya Shetty");
        name.add("Aditya Ruia");
        name.add("Mudit Marda");
        name.add("Tarun Kumar");
        name.add("Ketul Mathuria");
        name.add("Abhishek Prasad");
        name.add("Nalin Mujumdar");

        post = new ArrayList<>();
        post.add("Emergency Contact");
        post.add("Emergency Contact");
        post.add("Emergency Contact");
        post.add("Registration and Other Enquiries");
        post.add("Sponsorship and Marketing");
        post.add("Controls");
        post.add("Website and Online Payments");
        post.add("Reception and Accommodation");
        post.add("Art, Design and Publicity");
        post.add("Stage Controls");

        mail = new ArrayList<>();
        mail.add("Emergency Contact");
        mail.add("Emergency Contact");
        mail.add("Emergency Contact");
        mail.add("webmaster@bits-oasis.org");
        mail.add("recnacc@bits-oasis.org");
        mail.add("adp@bits-oasis.org");
        mail.add("stagecontrols@bits-oasis.org");
        mail.add("Emergency Contact");
        mail.add("Emergency Contact");
        mail.add("Emergency Contact");

        number = new ArrayList<>();
        number.add("+91-7240105153");
        number.add("+91-9619617661");
        number.add("+91-8875544546");
        number.add("+91-7240105153");
        number.add("+91-9619617661");
        number.add("+91-8875544546");
        number.add("+91-9460973751");
        number.add("+91-9694874277");
        number.add("+91-8504004462");
        number.add("+91-8504001914");

        lv.setAdapter(
                new Contactus_listAdapter(getContext(),name,post,mail,number)
        );
        return rootView;
    }

    private void dialContactPhone(final String phoneNumber) {
        startActivity(new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phoneNumber, null)));
    }

}