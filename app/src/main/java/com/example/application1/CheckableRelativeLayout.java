package com.example.application1;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.Checkable;

public class CheckableRelativeLayout extends LinearLayout implements Checkable {

    public CheckableRelativeLayout(Context context, AttributeSet attrs){
        super(context, attrs);
    }

    @Override
    public boolean isChecked(){
        CheckBox cb = (CheckBox) findViewById(R.id.checkBox1);

        return cb.isChecked();
    }

    @Override
    public void toggle(){
        CheckBox cb = (CheckBox) findViewById(R.id.checkBox1);

        setChecked(cb.isChecked() ? false : true);

    }

    @Override
    public void setChecked(boolean checked){
        CheckBox cb = (CheckBox) findViewById(R.id.checkBox1);

        if(cb.isChecked() != checked){
            cb.setChecked(checked);
        }
    }

}