package com.itca.healthapplication.ConfigRecycler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.itca.healthapplication.R;

public class audioAdapter extends BaseAdapter {

    Context context;
    String audioList[];
    int audioImg[];

    LayoutInflater inflater;
    public audioAdapter(Context ctx,String[] audiolist,int[] audioimg ){
 this.context = ctx;
 this.audioList = audiolist;
 this.audioImg = audioimg;
 inflater = LayoutInflater.from(ctx);
    }
    @Override
    public int getCount() {
        return audioList.length;
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
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.listviewaux,null);
        TextView txtView = (TextView) convertView.findViewById(R.id.tituloaudio);
        ImageView audioImage = (ImageView) convertView.findViewById(R.id.imageIcon);
        txtView.setText(audioList[position]);
        audioImage.setImageResource(audioImg[position]);
        return convertView;
    }
}
