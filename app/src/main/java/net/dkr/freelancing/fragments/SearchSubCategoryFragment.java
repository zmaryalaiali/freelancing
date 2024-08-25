package net.dkr.freelancing.fragments;

import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import net.dkr.freelancing.R;
import net.dkr.freelancing.util.SharedText;
import net.dkr.freelancing.adapter.AdapterSearchSubCategory;
import net.dkr.freelancing.model.SearchModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchSubCategoryFragment extends Fragment {

    List<SearchModel.SubCategory> list;
    AdapterSearchSubCategory adapterSearchSubCategory;
    RecyclerView rvSearch;
    ImageView back;

    boolean isSearch;

    public SearchSubCategoryFragment(SearchModel.SubCategory[] subCategories) {
        this.list = new ArrayList<>(Arrays.asList(subCategories));

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        SharedText sharedText = new SharedText(getContext());
        isSearch = sharedText.getSearch();
        return inflater.inflate(R.layout.fragment_search_sub_category, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvSearch = view.findViewById(R.id.rv_search_subCategory);
        back = view.findViewById(R.id.iv_subCategory_back);


        onBack();
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchBack();
            }
        });
        rvSearch.setLayoutManager(new LinearLayoutManager(getContext()));

        adapterSearchSubCategory = new AdapterSearchSubCategory(getContext(), list);
        rvSearch.setAdapter(adapterSearchSubCategory);
    }


    private void onBack() {
        requireActivity().getOnBackPressedDispatcher().addCallback(new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                if (isEnabled()) {
                    if (isSearch) {
                        Toast.makeText(getContext(), "Go back", Toast.LENGTH_SHORT).show();
                        setEnabled(false);
                        FragmentManager manager = ((AppCompatActivity) getContext()).getSupportFragmentManager();
                        FragmentTransaction transaction = manager.beginTransaction();
                        Fragment fragment = new HomeFragment();
                        transaction.add(R.id.frameLayout_home, fragment, "searchsubcategory").replace(R.id.frameLayout_home, fragment).commit();
                    } else {
                        Toast.makeText(getContext(), "Go back", Toast.LENGTH_SHORT).show();
                        setEnabled(false);
                        FragmentManager manager = ((AppCompatActivity) getContext()).getSupportFragmentManager();
                        FragmentTransaction transaction = manager.beginTransaction();
                        Fragment fragment = new SearchFragment();
                        transaction.add(R.id.frameLayout_home, fragment, "searchsubcategory").replace(R.id.frameLayout_home, fragment).commit();
                    }

                }

            }
        });
    }

    public void searchBack() {

        if (isSearch){
            FragmentManager manager = ((AppCompatActivity) getContext()).getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            Fragment fragment = new HomeFragment();
            transaction.add(R.id.frameLayout_home, fragment, "searchsubcategory").replace(R.id.frameLayout_home, fragment).commit();
        }else {
            FragmentManager manager = ((AppCompatActivity) getContext()).getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            Fragment fragment = new SearchFragment();
            transaction.add(R.id.frameLayout_home, fragment, "searchsubcategory").replace(R.id.frameLayout_home, fragment).commit();
        }

    }


}