package com.example.application1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

public class ImagePagerAdapter extends PagerAdapter {

    private ViewPager viewPager;
    List<Imagelist> imagelist = new ArrayList<Imagelist>();
    Context context;
    private LayoutInflater inflater;

    public ImagePagerAdapter(Context context){
        this.context = context;
        Intent intent = ((Activity) context).getIntent();
        imagelist = intent.getParcelableArrayListExtra("image List");
    }

    @Override
    public int getCount() {
        return imagelist.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        inflater = (LayoutInflater)context.getSystemService
                (Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.slider, container, false);
        ImageView imageView = (ImageView)v.findViewById(R.id.imageView);
//                imageView.setImageResource(images[position]);

        Imagelist tmp = imagelist.get(position);
        if(tmp.imageId != 0){
            imageView.setImageResource(tmp.imageId);
        }
        else if(tmp.imageId == 0){
            imageView.setImageURI(Uri.parse(tmp.imageUri));
        }

        container.addView(v);
        return v;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.invalidate();
    }

}
