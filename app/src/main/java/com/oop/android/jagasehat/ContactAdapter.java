package com.oop.android.jagasehat;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import co.dift.ui.SwipeToAction;

/**
 * Created by Asus on 20/06/2018.
 */

public class ContactAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Contact> items;


    /** References to the views for each data item **/
    public class ContactViewHolder extends SwipeToAction.ViewHolder<Contact> {
        public TextView kelompokView;
        public TextView nomorView;
        public TextView alamatView;

        public ContactViewHolder(View v) {
            super(v);

            kelompokView = v.findViewById(R.id.kelompok);
            nomorView = v.findViewById(R.id.nomor);
            alamatView = v.findViewById(R.id.alamat);
        }
    }

    /** Constructor **/
    public ContactAdapter(List<Contact> items) {
        this.items = items;
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.contact_view, parent, false);

        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Contact item = items.get(position);
        ContactViewHolder vh = (ContactViewHolder) holder;
        vh.kelompokView.setText(item.getKelompok());
        vh.nomorView.setText(item.getNomor());
        vh.alamatView.setText(item.getAlamat());
        vh.data = item;
    }
}
