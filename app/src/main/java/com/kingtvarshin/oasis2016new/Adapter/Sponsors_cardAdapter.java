package com.kingtvarshin.oasis2016new.Adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.kingtvarshin.oasis2016new.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by lenovo on 05-09-2016.
 */
public class Sponsors_cardAdapter extends RecyclerView.Adapter<Sponsors_cardAdapter.ViewHolder> {

    private ArrayList<String> sponsorstitle;
    private ArrayList<String> imgurl;

    public Sponsors_cardAdapter(ArrayList<String> sponsorstitle, ArrayList<String> imgurl) {
        this.sponsorstitle = sponsorstitle;
        this.imgurl = imgurl;
    }

    @Override
    public Sponsors_cardAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_sponsors, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(Sponsors_cardAdapter.ViewHolder viewHolder, int i) {

        viewHolder.tv_Sponsorstitle.setText(sponsorstitle.get(i));
//        viewHolder.tv_Eventicon.setText(eventicon.get(i));
        Picasso.with(viewHolder.tv_Sponsoricon.getContext()).load(sponsorstitle.get(i)).into(viewHolder.tv_Sponsoricon);
//        if(i<=4){
//        viewHolder.card.setCardBackgroundColor(Color.BLUE);}
//        else if(i>=5)
//            viewHolder.card.setCardBackgroundColor(Color.RED);
    }

    @Override
    public int getItemCount() {
        return sponsorstitle.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_Sponsorstitle;
        private ImageView tv_Sponsoricon;
        CardView card;
        public ViewHolder(View view) {
            super(view);

            tv_Sponsorstitle = (TextView)view.findViewById(R.id.textViewsponsortitle);
            tv_Sponsoricon = (ImageView) view.findViewById(R.id.imageView4);

            card = (CardView)view.findViewById(R.id.card);
        }
    }

}