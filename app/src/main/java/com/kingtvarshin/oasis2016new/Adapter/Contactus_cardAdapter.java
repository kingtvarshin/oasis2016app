package com.kingtvarshin.oasis2016new.Adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kingtvarshin.oasis2016new.R;

import java.util.ArrayList;

/**
 * Created by lenovo on 05-09-2016.
 */
public class Contactus_cardAdapter extends RecyclerView.Adapter<Contactus_cardAdapter.ViewHolder> {

    private ArrayList<String> name;
    private ArrayList<String> post;
    private ArrayList<String> mail;
    private ArrayList<String> number;

    public Contactus_cardAdapter(ArrayList<String> name, ArrayList<String> post, ArrayList<String> mail, ArrayList<String> number) {
        this.name = name;
        this.post = post;
        this.mail = mail;
        this.number = number;
    }

    @Override
    public Contactus_cardAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_contactus, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(Contactus_cardAdapter.ViewHolder viewHolder, int i) {

        viewHolder.tv_name.setText(name.get(i));
        viewHolder.tv_post.setText(post.get(i));
        viewHolder.tv_mail.setText(mail.get(i));
        viewHolder.tv_number.setText(number.get(i));
//        if(i<=4){
//        viewHolder.card.setCardBackgroundColor(Color.BLUE);}
//        else if(i>=5)
//            viewHolder.card.setCardBackgroundColor(Color.RED);
    }

    @Override
    public int getItemCount() {
        return name.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_name;
        private TextView tv_post;
        private TextView tv_mail;
        private TextView tv_number;
        CardView card;
        public ViewHolder(View view) {
            super(view);

            tv_name = (TextView)view.findViewById(R.id.nametv);
            tv_post = (TextView) view.findViewById(R.id.posttv);
            tv_mail = (TextView)view.findViewById(R.id.mailtv);
            tv_number = (TextView) view.findViewById(R.id.numbertv);

            card = (CardView)view.findViewById(R.id.card);
        }
    }

}