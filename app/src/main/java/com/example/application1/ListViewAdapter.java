package com.example.application1;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ListViewAdapter extends ArrayAdapter {
    public interface ListBtnClickListener {
        void onListBtnClick(int position);
    }
    int resourceId;
    private ListBtnClickListener listBtnClickListener;
    private List<PhoneBook> phoneBooks;
    private boolean numOpened;
    public boolean isOpened() {
        return numOpened;
    }

    public void setOpened() {
        if (this.numOpened) {
            this.numOpened = false;
        }
        else {
            this.numOpened = true;
        }
    }

    public ListViewAdapter(Context context, int resource, List<PhoneBook> list, ListBtnClickListener clickListener) {
        super(context, resource, list);
        this.resourceId = resource;
        this.listBtnClickListener = clickListener;
        this.phoneBooks = list;
        this.numOpened = false;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listview_btn_item, parent, false);
        }

        ImageView iconImageView = (ImageView) convertView.findViewById(R.id.imageView1);
        final TextView nameTextView = (TextView) convertView.findViewById(R.id.textView1);
        String name = phoneBooks.get(pos).getName();
        final String tel = phoneBooks.get(pos).getTel();
        nameTextView.setText(name);
        final String str_true = name + "\n" + tel;
        final String str_false = name;

        final ImageButton button1 = (ImageButton) convertView.findViewById(R.id.numbtn);
        button1.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                setOpened();
                if (isOpened()) {
                    button1.setBackgroundResource(R.drawable.unexpand);
                    nameTextView.setText(str_true);
                }
                else {
                    button1.setBackgroundResource(R.drawable.expand);
                    nameTextView.setText(str_false);
                }
            }
        });

        ImageButton button2 = (ImageButton) convertView.findViewById(R.id.callbtn);
        button2.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+tel));
                context.startActivity(intent);
            }
        });

        return convertView;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Object getItem(int position) {
        return phoneBooks.get(position);
    }

//    public void addItem(Drawable icon, String name) {
//        ListViewItem item = new ListViewItem();
//        item.setIcon(icon);
//        item.setName(name);
//
//        listViewItemList.add(item);
//    }
}
