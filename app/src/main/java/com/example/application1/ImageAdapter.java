package com.example.application1;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ImageAdapter extends BaseAdapter {

    private int displayWidth; //화면크기
    private int size; //이미지 크기
    private int pad; //패딩
    private ArrayList<String> thumbsDataList;
    private ArrayList<String> thumbsIDList;
    private List<Uri> imagelistUri;
    private Context mContext;

    //출력될 이미지 데이터셋(res/drawable 폴더)
    private Integer[] mThumbIds = {
            R.drawable.f1,
            R.drawable.f2,
            R.drawable.f3
    };


    public ImageAdapter(Context c, int displayWidth, List<Uri> imagelistUri){
        mContext = c;
        //넘어온 가로크기를 저장.
        this.imagelistUri = imagelistUri;
        this.displayWidth = displayWidth;
        size = displayWidth/3 ;  //화면크기를 / 3으로 나누어서 이미지 사이즈를 구한다.
        pad = 8;
        imagelistUri = new ArrayList<Uri>();
        System.out.println("size="+size);
    }

    @Override
    public int getCount() {
        //이미지셋에 있는 아이템의 수를 반환함(그리드뷰는 아이템의 수에 해당하는 행렬을 준비함)
        return mThumbIds.length;
    }

    @Override
    public Object getItem(int arg0) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //주어진 위치(position)에 출력할 이미지를 반환함
        ImageView imageView;
        if(convertView == null){
            Log.d("DEBUG","position:"+position);
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(size, size)); //85,85
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(pad, pad, pad, pad); //8,8,8,8

        }else{
            imageView = (ImageView) convertView;
        }

        System.out.println("Uriiiii " + imagelistUri);
        ImageClickListener imageViewClickListener
                = new ImageClickListener(mContext, mThumbIds[position]);
        imageView.setOnClickListener(imageViewClickListener);


        //이미지뷰에 주어진 위치의 이미지를 설정함
        imageView.setImageResource(mThumbIds[position]);
        for(int i = 0; i < imagelistUri.size(); i++){
            Uri uri = imagelistUri.get(i);
            imageView.setImageURI(uri);
        }

        return imageView;
    }


//    private void getThumbInfo(ArrayList<String> thumbsIDs, ArrayList<String> thumbsDatas){
//        String[] proj = {MediaStore.Images.Media._ID,
//                MediaStore.Images.Media.DATA,
//                MediaStore.Images.Media.DISPLAY_NAME,
//                MediaStore.Images.Media.SIZE};
//
//        Cursor imageCursor = mContext.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
//                proj, null, null, null);
//
//        if (imageCursor != null && imageCursor.moveToFirst()){
//            String title;
//            String thumbsID;
//            String thumbsImageID;
//            String thumbsData;
//            String data;
//            String imgSize;
//
//            int thumbsIDCol = imageCursor.getColumnIndex(MediaStore.Images.Media._ID);
//            int thumbsDataCol = imageCursor.getColumnIndex(MediaStore.Images.Media.DATA);
//            int thumbsImageIDCol = imageCursor.getColumnIndex(MediaStore.Images.Media.DISPLAY_NAME);
//            int thumbsSizeCol = imageCursor.getColumnIndex(MediaStore.Images.Media.SIZE);
//            int num = 0;
//            do {
//                thumbsID = imageCursor.getString(thumbsIDCol);
//                thumbsData = imageCursor.getString(thumbsDataCol);
//                thumbsImageID = imageCursor.getString(thumbsImageIDCol);
//                imgSize = imageCursor.getString(thumbsSizeCol);
////                System.out.println("printxxx " + thumbsID);
//                num++;
//                if (thumbsImageID != null){
//                    thumbsIDs.add(thumbsID);
//                    thumbsDatas.add(thumbsData);
//                }
//            }while (imageCursor.moveToNext());
//        }
//        imageCursor.close();
//        return;
//    }


}
