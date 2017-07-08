package com.example.acer.twittersearch;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by acer on 7.07.2017.
 */

public class RecyclerClass extends RecyclerView.Adapter<RecyclerClass.ViewHolder> {
    Context c;
    OuterClass outer;
    ArrayList <InnerInfo> arrayList;
            public  RecyclerClass(OuterClass outer,Context c)
             {this.c=c;
                 this.outer=outer;
                 arrayList=new ArrayList<>();
                 for(int i=0;i<outer.getStatuses().size();i++)
                 {
                     arrayList.add(outer.getStatuses().get(i));


                 }




             }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(c);
        View v=inflater.inflate(R.layout.recyclerlayout,parent,false);
        ViewHolder vh=new ViewHolder(v);
        return vh;


    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        MoreInner inner=arrayList.get(position).getUser();
        holder.name.setText(inner.getName());
        Picasso.with(c).load(inner.getProfile_image_url_https()).into(holder.profile);
        holder.status.setText(arrayList.get(position).getText());
        holder.link.setText(arrayList.get(position).getLink());
        Linkify.addLinks(holder.link, Linkify.WEB_URLS);
        //to link the text
        holder.retweets.setText(arrayList.get(position).getRetweet_count());
        holder.likes.setText(arrayList.get(position).getFavourites_count());




    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
       ImageView profile;
        TextView name;
        TextView status;
        TextView link;
        TextView likes;
        TextView retweets;

        public ViewHolder(View itemView) {
            super(itemView);

            profile=(ImageView)itemView.findViewById(R.id.profile);
            name=(TextView) itemView.findViewById(R.id.name);
            status=(TextView)itemView.findViewById(R.id.tweet);
            link=(TextView)itemView.findViewById(R.id.link);
            likes=(TextView)itemView.findViewById(R.id.likes);
            retweets=(TextView)itemView.findViewById(R.id.retweet);



        }
    }


}
