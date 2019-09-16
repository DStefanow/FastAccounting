package com.dobromir.stefanov.fastaccounting.ViewHolders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dobromir.stefanov.fastaccounting.R;

public class TransactionViewHolder extends RecyclerView.ViewHolder {
    public ImageView imgViewType;
    public TextView txtViewCategoryName, txtViewAmount, txtViewNote;

    public TransactionViewHolder(@NonNull View itemView) {
        super(itemView);

        //imgViewType = itemView.findViewById(R.id.imgViewType);
        txtViewCategoryName = itemView.findViewById(R.id.txtViewCategoryName);
        //txtViewAmount = itemView.findViewById(R.id.txtViewAmount);
        //txtViewNote = itemView.findViewById(R.id.txtViewNote);
    }
}
