package com.dobromir.stefanov.fastaccounting.Fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dobromir.stefanov.fastaccounting.Adapters.TransactionAdapter;
import com.dobromir.stefanov.fastaccounting.Objects.AccCategory;
import com.dobromir.stefanov.fastaccounting.R;
import com.dobromir.stefanov.fastaccounting.VIewModel.AccCategoryViewModel;

import java.util.List;


public class ListTransactionsFragment extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private TransactionAdapter transactionAdapter;
    private View view;

    private AccCategoryViewModel accCategoryViewModel;

    public ListTransactionsFragment() {

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        recyclerView = view.findViewById(R.id.list_transactions_rec_view);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this.getActivity());
        transactionAdapter = new TransactionAdapter(this.getActivity());

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(transactionAdapter);

        // Populate hardcoded data
        accCategoryViewModel = new ViewModelProvider(this.getActivity()).get(AccCategoryViewModel.class);
        accCategoryViewModel.getAllCategories().observe(this.getActivity(), new Observer<List<AccCategory>>() {
            @Override
            public void onChanged(List<AccCategory> accCategories) {
                transactionAdapter.setTransactions(accCategories);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_list_transactions, container, false);
        return view;
    }

}
