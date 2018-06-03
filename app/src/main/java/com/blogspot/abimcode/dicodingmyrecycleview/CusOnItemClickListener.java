package com.blogspot.abimcode.dicodingmyrecycleview;

import android.view.View;

/**
 * Created by Abimanyu on 4/22/18.
 */

class CusOnItemClickListener implements View.OnClickListener {

    private int position;
    private OnItemClickCallback onItemClickCallback;
    public CusOnItemClickListener(int position, OnItemClickCallback onItemClickCallback) {
        this.position = position;
        this.onItemClickCallback =  onItemClickCallback;
    }

    public CusOnItemClickListener(int position, CustomOnItemClickListener.OnItemClickCallback onItemClickCallback) {

    }


    public void onClick(View view) {
        onItemClickCallback.onItemClicked(view, position);
    }
    public interface  OnItemClickCallback {
        void onItemClicked(View view, int position);
    }
    }

