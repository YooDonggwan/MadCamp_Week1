package com.example.application1;

import android.graphics.drawable.Drawable;

public class ListViewItem {
    private Drawable iconDrawable;
    private String nameStr;
//    private String numStr;

    public void setIcon(Drawable icon) {
        iconDrawable = icon;
    }
    public void setName(String name) {
        nameStr = name;
    }
//    public void setNum(String num) {
//        numStr = num;
//    }

    public Drawable getIcon() {
        return this.iconDrawable;
    }
    public String getName() {
        return this.nameStr;
    }
//    public String getNum() {
//        return this.numStr;
//    }
}
