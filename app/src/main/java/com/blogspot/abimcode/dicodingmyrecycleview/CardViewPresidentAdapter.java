package com.blogspot.abimcode.dicodingmyrecycleview;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.text.BreakIterator;
import java.util.ArrayList;

/**
 * Created by Abimanyu on 4/21/18.
 */

public class CardViewPresidentAdapter extends RecyclerView.Adapter<CardViewPresidentAdapter.CardViewViewHolder> {

    // Buat variable global untuk menampung contextnya

    private ArrayList<President> listPresident;
    private Context context;


    public CardViewPresidentAdapter(Context context) {

        // Inisialisasi

        this.context = context;
    }

    public ArrayList<President> getListPresident() {
        return listPresident;
    }

    public void setListPresident (ArrayList<President> listPresident) {
        this.listPresident = listPresident;
    }

    @Override
    public CardViewViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cardview_president, parent, false);
        CardViewViewHolder viewHolder = new CardViewViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CardViewViewHolder holder, int position) {

        President p = getListPresident().get(position);

        Glide.with(context)
                .load(p.getPhoto())
                .override(350, 550) // ngecrop gambar
                .into(holder.imgPhoto);
        holder.tvName.setText(p.getName());
        holder.tvRemarks.setText(p.getRemarks());

       holder.btnFavorite.setOnClickListener(new CustomOnItemClickListener(position, new CustomOnItemClickListener.OnItemClickCallback() {
            @Override
            public void onItemClicked(View view, int position) {
               //Toast.makeText(context, "Favorite" + getListPresident().get(position).getName(), Toast.LENGTH_SHORT).show();
                CardViewViewHolder viewViewHolder = (CardViewViewHolder) view.getTag();

                Intent intent = new Intent(context, Move.class);
                context.startActivity(intent);

            }

        }));

        holder.btnShare.setOnClickListener(new CustomOnItemClickListener(position, new CustomOnItemClickListener.OnItemClickCallback() {

            public void onItemClicked(View view, int position) {
                Toast.makeText(context, "Share" + getListPresident().get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        }));



    }


    // Menentukan jumlah item yang tampil
    @Override
    public int getItemCount() {
        return getListPresident().size();
    }

    public class CardViewViewHolder extends RecyclerView.ViewHolder {

        // Deklarasi Widget

        ImageView imgPhoto;
        TextView tvName;
        TextView tvRemarks;
        Button btnFavorite, btnShare;
        public CardViewViewHolder(View itemView) {
            super(itemView);

            // Inisialisasi widget

            imgPhoto = (ImageView) itemView.findViewById(R.id.img_item_photo);
            tvName = (TextView) itemView.findViewById(R.id.tv_item_name);
            tvRemarks = (TextView) itemView.findViewById(R.id.tv_item_remarks);
            btnFavorite = (Button) itemView.findViewById(R.id.btn_set_favorite);
            btnShare = (Button) itemView.findViewById(R.id.btn_set_share);
        }
    }
}

// Setelah ini buat class baru intuk handle button dengan nama CustomOnItrmClickLestener