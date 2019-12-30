package com.example.application1;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;

import java.net.URI;
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
    private List<Imagelist> mThumbIds;

    public ImageAdapter(Context c, int displayWidth){
        mContext = c;
        mThumbIds = new ArrayList<Imagelist>();

        mThumbIds.add(new Imagelist(R.drawable.f1, ""));
        mThumbIds.add(new Imagelist(R.drawable.f2, ""));
        mThumbIds.add(new Imagelist(R.drawable.f3, ""));
        //넘어온 가로크기를 저장.
        this.displayWidth = displayWidth;
        size = displayWidth/3 ;  //화면크기를 / 3으로 나누어서 이미지 사이즈를 구한다.
        pad = 8;
        System.out.println("size="+size);
    }

    @Override
    public int getCount() {
        //이미지셋에 있는 아이템의 수를 반환함(그리드뷰는 아이템의 수에 해당하는 행렬을 준비함)
        return mThumbIds.size();
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
        RecyclerView.ViewHolder viewHolder;
        ImageView imageView;
        if(convertView == null){
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(size, size)); //85,85
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(pad, pad, pad, pad); //8,8,8,8

        }else{
            imageView = (ImageView) convertView;
        }
        Imagelist tmp = mThumbIds.get(position);

        if(tmp.imageId != 0){
            ImageClickListener imageViewClickListener_int
                    = new ImageClickListener(mContext, tmp.imageId, "", mThumbIds);
            imageView.setOnClickListener(imageViewClickListener_int);
            imageView.setImageResource(tmp.imageId);
        }
        else if(tmp.imageId == 0){
            ImageClickListener imageViewClickListener_str
                    = new ImageClickListener(mContext, 0, tmp.imageUri, mThumbIds);
            imageView.setOnClickListener(imageViewClickListener_str);
            imageView.setImageURI(Uri.parse(tmp.imageUri));
        }

        //        switch (tmp.getClass().getSimpleName()) {
//            case "Integer":
//                ImageClickListener imageViewClickListener_int
//                        = new ImageClickListener(mContext, (int)tmp, "", mThumbIds);
//                imageView.setOnClickListener(imageViewClickListener_int);
//                imageView.setImageResource((int)tmp);
//                break;
//            case "String":
//                System.out.println("string case");
//                ImageClickListener imageViewClickListener_str
//                        = new ImageClickListener(mContext, 0, (String)tmp, mThumbIds);
//                imageView.setOnClickListener(imageViewClickListener_str);
//                imageView.setImageURI(Uri.parse((String)tmp));
//                break;
//        }


        return imageView;
    }

    public void addThumbId(String o) {
        mThumbIds.add(new Imagelist(0, o));
    }

//    public class ImagePagerAdapter extends PagerAdapter {
//
//        private LayoutInflater inflater;
//        private Context context;
//
//        public ImagePagerAdapter(Context context){
//            this.context = context;
//        }
//
//        @Override
//        public int getCount() {
//            return mThumbIds.size();
//        }
//
//        @Override
//        public boolean isViewFromObject(View view, Object object) {
//            return view == ((LinearLayout) object);
//        }
//
//        @Override
//        public Object instantiateItem(ViewGroup container, int position) {
//            inflater = (LayoutInflater) context.getSystemService
//                    (Context.LAYOUT_INFLATER_SERVICE);
//            View v = inflater.inflate(R.layout.slider, container, false);
//            ImageView imageView = (ImageView) v.findViewById(R.id.imageView);
//
//            Object tmp = mThumbIds.get(position);
//            switch (tmp.getClass().getSimpleName()) {
//                case "Integer":
//                    ImageClickListener imageViewClickListener_int
//                            = new ImageClickListener(mContext, (int) tmp, "");
//                    imageView.setOnClickListener(imageViewClickListener_int);
//                    imageView.setImageResource((int) tmp);
//                    break;
//                case "String":
//                    System.out.println("string case");
//                    ImageClickListener imageViewClickListener_str
//                            = new ImageClickListener(mContext, 0, (String) tmp);
//                    imageView.setOnClickListener(imageViewClickListener_str);
//                    imageView.setImageURI(Uri.parse((String) tmp));
//                    break;
//            }
//            container.addView(v);
//            return v;
//        }
//
//        @Override
//        public void destroyItem(ViewGroup container, int position, Object object) {
//            container.invalidate();
//        }
//    }
}
