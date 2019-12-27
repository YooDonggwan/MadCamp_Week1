package com.example.application1;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;

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
    //static final String[] LIST_MENU = {"LIST1", "LIST2", "LIST3"}; // 여기에 json으로 연락처 받아서 넣으면 됨
//    Context context = MainActivity.getAppContext();
//    List<String> LIST_MENU = getNames();
//
//    public List<String> getNames() {
//        List<String> datas = new ArrayList<>();
//
//        //2. 전화번호 저장된 테이블 주소값(URI) 가져오기
//        Uri phoneUri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
//
//        String[] projection = { ContactsContract.CommonDataKinds.Phone.CONTACT_ID,
//                ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
//                ContactsContract.CommonDataKinds.Phone.NUMBER};
//
//        Cursor cursor = getActivity().getContentResolver().query(phoneUri, projection, null, null, null);
//
//        if (cursor != null) {
//            while(cursor.moveToNext()){
//                int idIndex = cursor.getColumnIndex(projection[0]);
//                int nameIndex = cursor.getColumnIndex(projection[1]);
//                int numberIndex = cursor.getColumnIndex(projection[2]);
//
////                String id = cursor.getString(idIndex);
//                String name = cursor.getString(nameIndex);
//                //String number = cursor.getString(numberIndex);
//
//                //PhoneBook phoneBook = new PhoneBook();
//                //phoneBook.setID(id);
//                //phoneBook.setName(name);
//                //phoneBook.setTel(number);
//
//                datas.add(name);
//            }
//        }
//
//        cursor.close();
//        return datas;
//    }

    public Fragment1() {
        // Required empty public constructor
    }

//
//    public List<PhoneBook> getContacts(Context context) {
//        List<PhoneBook> datas = new ArrayList<>();
//        //1. Resolver 가져오기
//        ContentResolver resolver = context.getContentResolver();
//
//        //2. 전화번호 저장된 테이블 주소값(URI) 가져오기
//        Uri phoneUri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
//
//        String[] projection = { ContactsContract.CommonDataKinds.Phone.CONTACT_ID,
//                ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
//                ContactsContract.CommonDataKinds.Phone.NUMBER};
//
//        Cursor cursor = resolver.query(phoneUri, projection, null, null, null);
//
//        if (cursor != null) {
//            while(cursor.moveToNext()){
//                int idIndex = cursor.getColumnIndex(projection[0]);
//                int nameIndex = cursor.getColumnIndex(projection[1]);
//                int numberIndex = cursor.getColumnIndex(projection[2]);
//
//                String id = cursor.getString(idIndex);
//                String name = cursor.getString(nameIndex);
//                String number = cursor.getString(numberIndex);
//
//                PhoneBook phoneBook = new PhoneBook();
//                phoneBook.setID(id);
//                phoneBook.setName(name);
//                phoneBook.setTel(number);
//
//                datas.add(phoneBook);
//            }
//        }
//
//        cursor.close();
//        return datas;
//    }

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
