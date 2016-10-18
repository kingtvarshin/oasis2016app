package com.kingtvarshin.oasis2016new.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.kingtvarshin.oasis2016new.R;

import java.util.ArrayList;

/**
 * Created by lenovo on 05-09-2016.
 */
public class Contactus_listAdapter extends BaseAdapter {

    private ArrayList<String> name;
    private ArrayList<String> post;
    private ArrayList<String> mail;
    private ArrayList<String> number;
    private int lastPosition=-1;
    private Context mContext;

    public Contactus_listAdapter(Context context, ArrayList<String> name, ArrayList<String> post, ArrayList<String> mail, ArrayList<String> number) {
        this.mContext = context;
        this.name = name;
        this.post = post;
        this.mail = mail;
        this.number = number;
    }

//    @Override
//    public Developers_listAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
//        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_developer, viewGroup, false);
//        return new ViewHolder(view);
//    }

//    @Override
//    public void onBindViewHolder(Developers_listAdapter.ViewHolder viewHolder, int i) {
//
//        viewHolder.tv_name.setText(name.get(i));
//        viewHolder.tv_work.setText(work.get(i));
////        viewHolder.card.setAlpha(.3f);
//        setAnimation(viewHolder.card, i);
////        if(i<=4){
////        viewHolder.card.setCardBackgroundColor(Color.BLUE);}
////        else if(i>=5)
////            viewHolder.card.setCardBackgroundColor(Color.RED);
//    }

//    private void setAnimation(FrameLayout container, int position) {
//        Animation animation = AnimationUtils.loadAnimation(mContext, R.anim.home_fade);
//        container.startAnimation(animation);
//    }

//    @Override
//    public int getItemCount() {
//        return name.size();
//    }

    @Override
    public int getCount() {
        return name.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.listitem_contactus, viewGroup, false);

        TextView nname = (TextView) row.findViewById(R.id.nametv);
        TextView ppost = (TextView) row.findViewById(R.id.posttv);
        TextView mmail = (TextView) row.findViewById(R.id.mailtv);
        TextView nnumber = (TextView) row.findViewById(R.id.numbertv);

        nname.setText(name.get(position));
        ppost.setText(post.get(position));
        mmail.setText(mail.get(position));
        nnumber.setText(number.get(position));


        return row;
    }

//    public class ViewHolder extends RecyclerView.ViewHolder{
//        private TextView tv_name;
//        private TextView tv_work;
//        CardView card;
//        public ViewHolder(View view) {
//            super(view);
//
//            tv_name = (TextView)view.findViewById(R.id.nametf);
//            tv_work = (TextView) view.findViewById(R.id.worktf);
//
//            card = (CardView)view.findViewById(R.id.card);
//        }
//    }

}