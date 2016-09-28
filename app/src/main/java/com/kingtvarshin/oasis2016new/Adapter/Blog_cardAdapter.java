package com.kingtvarshin.oasis2016new.Adapter;

import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.kingtvarshin.oasis2016new.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by lenovo on 05-09-2016.
 */
public class Blog_cardAdapter extends RecyclerView.Adapter<Blog_cardAdapter.ViewHolder> {

    private ArrayList<String> blogimage;
    private ArrayList<String> blogtitle;
    private ArrayList<String> blogtext;

    public Blog_cardAdapter(ArrayList<String> blogimage,ArrayList<String> blogtitle, ArrayList<String> blogtext) {
        this.blogimage = blogimage;
        this.blogtitle = blogtitle;
        this.blogtext = blogtext;
    }

    @Override
    public Blog_cardAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_blog, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(Blog_cardAdapter.ViewHolder viewHolder, int i) {

        viewHolder.tv_Blogtitle.setText(blogtitle.get(i));
        viewHolder.tv_Blogtext.setText(blogtext.get(i));
        Picasso.with(viewHolder.tv_Blogicon.getContext()).load(blogimage.get(i)).into(viewHolder.tv_Blogicon);

//        if(i<=4){
//        viewHolder.card.setCardBackgroundColor(Color.BLUE);}
//        else if(i>=5)
//            viewHolder.card.setCardBackgroundColor(Color.RED);
    }

    @Override
    public int getItemCount() {
        return blogtitle.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_Blogtitle;
        private TextView tv_Blogtext;
        private ImageView tv_Blogicon;
        CardView card;
        public ViewHolder(View view) {
            super(view);

            tv_Blogtitle = (TextView)view.findViewById(R.id.blogtitle);
            tv_Blogtext = (TextView) view.findViewById(R.id.blogtext);
            tv_Blogicon = (ImageView) view.findViewById(R.id.imageView3);

            card = (CardView)view.findViewById(R.id.card);
        }
    }

}