package net.dkr.freelancing.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import net.dkr.freelancing.HomeSearchActivity;
import net.dkr.freelancing.R;
import net.dkr.freelancing.util.RestApi;
import net.dkr.freelancing.util.RestSingleTon;
import net.dkr.freelancing.adapter.AdapterPopular;
import net.dkr.freelancing.adapter.AdapterRecent;
import net.dkr.freelancing.adapter.SearchAdapter;
import net.dkr.freelancing.model.InspireModel;
import net.dkr.freelancing.model.PopularServiceModel;
import net.dkr.freelancing.model.RecentModel;
import net.dkr.freelancing.model.SearchModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class HomeFragment extends Fragment {

    ImageView ivSearch;
    RecyclerView rvPopular,rvRecent;
    List<PopularServiceModel> listPopular;
    List<RecentModel>listRecent;
    Retrofit retrofit;
    List<InspireModel> listInspire;

    List<SearchModel.Category> categoryList;
    SearchAdapter searchAdapter;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
     retrofit = RestSingleTon.getRetrofit();
//        listInspire = new ArrayList<>();
//        getAllList();
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvPopular = view.findViewById(R.id.rv_popular_view);
        rvRecent = view.findViewById(R.id.rv_recent_view);
        ivSearch = view.findViewById(R.id.iv_buyer_search);
//        rvInspire = view.findViewById(R.id.rv_inspire_view);

        new Thread(new Runnable() {
            @Override
            public void run() {
                        RestApi restApi = retrofit.create(RestApi.class);
                Call<RecentModel[]> call = restApi.getGets();
                call.enqueue(new Callback<RecentModel[]>() {
                    @Override
                    public void onResponse(Call<RecentModel[]> call, Response<RecentModel[]> response) {
                        if (response.isSuccessful()){
                            listRecent = new ArrayList<>(Arrays.asList(response.body()));
                            AdapterRecent adapterRecent = new AdapterRecent(getContext(),listRecent);
                            rvRecent.setAdapter(adapterRecent);
                        }
                    }
                    @Override
                    public void onFailure(Call<RecentModel[]> call, Throwable throwable) {
                        Toast.makeText(getContext(), "Error"+throwable.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                Retrofit retrofit = RestSingleTon.getRetrofit();
                RestApi api  = retrofit.create(RestApi.class);
                Call<SearchModel> call = api.getSearch();
                call.enqueue(new Callback<SearchModel>() {
                    @Override
                    public void onResponse(Call<SearchModel> call, Response<SearchModel> response) {
                        if (response.isSuccessful()){
                            if (response.body().getStatus().equals("success")){

                                rvPopular.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false) );
                                Toast.makeText(getContext(),(response.body().getStatus()), Toast.LENGTH_SHORT).show();
                                categoryList = new ArrayList<>(Arrays.asList(response.body().getCategories()));
                                AdapterPopular adapterPopular = new AdapterPopular(getContext(),categoryList);
                                rvPopular.setAdapter(adapterPopular);

                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<SearchModel> call, Throwable throwable) {
                        Toast.makeText(getContext() ,"nothing", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        }).start();
        ivSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), HomeSearchActivity.class);
                getActivity().startActivity(intent);
            }
        });

//        rvInspire.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false) );
        rvRecent.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false) );

//        AdapterInspire adapterInspire = new AdapterInspire(getContext(),listInspire);
//        AdapterPopular adapterPopular = new AdapterPopular(getContext(),listPopular);

//        rvPopular.setAdapter(adapterPopular);
//        rvInspire.setAdapter(adapterInspire);

    }

    private void getAllList(){
//        listInspire.add(new InspireModel(R.drawable.busone,R.drawable.star,R.drawable.heart,"inspired model"));
//        listInspire.add(new InspireModel(R.drawable.bustwo,R.drawable.star,R.drawable.heart,"Logo Design"));
//        listInspire.add(new InspireModel(R.drawable.busthree,R.drawable.star,R.drawable.heart,"Ali"));
//        listInspire.add(new InspireModel(R.drawable.busone,R.drawable.star,R.drawable.heart,"Development"));
//        listInspire.add(new InspireModel(R.drawable.bustwo,R.drawable.star,R.drawable.heart,"Logo Design"));
//        listInspire.add(new InspireModel(R.drawable.busthree,R.drawable.star,R.drawable.heart,"Greating"));

//        listRecent.add(new RecentModel(R.drawable.cardone,R.drawable.favorite,"MainText"));
//        listRecent.add(new RecentModel(R.drawable.cardtwo,R.drawable.favorite,"MainText"));
//        listRecent.add(new RecentModel(R.drawable.cardthree,R.drawable.favorite,"MainText"));
//        listRecent.add(new RecentModel(R.drawable.cardfour,R.drawable.favorite,"MainText"));
//        listRecent.add(new RecentModel(R.drawable.cardone,R.drawable.favorite,"MainText"));

        listPopular.add(new PopularServiceModel(R.drawable.one," Logo Design"));
        listPopular.add(new PopularServiceModel(R.drawable.two," Development"));
        listPopular.add(new PopularServiceModel(R.drawable.three," Logo Design"));
        listPopular.add(new PopularServiceModel(R.drawable.four,"development"));
        listPopular.add(new PopularServiceModel(R.drawable.five," Logo Design"));


    }
}