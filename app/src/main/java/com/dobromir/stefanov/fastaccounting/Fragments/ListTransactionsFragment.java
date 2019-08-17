package com.dobromir.stefanov.fastaccounting.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dobromir.stefanov.fastaccounting.Adapters.TransactionAdapter;
import com.dobromir.stefanov.fastaccounting.ApplicationCore;
import com.dobromir.stefanov.fastaccounting.R;

public class ListTransactionsFragment extends Fragment {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter transactionAdapter;
    View view;

    public ListTransactionsFragment() {

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        recyclerView = view.findViewById(R.id.list_transactions);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this.getActivity());
        transactionAdapter = new TransactionAdapter(this.getActivity(), ApplicationCore.accTransactions);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(transactionAdapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_list_transactions, container, false);
        return view;
    }

}
