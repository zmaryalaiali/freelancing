package net.dkr.freelancing.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import net.dkr.freelancing.R;
import net.dkr.freelancing.adapter.AdapterGigOrder;
import net.dkr.freelancing.model.GigOrderModel;
import net.dkr.freelancing.util.AllURL;
import net.dkr.freelancing.util.RestApi;
import net.dkr.freelancing.util.RestSingleTon;
import net.dkr.freelancing.util.SharedText;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ActiveOrdersFragment extends Fragment {

    View view;
    RecyclerView rvActiveOrders;
    List<GigOrderModel> gigOrderModelList;
    AdapterGigOrder adapterGigOrder;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return  inflater.inflate(R.layout.fragment_active_orders_, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvActiveOrders =view.findViewById(R.id.rv_active_orders);

        rvActiveOrders.setLayoutManager(new LinearLayoutManager(getActivity()));
        SharedText sharedText = new SharedText(getContext());

        new Thread(()->{
            String userId = sharedText.getUserId();
            String url = AllURL.BASE_URL+"users/"+userId+"/manageorders";
            Retrofit retrofit = RestSingleTon.getRetrofit();
            RestApi api = retrofit.create(RestApi.class);
           Call<GigOrderModel[]> call = api.orderManagement(sharedText.getCookie(),url);
           call.enqueue(new Callback<GigOrderModel[]>() {
               @Override
               public void onResponse(Call<GigOrderModel[]> call, Response<GigOrderModel[]> response) {
                   if (response.isSuccessful()){
                       gigOrderModelList = new ArrayList<>(Arrays.asList(response.body()));

                       List<GigOrderModel> list = new ArrayList<>();
                       for (int i = 0; i < gigOrderModelList.size(); i++) {
                           if (gigOrderModelList.get(i).status.equals("active"));
                           list.add(gigOrderModelList.get(i));
                       }
                       adapterGigOrder = new AdapterGigOrder(getContext(), list);
                       Toast.makeText(getContext(), "done "+gigOrderModelList.size(), Toast.LENGTH_SHORT).show();

                       rvActiveOrders.setAdapter(adapterGigOrder);
                   }else {
                       Toast.makeText(getContext(), "not done "+ response.errorBody(),Toast.LENGTH_LONG).show();
                   }
               }

               @Override
               public void onFailure(Call<GigOrderModel[]> call, Throwable throwable) {
                   Toast.makeText(getContext(), "error "+throwable.getMessage(), Toast.LENGTH_LONG).show();
               }
           });

        }).start();
    }
}