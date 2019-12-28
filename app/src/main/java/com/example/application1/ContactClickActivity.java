package com.example.application1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;


public class ContactClickActivity extends Activity {
    private final List<PhoneBook> phoneBooks = MainActivity.phoneBooks;
//    private String name;
//    private String tel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contactclick);
        TextView textView_name = (TextView) findViewById(R.id.name);
        TextView textView_tel = (TextView) findViewById(R.id.phonenum);
        setText_name(textView_name);
        setText_tel(textView_tel);
    }
    private void setText_name(TextView textview) {
        Intent receivedIntent = getIntent();
        String name = (String)receivedIntent.getExtras().get("name");
        String str = "Name : " + name;
        textview.setText(str);
    }
    private void setText_tel(TextView textview) {
        Intent receivedIntent = getIntent();
        String tel = (String)receivedIntent.getExtras().get("tel");
        String str = "Phone : " + tel;
        textview.setText(str);
    }
}
