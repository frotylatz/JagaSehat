package com.oop.android.jagasehat.fragment;


import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.oop.android.jagasehat.Contact;
import com.oop.android.jagasehat.ContactAdapter;
import com.oop.android.jagasehat.R;

import java.util.ArrayList;
import java.util.List;

import co.dift.ui.SwipeToAction;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentContact extends Fragment {

    RecyclerView recyclerView;
    ContactAdapter adapter;
    SwipeToAction swipeToAction;

    List<Contact> contact = new ArrayList<>();
    public FragmentContact() {
        // Required empty public constructor
    }

    public static FragmentContact newInstance(String param1, String param2) {
        FragmentContact fragment = new FragmentContact();
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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_contact, container, false);

        recyclerView = view.findViewById(R.id.recycler);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        adapter = new ContactAdapter(this.contact);
        recyclerView.setAdapter(adapter);

        swipeToAction = new SwipeToAction(recyclerView, new SwipeToAction.SwipeListener<Contact>() {
            @Override
            public boolean swipeLeft(final Contact itemData) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Uri gmmIntentUri = Uri.parse("geo:" + itemData.getKoordinat());
                        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                        mapIntent.setPackage("com.google.android.apps.maps");
                        startActivity(mapIntent);
                    }
                }, 0);
                return true;
            }

            @Override
            public boolean swipeRight(Contact itemData) {
                Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + itemData.getNomor()));
                startActivity(i);
                return true;
            }

            @Override
            public void onClick(Contact itemData) {
                displaySnackbar("Geser ke kanan untuk menelepon kontak ini.\nGeser ke kiri untuk membuka alamat.", null, null);
            }

            @Override
            public void onLongClick(Contact itemData){

            }

        });

        populate();

        // use swipeLeft or swipeRight and the elem position to swipe by code
        /*new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                swipeToAction.swipeRight(2);
            }
        }, 3000);*/

        return view;
    }

    private void populate() {
        this.contact.add(new Contact("Bandung Cancer Society", "https://www.facebook.com/BCSBandungCancerSociety", "081222120971",""));
        this.contact.add(new Contact("Yayasan Kesehatan Payudara Jawa Barat (YKP)", "Jl. Hegarmanah 3 Bandung 40141", "0222034313","-6.8819361,107.6012461?q=Jl.+Hegarmanah+No.3,+Hegarmanah,+Cidadap,+Kota+Bandung,+Jawa+Barat+40141"));
        this.contact.add(new Contact("Yayasan Kanker Indonesia (YKI)", "Jl. Kejaksaan No.43, Bandung 40112", "0224230240","-6.9060649,107.6055818?q=Indonesian+Cancer+Foundation"));
        this.contact.add(new Contact("BPJS Kesehatan Regional Jawa Barat", "Jl. Dr. Djundjunan No.144 PO BOX 1617 Bandung 40163", "(022) 2005892","-6.9124039,107.5866659?q=Deputy+Health+BPJS+West+Java"));
        this.contact.add(new Contact("BPJS Kesehatan Bandung", "Jl. Pelajar Pejuang 45 No.66 Bandung 40263", "0227317058","-6.9328387,107.6231097?q=BPJS+Kesehatan+Cabang+Bandung"));
        this.contact.add(new Contact("BPJS Kesehatan Soreang", "Jl. Terusan Alfathu No.6, Soreang, Kab. Bandung", "02288886276","-7.0296298,107.5242562?q=BPJS+Kesehatan+Cabang+Soreang"));
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

    /*private int removeContact(Contact contacts) {
        int pos = contact.indexOf(contacts);
        contact.remove(contacts);
        adapter.notifyItemRemoved(pos);
        return pos;
    }

    private void addContact(int pos, Contact contacts) {
        contact.add(pos, contacts);
        adapter.notifyItemInserted(pos);
    }*/

}
