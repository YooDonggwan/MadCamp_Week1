package com.example.application1;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter_image extends RecyclerView.Adapter<CustomAdapter_image.CustomViewHolder> {
    private ArrayList<String> mData = null ;

    // 아이템 뷰를 저장하는 뷰홀더 클래스.
    public class CustomViewHolder extends RecyclerView.ViewHolder {
        TextView textView1 ;

        CustomViewHolder(View itemView) {
            super(itemView) ;

            // 뷰 객체에 대한 참조. (hold strong reference)
            //textView1 = itemView.findViewById(R.id.texttest) ;
        }
    }

    // 생성자에서 데이터 리스트 객체를 전달받음.
    CustomAdapter_image(ArrayList<String> list) {
        mData = list ;
    }

    // onCreateViewHolder() - 아이템 뷰를 위한 뷰홀더 객체 생성하여 리턴.
    @Override
    public CustomAdapter_image.CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext() ;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) ;
        View v = inflater.from(context).inflate(R.layout.clickview, parent, false);
//        View view = inflater.inflate(R.layout.fragment_fragment2, parent, false) ;
        CustomAdapter_image.CustomViewHolder vh = new CustomAdapter_image.CustomViewHolder(v) ;

        return vh ;
    }

    // onBindViewHolder() - position에 해당하는 데이터를 뷰홀더의 아이템뷰에 표시.
    @Override
    public void onBindViewHolder(CustomAdapter_image.CustomViewHolder holder, int position) {
        String text = mData.get(position) ;
        holder.textView1.setText(text) ;
    }

    // getItemCount() - 전체 데이터 갯수 리턴.
    @Override
    public int getItemCount() {
        return mData.size() ;
    }
//    private List<Object> mList;
//    private Context mContext;
//    private int displayWidth;
//    private int size;
//    private int pad;
//
//    public CustomAdapter_image(Context c, int displayWidth) {
//        mContext = c;
//        mList = new ArrayList<Object>();
//        mList.add(R.drawable.f1);
//        mList.add(R.drawable.f2);
//        mList.add(R.drawable.f3);
//        System.out.println(mList);
//        this.displayWidth = displayWidth;
//        size = displayWidth/3;
//        pad = 8;
//    }
//
//    public class CustomViewHolder extends RecyclerView.ViewHolder {
//        protected ImageView imageView;
//        public CustomViewHolder(View view) {
//            super(view);
//            imageView = (ImageView)imageView.findViewById(R.id.imageviewrecycle);
//            imageView.setLayoutParams(new RecyclerView.LayoutParams(size, size));
//            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
//            imageView.setPadding(pad, pad, pad, pad);
//        }
//    }
//
//    @Override
//    public CustomAdapter_image.CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        Context context = parent.getContext();
//
//        LayoutInflater inflater = LayoutInflater.from(context);
//        View view = inflater.inflate(R.layout.fragment_fragment2, parent, false);
//        CustomAdapter_image.CustomViewHolder vh = new CustomAdapter_image.CustomViewHolder(view);
//        return vh;
//    }
//
//    @Override
//    public void onBindViewHolder(CustomAdapter_image.CustomViewHolder holder, int position) {
//        Object tmp = mList.get(position);
//        ImageView imageView = holder.imageView;
//        switch (tmp.getClass().getSimpleName()) {
//            case "Integer":
//                imageView.setImageResource((int)tmp);
//                break;
//            case "String":
//                imageView.setImageURI(Uri.parse((String)tmp));
//                break;
//        }
////        switch (tmp.getClass().getSimpleName()) {
////            case "Integer":
////                ImageClickListener imageViewClickListener_int
////                        = new ImageClickListener(mContext, (int)tmp, "");
////                holder.imageView.setOnClickListener(imageViewClickListener_int);
////                holder.imageView.setImageResource((int)tmp);
////                break;
////            case "String":
////                ImageClickListener imageViewClickListener_str
////                        = new ImageClickListener(mContext, 0, (String)tmp);
////                holder.imageView.setOnClickListener(imageViewClickListener_str);
////                holder.imageView.setImageURI(Uri.parse((String)tmp));
////                break;
////        }
//    }
//
//    @Override
//    public int getItemCount() {
//        return mList.size();
//    }
//
//    public void addList(Object item) {
//        this.mList.add(item);
//    }
}
