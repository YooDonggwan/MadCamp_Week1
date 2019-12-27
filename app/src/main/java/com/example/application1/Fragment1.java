package com.example.application1;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;


public class Fragment1 extends Fragment {

    static final String[] LIST_MENU = {"LIST1", "LIST2", "LIST3"}; // 여기에 json으로 연락처 받아서 넣으면 됨

    public Fragment1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment1, null);

        ArrayAdapter Adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, LIST_MENU);

        ListView listview = (ListView) view.findViewById(R.id.listview1);
        listview.setAdapter(Adapter);

        return view;
        //return inflater.inflate(R.layout.fragment_fragment1, container, false);
    }


}
