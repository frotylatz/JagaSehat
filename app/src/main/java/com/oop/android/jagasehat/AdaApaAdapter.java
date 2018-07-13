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

public class AdaApaAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;

    //List of images
    public int[] list_images = {
            R.drawable.nanyapink,
            R.drawable.jawabjilbab,
            R.drawable.sadarisalira,
    };

    public String[] list_desc = {
            "Dokter Ahyani, beberapa teman saya yang merasakan ada benjolan di payudaranya, mereka cemas dan bertanya,''Ada apa dengan payudara saya? Apakah benjolan ini bisa diobati?'' Bagaimana pengalaman dokter Ahyani saat itu?",
            "Begitu menyadari ada yang mencurigakan, saya segera periksa dan konsultasi ke dokter untuk memastikan apa masalahnya. Jadi, kebutusan ibu untuk periksa ke dokter sudah tepat dan kebanyakan benjolan yang terjadi pada payudara bukan kanker dan berhasil ditangani dengan baik.",
            ""
    };

    public AdaApaAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return list_images.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object o) {
        return view == (RelativeLayout) o;
    }

    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.layout_adaapa,container,false);

        ImageView adaapaImageView = view.findViewById(R.id.adaapaimage);
        TextView adaapaDialog = view.findViewById(R.id.dialogAdaapa);

        adaapaImageView.setImageResource(list_images[position]);
        adaapaDialog.setText(list_desc[position]);

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout)object);
    }

}
