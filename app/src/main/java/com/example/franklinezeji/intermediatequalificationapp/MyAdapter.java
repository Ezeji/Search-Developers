package com.example.franklinezeji.intermediatequalificationapp;


/**
 * Created by user on 8/3/2017.
 */

import android.app.LauncherActivity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.zip.Inflater;

import static android.os.Build.VERSION_CODES.M;

/**
 * Created by user on 7/28/2017.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    public static final String KEY_NAME = "name";
    public static final String KEY_IMAGE = "image";
    public static final String KEY_URL = "url";

    private List<ListItem> listitems;
    private Context context;

    public MyAdapter(List<ListItem> listitems, Context context) {
        this.listitems = listitems;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        final ListItem listitem = listitems.get(position);

        holder.textviewname1.setText(listitem.getUser_name());

        holder.textviewname2.setText(listitem.getHtml_url());


        Picasso.with(context)
                .load(listitem.getImageUrl())
                .into(holder.imageview );

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ListItem listitem = listitems.get(position);

                Intent skipIntent = new Intent(v.getContext(), ProfileActivity.class);
                skipIntent.putExtra(KEY_NAME, listitem.getUser_name());
                skipIntent.putExtra(KEY_URL, listitem.getHtml_url());
                skipIntent.putExtra(KEY_IMAGE, listitem.getImageUrl());
                v.getContext().startActivity(skipIntent);
            }
        });

           }



    @Override
    public int getItemCount() {
        return listitems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textviewname1;
        public TextView textviewname2;
        public LinearLayout linearLayout;
        public ImageView imageview;



        public ViewHolder(View itemView) {
            super(itemView);


            textviewname1 = (TextView) itemView.findViewById(R.id.user_name);
            textviewname2 = (TextView) itemView.findViewById(R.id.github_url);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.linearLayout);
            imageview = (ImageView) itemView.findViewById(R.id.profile_image);

        }
    }






}
