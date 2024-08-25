package net.dkr.freelancing.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import net.dkr.freelancing.R;
import net.dkr.freelancing.util.RestApi;
import net.dkr.freelancing.util.RestSingleTon;
import net.dkr.freelancing.adapter.SearchAdapter;
import net.dkr.freelancing.model.SearchModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class SearchFragment extends Fragment {
    private RecyclerView rvSearch;
    private Context context;
    List<SearchModel.Category> categoryList;
    private SearchView searchView;
    SearchAdapter searchAdapter;

    View view = null;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_search, container, false);

        searchView=view.findViewById(R.id.sv_category);
        return  view;

    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvSearch = view.findViewById(R.id.rv_category);
        rvSearch.setLayoutManager(new LinearLayoutManager(context));
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                filterList(newText);
                return true;
            }
        });

        Retrofit retrofit = RestSingleTon.getRetrofit();
       RestApi api  = retrofit.create(RestApi.class);
        Call<SearchModel> call = api.getSearch();
        call.enqueue(new Callback<SearchModel>() {
            @Override
            public void onResponse(Call<SearchModel> call, Response<SearchModel> response) {
                if (response.isSuccessful()){
                    if (response.body().getStatus().equals("success")){

                        Toast.makeText(context,(response.body().getStatus()), Toast.LENGTH_SHORT).show();
                        categoryList = new ArrayList<>(Arrays.asList(response.body().getCategories()));
                        searchAdapter = new SearchAdapter(context,categoryList);
                        rvSearch.setAdapter(searchAdapter);

                    }
                }
            }

            @Override
            public void onFailure(Call<SearchModel> call, Throwable throwable) {
                Toast.makeText(context ,"nothing", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void filterList(String text) {

//        List<SearchModel>filterdList=new ArrayList<>();
//        for (SearchModel searchedData: list)
//        {
//            if (searchedData.getCategoryName().toLowerCase().contains(text.toLowerCase())){
//
//                filterdList.add(searchedData);
//            }
//        }
//        if (filterdList.isEmpty())
//        {
//            Toast.makeText(context, "No Data Found", Toast.LENGTH_SHORT).show();
//        }
//        else {
//
//            searchAdapter.setFilterdList(filterdList);
//
//        }

    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }
}