package net.dkr.freelancing;

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

import net.dkr.freelancing.adapter.SearchAdapter;
import net.dkr.freelancing.model.SearchModel;

import java.util.ArrayList;
import java.util.List;


public class SearchFragment extends Fragment {
private RecyclerView rvSearch;
private Context context;
List<SearchModel> list;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        list = new ArrayList<>();
        list.add(new SearchModel("Logo And Card Desing","Logo Design and Development ",R.drawable.search));

        list.add(new SearchModel("Logo And Card Desing","Logo Design and Development ",R.drawable.search));
        list.add(new SearchModel("Logo And Card Desing","Logo Design and Development ",R.drawable.search));
        list.add(new SearchModel("Logo And Card Desing","Logo Design and Development ",R.drawable.search));
        list.add(new SearchModel("Logo And Card Desing","Logo Design and Development ",R.drawable.search));
        list.add(new SearchModel("Logo And Card Desing","Logo Design and Development ",R.drawable.search));
        list.add(new SearchModel("Logo And Card Desing","Logo Design and Development ",R.drawable.search));
        list.add(new SearchModel("Logo And Card Desing","Logo Design and Development ",R.drawable.search));
        list.add(new SearchModel("Logo And Card Desing","Logo Design and Development ",R.drawable.search));
        list.add(new SearchModel("Logo And Card Desing","Logo Design and Development ",R.drawable.search));
        list.add(new SearchModel("Logo And Card Desing","Logo Design and Development ",R.drawable.search));
        list.add(new SearchModel("Logo And Card Desing","Logo Design and Development ",R.drawable.search));
        list.add(new SearchModel("Logo And Card Desing","Logo Design and Development ",R.drawable.search));
        list.add(new SearchModel("Logo And Card Desing","Logo Design and Development ",R.drawable.search));
        list.add(new SearchModel("Logo And Card Desing","Logo Design and Development ",R.drawable.search));
        list.add(new SearchModel("Logo And Card Desing","Logo Design and Development ",R.drawable.search));
        rvSearch = view.findViewById(R.id.rv_category);
        rvSearch.setLayoutManager(new LinearLayoutManager(context));
        SearchAdapter adapter = new SearchAdapter(list,context);
        rvSearch.setAdapter(adapter);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }
}