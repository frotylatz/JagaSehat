package com.oop.android.jagasehat.fragment;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.TextView;

import com.oop.android.jagasehat.MateriAdaapaActivity;
import com.oop.android.jagasehat.MateriDukunganActivity;
import com.oop.android.jagasehat.MateriTokohActivity;
import com.oop.android.jagasehat.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentMateri extends Fragment {
    private Button materi1, materi2, materi3, materi4;
    private AlphaAnimation buttonClick = new AlphaAnimation(1F, 0.2F);

    public FragmentMateri() {
        // Required empty public constructor
    }

    public static FragmentMateri newInstance(String param1, String param2) {
        FragmentMateri fragment = new FragmentMateri();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        buttonClick.setDuration(50);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_materi, container, false);

        materi1 = view.findViewById(R.id.btnMateri1);
        materi1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(buttonClick);
                Intent intent = new Intent(getActivity(), MateriTokohActivity.class);
                startActivity(intent);
            }
        });

        materi2 = view.findViewById(R.id.btnMateri2);
        materi2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(buttonClick);
                Intent intent = new Intent(getActivity(), MateriAdaapaActivity.class);
                startActivity(intent);
            }
        });

        materi3 = view.findViewById(R.id.btnMateri3);
        materi3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(buttonClick);
                displaySnackbar("Konten untuk materi ini belum tersedia", null, null);
            }
        });

        materi4 = view.findViewById(R.id.btnMateri4);
        materi4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(buttonClick);
                Intent intent = new Intent(getActivity(), MateriDukunganActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }

    private void displaySnackbar(String text, String actionName, View.OnClickListener action) {
        Snackbar snack = Snackbar.make(getActivity().findViewById(android.R.id.content), text, Snackbar.LENGTH_LONG)
                .setAction(actionName, action);

        View v = snack.getView();
        v.setBackgroundColor(getResources().getColor(R.color.color2));
        ((TextView) v.findViewById(android.support.design.R.id.snackbar_text)).getResources().getColor(R.color.color1);
        ((TextView) v.findViewById(android.support.design.R.id.snackbar_action)).setTextColor(Color.BLACK);

        snack.show();
    }
}
