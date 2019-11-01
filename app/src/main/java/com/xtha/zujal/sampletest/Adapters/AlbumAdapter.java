package com.xtha.zujal.sampletest.Adapters;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.squareup.picasso.Picasso;
import com.xtha.zujal.sampletest.ImageDetails;
import com.xtha.zujal.sampletest.ImageTask;
import com.xtha.zujal.sampletest.Model.AlbumInfo;
import com.xtha.zujal.sampletest.R;


import java.util.ArrayList;

public class AlbumAdapter extends BaseAdapter {

    private Context context;
    ArrayList<AlbumInfo> tDlist;

    public AlbumAdapter(Context context, ArrayList<AlbumInfo> tDlist)
    {
        this.context=context;
        this.tDlist=tDlist;
    }

    static class ViewHolder {
        TextView imagetitle;
        ImageView imageview;
        LinearLayout linearLayout;
    }

    @Override
    public int getCount() {
        return tDlist.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        final ViewHolder holder;

        if (convertView == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.albumtile, parent, false);
            convertView.setTag(holder);

        }
        else {
            holder = (ViewHolder)convertView.getTag();
        }

        holder.imagetitle = (TextView)convertView.findViewById(R.id.imagetitle);
        holder.imageview = (ImageView) convertView.findViewById(R.id.imageview);
        holder.linearLayout = (LinearLayout)convertView.findViewById(R.id.userlayout);


        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(context, ImageDetails.class);
                intent.putExtra("imageurl",tDlist.get(position).getUrl());
                intent.putExtra("imagetitle",tDlist.get(position).getTitle());
                intent.putExtra("imagealbumid",String.valueOf(tDlist.get(position).getAlbumid()));
                intent.putExtra("imagephotoid",String.valueOf(tDlist.get(position).getId()));
                context.startActivity(intent);

            }
        });


        for (int i=0; i<tDlist.size();i++) {
           // new ImageTask(holder.imageview).execute(tDlist.get(position).getThumbnailUrl());

            Picasso.get().load(tDlist.get(position).getThumbnailUrl()).into(holder.imageview);
            holder.imagetitle.setText(tDlist.get(position).getTitle());
        }

        return convertView;
    }





}
