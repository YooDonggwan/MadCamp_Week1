package com.example.application1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

public class ImageActivity extends Activity {

    ImagePagerAdapter imagePagerAdapter;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.clickview);

        //----------------------------------------------------------------
        // 확대되는 이미지를 보여주기 위해 ImageView 뷰를 설정합니다.
//        viewPager = (ViewPager) findViewById(R.id.view);
//        imagerPagerAdapter = new ImageAdapter.ImagePagerAdapter(this);

        ImageView imageView = (ImageView)findViewById(R.id.imageview);
        setImage(imageView);

        viewPager = (ViewPager) findViewById(R.id.view);
        imagePagerAdapter = new ImagePagerAdapter(this);


    }

    private void setImage(ImageView imageView) {

        //----------------------------------------------------------------
        // 초기 액티비티의 GridView 뷰의 이미지 항목을 클릭할 때 생성된 인텐트는
        // 이 액티비티는 getIntent 메소드를 호출하여 접근할 수 있습니다.
        Intent receivedIntent = getIntent();

        //----------------------------------------------------------------
        // 확대되는 이미지의 리소스 ID를 인텐트로부터 읽어들이고,
        // 그것을 ImageView 뷰의 이미지 리소스로 설정합니다.

        int imageID = (Integer)receivedIntent.getExtras().get("image ID");
        System.out.println("listxxxxxxx " + imageID);

        String imageURI = (String)receivedIntent.getExtras().get("image URI");
        if (imageID != 0)
            imageView.setImageResource(imageID);
        else if (!imageURI.equals(""))
            imageView.setImageURI(Uri.parse(imageURI));

    }

}
