package com.oop.android.jagasehat;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Asus on 11/07/2018.
 */

public class DukunganAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;

    //List of images
    public int[] list_images = {
            R.drawable.taujilbab,
            R.drawable.taujilbabzoom
    };

    public String[] list_title = {
            "PENTING UNTUK DIINGAT",
            ""
    };

    public String[] list_desc = {
            "Dukungan tidak hanya dari suami dan keluarga, bisa juga dari sahabat atau orang yang peduli pada Ibu.",
            "Selain suami, anak-anak, atau keluarga besar, kira-kira siapa lagi yang bisa membantu Ibu? Ibu bisa menghubung mereka dan sampaikan harapan Ibu"
    };

    public DukunganAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return list_images.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object o) {
        return view == o;
    }

    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.layout_dukungan,container,false);

        ImageView dukunganImageView = view.findViewById(R.id.imageDukungan);
        TextView dukunganDesc = view.findViewById(R.id.descDukungan);
        TextView titleDesc = view.findViewById(R.id.titleDukungan);

        dukunganImageView.setImageResource(list_images[position]);
        dukunganDesc.setText(list_desc[position]);
        titleDesc.setText(list_title[position]);

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout)object);
    }

}
