package com.dobromir.stefanov.fastaccounting.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
        transactionAdapter = new TransactionAdapter(this.getActivity(), null);

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
