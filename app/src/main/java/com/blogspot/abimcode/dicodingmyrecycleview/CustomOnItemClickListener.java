package com.blogspot.abimcode.dicodingmyrecycleview;

import android.view.View;

/**
 * Created by Abimanyu on 4/22/18.
 */

public class CustomOnItemClickListener implements View.OnClickListener {
    private int position;
    private OnItemClickCallback onItemClickCallback;
    public CustomOnItemClickListener(int position, OnItemClickCallback onItemClickCallback) {
        this.position = position;
        this.onItemClickCallback = onItemClickCallback;
    }

    public void onClick(View view) {
        onItemClickCallback.onItemClicked(view, position);
    }
    public interface  OnItemClickCallback {
        void onItemClicked(View view, int position);
    }

}
