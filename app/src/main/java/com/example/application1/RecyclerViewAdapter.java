package com.example.application1;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Parcelable;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.Holder> {
    private Context context;
//    private List<String> list = new ArrayList<>();
    private  List<Imagelist> mThumbIds;
    private int displayWidth;
    private int size;
    private int pad;

    public RecyclerViewAdapter(Context context, int displayWidth) {//List<String> list) {
        this.context = context;
        mThumbIds = new ArrayList<Imagelist>();
        mThumbIds.add(new Imagelist(R.drawable.f1, ""));
        mThumbIds.add(new Imagelist(R.drawable.f2, ""));
        mThumbIds.add(new Imagelist(R.drawable.f3, ""));
        this.displayWidth = displayWidth;
        size = displayWidth/3;
        pad = 8;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.clickview, parent, false);
        Holder holder = new Holder(view);

        int position = holder.getAdapterPosition();
        if (position != RecyclerView.NO_POSITION) {
//                        Object tmp = mThumbIds.get(position);
            Imagelist tmp = mThumbIds.get(position);
            if (tmp.imageId != 0) {
                holder.imageView.setImageResource(tmp.imageId);
            } else {
                holder.imageView.setImageURI(Uri.parse(tmp.imageUri));
            }
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        int pos = position;
//        Object tmp = mThumbIds.get(position);
        Imagelist tmp = mThumbIds.get(position);
        if (tmp.imageId != 0) {
            holder.imageView.setImageResource(tmp.imageId);
        }
        else {
            holder.imageView.setImageURI(Uri.parse(tmp.imageUri));
        }
//        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) holder.imageView.getLayoutParams();
//        layoutParams.height = size;
//        layoutParams.width = size;
//        holder.imageView.setLayoutParams(layoutParams);
        holder.imageView.setLayoutParams(new RelativeLayout.LayoutParams(size, size));
        holder.imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        holder.imageView.setPadding(pad, pad, pad, pad);
    }

    @Override
    public int getItemCount() {
        return mThumbIds.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public Holder(View view) {
            super(view);
            imageView = (ImageView) view.findViewById(R.id.imageviewrecycle);
            int pos = getAdapterPosition();
            if (pos != RecyclerView.NO_POSITION) {
                Imagelist il = mThumbIds.get(pos);
                if (il.imageId != 0) {
                    imageView.setImageResource(il.imageId);
                }
                else {
                    imageView.setImageURI(Uri.parse(il.imageUri));
                }
            }
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
//                        Object tmp = mThumbIds.get(position);
                        Imagelist tmp = mThumbIds.get(position);
                        if (tmp.imageId != 0) {
//                            ImageClickListener imageViewClickListner_int
//                                    = new ImageClickListener(context, tmp.imageId, "", mThumbIds);
//                            imageView.setOnClickListener(imageViewClickListner_int);
                            imageView.setImageResource(tmp.imageId);
                        } else {
////                            ImageClickListener imageViewClickListner_str
//                                    = new ImageClickListener(context, 0, tmp.imageUri, mThumbIds);
//                            imageView.setOnClickListener(imageViewClickListner_str);
                            imageView.setImageURI(Uri.parse(tmp.imageUri));
                        }
                        Intent intent = new Intent(context, ImageActivity.class);
                        intent.putExtra("image ID", tmp.imageId);
                        intent.putExtra("image URI", tmp.imageUri);
                        intent.putParcelableArrayListExtra("image List", (ArrayList<? extends Parcelable>) mThumbIds);
                        context.startActivity(intent);
                    }

//                        switch (tmp.getClass().getSimpleName()) {
//                            case "Integer":
//                                ImageClickListener imageViewClickListner_int
//                                        = new ImageClickListener(context, (int)tmp, "");
//                                imageView.setOnClickListener(imageViewClickListner_int);
//                                imageView.setImageResource((int)tmp);
//                                break;
//                            case "String":
//                                ImageClickListener imageViewClickListner_str
//                                        = new ImageClickListener(context, 0, (String)tmp);
//                                imageView.setOnClickListener(imageViewClickListner_str);
//                                imageView.setImageURI(Uri.parse((String)tmp));
//                                break;
//                        }

                }
            });
        }
    }
    public void addList(String o) {
        mThumbIds.add(new Imagelist(0, o));
    }
}
