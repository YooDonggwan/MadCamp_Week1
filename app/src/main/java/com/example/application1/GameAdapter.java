package com.example.application1;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class GameAdapter extends BaseAdapter {
    private int displayWidth;
    private int size;
    private int pad;

    private Context mContext;
    private Integer[] Cards = {};

    public GameAdapter(Context c, int displayWidth) {
        mContext = c;
        this.displayWidth = displayWidth;
        size = displayWidth / 3;
        pad = 8;
    }

    @Override
    public int getCount() {
        return Cards.length;
    }

    @Override
    public Object getItem(int arg0) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            imageView = new ImageView(mContext);
        }
        else {
            imageView = (ImageView) convertView;
        }
        return imageView;
    }
}
