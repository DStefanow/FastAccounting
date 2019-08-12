package com.dobromir.stefanov.fastaccounting.ViewHolders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.dobromir.stefanov.fastaccounting.R;

public class TransactionViewHolder extends RecyclerView.ViewHolder {
    public ImageView imgViewType;
    public TextView txtViewCategoryName, txtViewAmount, txtViewNote;

    public TransactionViewHolder(@NonNull View itemView) {
        super(itemView);

        imgViewType = itemView.findViewById(R.id.imgViewType);
        txtViewCategoryName = itemView.findViewById(R.id.txtVIewCategoryName);
        txtViewAmount = itemView.findViewById(R.id.txtViewAmount);
        txtViewNote = itemView.findViewById(R.id.txtViewNote);
    }
}
