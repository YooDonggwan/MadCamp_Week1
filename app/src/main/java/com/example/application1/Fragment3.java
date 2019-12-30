package com.example.application1;

import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.GridView;

import androidx.fragment.app.Fragment;

public class Fragment3 extends Fragment {

    public Fragment3(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        Display display = ((WindowManager) getActivity().getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        Point point = new Point();
        display.getSize(point);
        int displayWidth = point.x;

        View v = inflater.inflate(R.layout.fragment_fragment3, container, false);
        GridView gridView = (GridView) v.findViewById(R.id.gridview2);
        GameAdapter adapter = new GameAdapter(getActivity(), displayWidth);
        return v;
    }
}
