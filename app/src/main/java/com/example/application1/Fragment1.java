package com.example.application1;

import androidx.fragment.app.Fragment;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Fragment1 extends Fragment {
    final List<String> LIST_MENU = MainActivity.contacts;

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
