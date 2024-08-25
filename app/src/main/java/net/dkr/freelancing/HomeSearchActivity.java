package net.dkr.freelancing;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import net.dkr.freelancing.adapter.AdapterRecent;
import net.dkr.freelancing.model.RecentModel;
import net.dkr.freelancing.util.RestApi;
import net.dkr.freelancing.util.RestSingleTon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class HomeSearchActivity extends AppCompatActivity {

    RecyclerView rvRecent;
    Retrofit retrofit;
    SearchView searchView;
    List<RecentModel> listRecent;
    AdapterRecent adapterRecent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home_search);
        rvRecent = findViewById(R.id.rv_home_recentView);
        searchView = findViewById(R.id.sv_home_gigs);

        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                checkSearch(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                checkSearch(newText);
                return true;
            }
        });


        retrofit = RestSingleTon.getRetrofit();

        rvRecent.setLayoutManager(new LinearLayoutManager(this));

        new Thread(new Runnable() {
            @Override
            public void run() {
                RestApi restApi = retrofit.create(RestApi.class);
                Call<RecentModel[]> call = restApi.getGets();
                call.enqueue(new Callback<RecentModel[]>() {
                    @Override
                    public void onResponse(Call<RecentModel[]> call, Response<RecentModel[]> response) {
                        if (response.isSuccessful()) {
                            listRecent = new ArrayList<>(Arrays.asList(response.body()));
                            adapterRecent = new AdapterRecent(getApplicationContext(), listRecent);
                            rvRecent.setAdapter(adapterRecent);
                        }
                    }

                    @Override
                    public void onFailure(Call<RecentModel[]> call, Throwable throwable) {
                        Toast.makeText(getApplicationContext(), "Error" + throwable.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }).start();


    }

    private void checkSearch(String str) {
        List<RecentModel> list = new ArrayList<>();
        if (listRecent.isEmpty()){
            Toast.makeText(this, "Empty", Toast.LENGTH_SHORT).show();
            return;
        }
        for (RecentModel model : listRecent){
            if (model.getCustomeTitle().toLowerCase().contains(str.toLowerCase())) {
                list.add(model);
                Toast.makeText(this, "new text" + str, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "new not" + str, Toast.LENGTH_SHORT).show();

            }
        }
//        for (int i = 0; i < listRecent.size(); i++) {
//
//        }
        if (list.isEmpty()){
            Toast.makeText(this, "the new list is empty", Toast.LENGTH_SHORT).show();
            adapterRecent.searchGig(list);
        }
        else {
//            Toast.makeText(this, "text is here", Toast.LENGTH_SHORT).show();
            adapterRecent.searchGig(list);
        }

    }
}