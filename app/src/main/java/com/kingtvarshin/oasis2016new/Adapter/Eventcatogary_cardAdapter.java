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
public class Eventcatogary_cardAdapter extends RecyclerView.Adapter<Eventcatogary_cardAdapter.ViewHolder> {

    private ArrayList<String> eventcatogary;
    private ArrayList<String> eventicon;

    public Eventcatogary_cardAdapter(ArrayList<String> eventcatogary, ArrayList<String> eventicon) {
        this.eventcatogary = eventcatogary;
        this.eventicon = eventicon;
    }

    @Override
    public Eventcatogary_cardAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_eventoption, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(Eventcatogary_cardAdapter.ViewHolder viewHolder, int i) {

        viewHolder.tv_Eventcatogary.setText(eventcatogary.get(i));
//        viewHolder.tv_Eventicon.setText(eventicon.get(i));
        Picasso.with(viewHolder.tv_Eventicon.getContext()).load(eventicon.get(i)).into(viewHolder.tv_Eventicon);
//        if(i<=4){
//        viewHolder.card.setCardBackgroundColor(Color.BLUE);}
//        else if(i>=5)
//            viewHolder.card.setCardBackgroundColor(Color.RED);
    }

    @Override
    public int getItemCount() {
        return eventcatogary.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_Eventcatogary;
        private ImageView tv_Eventicon;
        CardView card;
        public ViewHolder(View view) {
            super(view);

            tv_Eventcatogary = (TextView)view.findViewById(R.id.textVieweventcatogary);
            tv_Eventicon = (ImageView) view.findViewById(R.id.imageView2);

            card = (CardView)view.findViewById(R.id.card);
        }
    }

}