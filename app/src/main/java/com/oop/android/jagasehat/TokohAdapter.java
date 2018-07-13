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
 * Created by Asus on 14/06/2018.
 */

public class TokohAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;

    //List of images
    public int[] list_images = {
            R.drawable.bapa,
            R.drawable.ibu
    };

    public String[] list_heading = {
            "dr. Drajat R Suardi, Sp.B (K) Onk., FICS",
            "dr. Ahyani Raksanegara, M.Kes"
    };

    public String[] list_desc = {
            "Dokter Drajat merupakan dokter spesialis bedah onkologi Rumah Sakit Hasan Sadikin (RSHS) Bandung. Beliau juga pernah menjabat sebagai PP Perhimpunan Onkologi Indonesia Periode tahun 2010-2014",
            "Dokter yang pernah terdiagnosis kanker payudara namun telah berhasil menjalani seluruh prosedur pengobatan sehingga mampu kembali beraktivitas secara normal. Saat ini Dokter Ahyani merupakan Kepala Dinas Kesehatan Kota Bandung"
    };

    public TokohAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return list_heading.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object o) {
        return view == (RelativeLayout) o;
    }

    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.layout_tokoh,container,false);

        ImageView tokohImageView = view.findViewById(R.id.tokoh1);
        TextView tokohNama = view.findViewById(R.id.namaTokoh1);
        TextView tokohDesc = view.findViewById(R.id.descTokoh1);

        tokohImageView.setImageResource(list_images[position]);
        tokohNama.setText(list_heading[position]);
        tokohDesc.setText(list_desc[position]);

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout)object);
    }

}
