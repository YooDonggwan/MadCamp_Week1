package com.example.application1;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;


public class ContactClickActivity extends Activity {
    private final List<PhoneBook> phoneBooks = MainActivity.phoneBooks;
    private String name;
    private String tel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contactclick);
        Intent receivedIntent = getIntent();
        name = (String)receivedIntent.getExtras().get("name");
        tel = (String)receivedIntent.getExtras().get("tel");
        //Call Button
        Button callbtn = (Button) findViewById(R.id.call_bt);
        callbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+tel));
                startActivity(intent);
            }
        });
        TextView textView_name = (TextView) findViewById(R.id.name);
        TextView textView_tel = (TextView) findViewById(R.id.phonenum);
        setText_name(textView_name);
        setText_tel(textView_tel);
    }
    private void setText_name(TextView textview) {
        String str = "Name : " + name;
        textview.setText(str);
    }
    private void setText_tel(TextView textview) {
        String str = "Phone : " + tel;
        textview.setText(str);
    }
}
