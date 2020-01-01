package com.example.application1;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GameAdapter extends RecyclerView.Adapter<GameAdapter.Holder> {
    private int displayWidth;
    private int size;
    private int pad;
    long start_time;
    long end_time;
    long taken_time;
    long seed = System.nanoTime();

    private Context mContext;
    private Handler mHandler;
    private List<Integer> Cards; // uniform index
    private List<Boolean> found; // uniform index
    private boolean itemSelected; // only 0, 1
    private Integer firstSelectedPos;
    private boolean everClick; // for start time

    public GameAdapter(Context c, int displayWidth) {
        mContext = c;
        mHandler = new Handler();
        this.displayWidth = displayWidth;
        Cards = new ArrayList<Integer>();
        for (int i=0; i<2; i++) {
            Cards.add(R.drawable.f12);
            Cards.add(R.drawable.f7);
        }
        found = new ArrayList<Boolean>();
        for (int j=0; j<Cards.size(); j++) {
            found.add(false);
        }
        itemSelected = false;
        Collections.shuffle(Cards, new Random(seed));
        size = displayWidth / 2;
        pad = 18;
        everClick = false;
    }

    @Override
    public long getItemId(int position) {
        return Cards.get(position);
    }

    public class Holder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public Holder(View view) {
            super(view);
            imageView = (ImageView) view.findViewById(R.id.gamecard);
            int pos = getAdapterPosition();
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!foundAll(found)) {
                        if (!everClick) {
                            everClick = true;
                            start_time = System.currentTimeMillis();
                        }
                        if (!itemSelected) {
                            int pos = getAdapterPosition();
                            if (pos != RecyclerView.NO_POSITION) {
                                int tmp = Cards.get(pos);
                                firstSelectedPos = pos;
                                imageView.setImageResource(tmp);
                            }
                            itemSelected = true;
                        } else {
                            int pos = getAdapterPosition();
                            if (pos != RecyclerView.NO_POSITION) {
                                int tmp = Cards.get(pos);
                                imageView.setImageResource(tmp);
                                if (compareId(pos, firstSelectedPos)) {
                                    found.set(pos, true);
                                    found.set(firstSelectedPos, true);
                                } else {
                                    System.out.println("here");
                                    mHandler.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {

                                        }
                                    }, 500);
                                    imageView.setImageResource(R.drawable.question);
                                }
                            }
                            itemSelected = false;
                        }
                    }
                }
            });
            imageView.setImageResource(R.drawable.question);
        }
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.gameview, parent, false);
        Holder holder = new Holder(view);
        holder.imageView.setImageResource(R.drawable.question);
        if (everClick) {
            end_time = System.currentTimeMillis();
            taken_time = (end_time-start_time)/(long)1000.0;
        }

        return holder;
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        int pos = position;
        int id = Cards.get(pos);
        holder.imageView.setLayoutParams(new RelativeLayout.LayoutParams(size, size));
        holder.imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        holder.imageView.setPadding(pad, pad, pad, pad);
    }

    @Override
    public int getItemCount() {
        return Cards.size();
    }

    public boolean foundAll(List<Boolean> found) {
        for (int i=0; i<found.size(); i++) {
            if (!found.get(i)) {
                return false;
            }
        }
        return true;
    }

    public boolean compareId(int pos1, int pos2) {
        if (Cards.get(pos1) == Cards.get(pos2)) {
            return true;
        }
        else {
            return false;
        }
    }
}
