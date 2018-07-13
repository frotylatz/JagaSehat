package com.oop.android.jagasehat.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.oop.android.jagasehat.R;



/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentAbout extends Fragment {

    Button btnShare;

    public FragmentAbout() {
        // Required empty public constructor
    }

    public static FragmentAbout newInstance(String param1, String param2) {
        FragmentAbout fragment = new FragmentAbout();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_about, container, false);
        btnShare = view.findViewById(R.id.shareButton);

        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentShare = new Intent("android.intent.action.SEND");
                intentShare.setType("text/plain");
                intentShare.putExtra("android.intent.extra.SUBJECT", "Saya menggunakan JagaSehat");
                intentShare.putExtra("android.intent.extra.TEXT", getText(R.string.descApp) + "\nAplikasinya dapat anda unduh di pranala berikut: bit.ly/2ud2CR1");
                getActivity().startActivity(Intent.createChooser(intentShare, "Bagikan"));
            }
        });

        /*btnTwitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TweetComposer.Builder builder = new TweetComposer.Builder(getContext())
                        .text("JagaSehat");
                builder.show();
            }
        });*/

        return view;
    }



}
