package net.dkr.freelancing.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.dkr.freelancing.R;
import net.dkr.freelancing.adapter.AdapterSellerGig;
import net.dkr.freelancing.model.SellerGigModel;


import java.util.ArrayList;
import java.util.List;


public class SellerGigFragment extends Fragment {

    RecyclerView recyclerView;
    List<SellerGigModel> list;
    AdapterSellerGig adapterSellerGig ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_seller_gig, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.rv_seller_gig);
        adapterSellerGig = new AdapterSellerGig(getContext(),list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapterSellerGig);

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        list = new ArrayList<>();
        list.add(new SellerGigModel("not rated yet","Create a mobile app with me ",R.drawable.bustwo,"21"));
        list.add(new SellerGigModel("not rated yet","Create a mobile app with me ",R.drawable.bustwo,"21"));
    }
}