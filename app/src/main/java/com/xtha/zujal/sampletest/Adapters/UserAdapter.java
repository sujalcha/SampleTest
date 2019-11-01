package com.xtha.zujal.sampletest.Adapters;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.xtha.zujal.sampletest.Album;
import com.xtha.zujal.sampletest.MainActivity;
import com.xtha.zujal.sampletest.Model.UserInfo;
import com.xtha.zujal.sampletest.R;

import java.util.ArrayList;

import static android.support.constraint.Constraints.TAG;

public class UserAdapter extends BaseAdapter {

    private Context context;
    ArrayList<UserInfo> tDlist;

    public UserAdapter(Context context, ArrayList<UserInfo> tDlist)
    {
        this.context=context;
        this.tDlist=tDlist;
    }

    static class ViewHolder {
        TextView userid;
        TextView username;
        TextView useremail;
        TextView userphone;
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
        View v;

        if (convertView == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.gridviewlayout, parent, false);
            convertView.setTag(holder);

        }
        else {
            holder = (ViewHolder)convertView.getTag();
        }


        holder.userid = (TextView)convertView.findViewById(R.id.userid);
        holder.username= (TextView)convertView.findViewById(R.id.username);
        holder.useremail= (TextView)convertView.findViewById(R.id.useremail);
        holder.userphone= (TextView)convertView.findViewById(R.id.userphone);
        holder.linearLayout = (LinearLayout)convertView.findViewById(R.id.userlayout);

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(context, Album.class);
                intent.putExtra("userid",tDlist.get(position).getUserid());
                context.startActivity(intent);
            }
            });

        for (int i=0; i<tDlist.size();i++) {
            holder.userid.setText(String.valueOf(tDlist.get(position).getUserid()));
            holder.username.setText(tDlist.get(position).getUsername());
            holder.useremail.setText(tDlist.get(position).getUseremail());
            holder.userphone.setText(tDlist.get(position).getUsernumber());
        }

        return convertView;
    }
}
