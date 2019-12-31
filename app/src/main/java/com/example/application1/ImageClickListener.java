package com.example.application1;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.content.Context;
import android.content.Intent;
import android.view.View.OnClickListener;

import androidx.core.util.ObjectsCompat;

import java.util.ArrayList;
import java.util.List;

public class ImageClickListener implements View.OnClickListener {
    Context context;

    int imageID; // 확대해서 보여줄 사진 id
    String imageURI;
    List<Imagelist> imagelist = new ArrayList<Imagelist>();

    public ImageClickListener(Context context, int imageID, String imageURI, List<Imagelist> imagelist) {
        this.context = context;
        this.imageID = imageID;
        this.imageURI = imageURI;
        this.imagelist.addAll(imagelist);
    }


    public void onClick(View v) {
        //---------------------------------------------------------
        // 확대된 이미지를 보여주는 액티비티를 실행하기 위해 인텐트 객체를 정의합니다.
        // 그리고 이 액티비티에 전달할 imageID의 값을 이 객체에 저장합니다.
        // 인텐트 객체를 정의 후 이 액티비티를 실행합니다.

        Intent intent = new Intent(context, ImageActivity.class);
//        Bundle bundle = new Bundle();
        intent.putExtra("image ID", imageID);
        intent.putExtra("image URI", imageURI);
        intent.putParcelableArrayListExtra("image List", (ArrayList<? extends Parcelable >) imagelist);
        context.startActivity(intent);
    }


}
