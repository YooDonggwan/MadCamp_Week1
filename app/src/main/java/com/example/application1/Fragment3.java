package com.example.application1;

import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.GridView;

import androidx.fragment.app.Fragment;

public class Fragment3 extends Fragment {

    public Fragment3(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_fragment3, container, false);

//        Button startbtn = (Button)v.findViewById(R.id.game2);
//        startbtn.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v){
//                Intent intent = new Intent(getContext(), Game2Activity.class);
//                getContext().startActivity(intent);
//            }
//        });
        return v;
    }
}
