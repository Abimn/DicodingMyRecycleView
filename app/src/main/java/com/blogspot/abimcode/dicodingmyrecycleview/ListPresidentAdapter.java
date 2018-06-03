package com.blogspot.abimcode.dicodingmyrecycleview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by Abimanyu on 4/20/18.
 */

// TODO 6 membuat adaptelist, yang akan memformat bagaimana tiap elemen dari koleksi yang kita punya ditampilkan, ( Setelah ini memodifikasi di MainActivity )
public class ListPresidentAdapter extends RecyclerView.Adapter<ListPresidentAdapter.CategoryViewHolder> {

    /** Contex meberikan akses atas application state, dia memperbolehkan activity, fragment, dan service
    untuk mengakses file, gambar, theme/style, direktori eksternal **/
    private Context context;

    public ArrayList<President> getListPresident() {
        return listPresident;
    }

    public void setListPresident(ArrayList<President> listPresident) {
        this.listPresident = listPresident;
    }

    private ArrayList<President> listPresident;

    public ListPresidentAdapter(Context context) {
        this.context = context;
    }


    @Override
    public void onBindViewHolder(CategoryViewHolder holder, int position) {
        holder.tvName.setText(getListPresident().get(position).getName());
        holder.tvRemarks.setText(getListPresident().get(position).getRemarks());

        // Glide adalah library yang ngeload image pada android dengan segudang fungsi2 yang keren
        Glide.with(context)
                .load(getListPresident().get(position).getPhoto())
                .override(55, 55)
                .crossFade()
                .into(holder.imgPhoto);
    }


    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // LayoutInflater adalah class untuk membuat java object view dari layout yang kita buat di xml.
        View itemRow = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_president, parent, false);
        return new CategoryViewHolder(itemRow);
    }

    @Override
    public int getItemCount() {
        return getListPresident().size();
    }

    class CategoryViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvRemarks;
        ImageView imgPhoto;

        public CategoryViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tv_item_name);
            tvRemarks = (TextView) itemView.findViewById(R.id.tv_item_remarks);
            imgPhoto = (ImageView) itemView.findViewById(R.id.img_item_photo);
        }
    }
}

    /*  ViewHolder untuk meningkatkan performa dan efisiensi listView.
        Jika kita membuat aplikasi android dengan ListView tanpa menggunakan ViewHolder,
        salah satu masalah terbesarnya performa dan efisiensi. Karena cara kerja
        dasar ListView tanpa ViewHolder ini akan melakukan pemanggilan berulang untuk setiap
        item data menggunakan findViewById(). Yang artinya ini sangat mempengaruhi performa
        dari aplikasi saat meload data. Gampangnya gini, misalnya ketika Adapter mengembalikan nilai
        untuk di tampilkan, kita harus melakukan pencarian “by Id” untuk elemen yang baru agar terus update secara terus menerus  */

