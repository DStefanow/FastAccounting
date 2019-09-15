package com.dobromir.stefanov.fastaccounting.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import com.dobromir.stefanov.fastaccounting.Interfaces.ItemClicked;
import com.dobromir.stefanov.fastaccounting.R;
import com.dobromir.stefanov.fastaccounting.ViewHolders.TransactionViewHolder;
import com.dobromir.stefanov.fastaccounting.Objects.*;


public class TransactionAdapter extends RecyclerView.Adapter<TransactionViewHolder> {
    private List<AccCategory> transactions;
    ItemClicked itemClicked;

    public TransactionAdapter(Context context, List<AccCategory> transactions) {
        itemClicked = (ItemClicked) context;
        this.transactions = transactions;
    }

    @NonNull
    @Override
    public TransactionViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_transactions, viewGroup, false);
        return new TransactionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TransactionViewHolder transactionViewHolder, int i) {
        if (this.transactions != null) {
            AccCategory currentCategory = transactions.get(i);
            transactionViewHolder.txtViewCategoryName.setText(currentCategory.getCategoryName());
        }

        /**
        AccTransaction accTransaction= transactions.get(i);

        transactionViewHolder.itemView.setTag(accTransaction);
        transactionViewHolder.txtViewCategoryName.setText(accTransaction.getCategoryId());
        transactionViewHolder.txtViewAmount.setText(String.valueOf(accTransaction.getAmount()));
        transactionViewHolder.txtViewNote.setText(accTransaction.getNote());

        if (accTransaction.getAccType().equals(AccountingType.INCOME)) {
            transactionViewHolder.imgViewType.setImageResource(R.drawable.ic_arrow_upward_green_24dp);
        } else {
            transactionViewHolder.imgViewType.setImageResource(R.drawable.ic_arrow_downward_red_24dp);
        }
         */
    }

    @Override
    public int getItemCount() {
        if (transactions != null) {
            return transactions.size();
        }

        return 0;
    }

    public void setTransactions(List<AccCategory> accCategories) {
        this.transactions = accCategories;
        notifyDataSetChanged();
    }
}
