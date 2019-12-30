package com.example.application1;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Fragment1 extends Fragment {
    final List<String> LIST_MENU = MainActivity.names;
    final List<PhoneBook> REF_MENU = MainActivity.phoneBooks;

    public Fragment1() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //For onclickview
//        Display display = ((WindowManager) getActivity().getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
//        Point point = new Point();
//
//        display.getSize(point);
//        int displayWidth = point.x;

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment1, null);

//        ArrayAdapter Adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, LIST_MENU);
        ListViewAdapter adapter = new ListViewAdapter(getActivity(), R.layout.listview_btn_item, REF_MENU, null);

        ListView listview = (ListView) view.findViewById(R.id.listview1);
        listview.setAdapter(adapter);

//        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//            }
//        });

        return view;
        //return inflater.inflate(R.layout.fragment_fragment1, container, false);
    }
}
