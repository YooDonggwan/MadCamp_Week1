package com.example.application1;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.media.ThumbnailUtils;
import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;


public class Fragment2 extends Fragment {

    public Fragment2() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        Display display = ((WindowManager) getActivity().getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        Point point = new Point();

        display.getSize(point);
        int displayWidth = point.x;
        int displayHeight = point.y;

        View v = inflater.inflate(R.layout.fragment_fragment2, container, false);
        GridView gridView = (GridView) v.findViewById(R.id.gridview1);
        ImageAdapter adapter = new ImageAdapter(getActivity(), displayWidth); //가로크기의 정보를 같이 넘긴다.
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {


            }
        });
        return v;
    }
}
