package net.dkr.freelancing;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import net.dkr.freelancing.adapter.AdapterInspire;
import net.dkr.freelancing.adapter.AdapterPopular;
import net.dkr.freelancing.adapter.AdapterRecent;
import net.dkr.freelancing.auth.LoginActivity;
import net.dkr.freelancing.auth.SignupActivity;
import net.dkr.freelancing.model.InspireModel;
import net.dkr.freelancing.model.PopularServiceModel;
import net.dkr.freelancing.model.RecentModel;
import net.dkr.freelancing.model.SearchModel;
import net.dkr.freelancing.util.RestApi;
import net.dkr.freelancing.util.RestSingleTon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class AppHomeActivity extends AppCompatActivity {

    RecyclerView rvPopular,rvRecent,rvInspire;

    List<SearchModel.Category> categoryList;
    List<RecentModel>listRecent;
    List<InspireModel> listInspire;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_home);
        rvInspire = findViewById(R.id.rv_appHome_inspire_view);
        rvRecent = findViewById(R.id.rv_appHome_recent_view);
        rvPopular = findViewById(R.id.rv_appHome_popular_view);

        listRecent = new ArrayList<>();
        listInspire = new ArrayList<>();
//        listPopular = new ArrayList<>();
        getAllList();


        new Thread(new Runnable() {
            @Override
            public void run() {
                Retrofit retrofit = RestSingleTon.getRetrofit();
                RestApi restApi = retrofit.create(RestApi.class);
                Call<RecentModel[]> call = restApi.getGets();
                call.enqueue(new Callback<RecentModel[]>() {
                    @Override
                    public void onResponse(Call<RecentModel[]> call, Response<RecentModel[]> response) {
                        if (response.isSuccessful()){
                            listRecent = new ArrayList<>(Arrays.asList(response.body()));
                            AdapterRecent adapterRecent = new AdapterRecent(AppHomeActivity.this,listRecent);
                            rvRecent.setAdapter(adapterRecent);
                        }
                    }
                    @Override
                    public void onFailure(Call<RecentModel[]> call, Throwable throwable) {
                        Toast.makeText(AppHomeActivity.this, "Error"+throwable.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }).start();

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                Retrofit retrofit = RestSingleTon.getRetrofit();
//                RestApi api  = retrofit.create(RestApi.class);
//                Call<SearchModel> call = api.getSearch();
//                call.enqueue(new Callback<SearchModel>() {
//                    @Override
//                    public void onResponse(Call<SearchModel> call, Response<SearchModel> response) {
//                        if (response.isSuccessful()){
//                            if (response.body().getStatus().equals("success")){
//
//                                rvPopular.setLayoutManager(new LinearLayoutManager(AppHomeActivity.this, LinearLayoutManager.HORIZONTAL, false) );
//                                Toast.makeText(AppHomeActivity.this,(response.body().getStatus()), Toast.LENGTH_SHORT).show();
//                                categoryList = new ArrayList<>(Arrays.asList(response.body().getCategories()));
//                                AdapterPopular adapterPopular = new AdapterPopular(AppHomeActivity.this,categoryList);
//                                rvPopular.setAdapter(adapterPopular);
//
//                            }
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Call<SearchModel> call, Throwable throwable) {
//                        Toast.makeText(AppHomeActivity.this ,"nothing", Toast.LENGTH_SHORT).show();
//                    }
//                });
//
//            }
//        }).start();


        rvInspire.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false) );
        rvRecent.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false) );

        rvPopular.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false) );

//        AdapterInspire adapterInspire = new AdapterInspire(this,listInspire);
//        AdapterRecent adapterRecent = new AdapterRecent(this,listRecent);
//        AdapterPopular adapterPopular = new AdapterPopular(this,listPopular);

//        rvPopular.setAdapter(adapterPopular);
//        rvRecent.setAdapter(adapterRecent);
//        rvInspire.setAdapter(adapterInspire);

    }

    public void goToSignUp(View view){

        Toast.makeText(this, "goto", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, ChosserActivity.class);
        startActivity(intent);
    }
    public void goToSignIn(View view){

        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);

        Toast.makeText(this, "goto", Toast.LENGTH_SHORT).show();

    }


    private void getAllList(){
        listInspire.add(new InspireModel(R.drawable.busone,R.drawable.star,R.drawable.heart,"inspired model"));
        listInspire.add(new InspireModel(R.drawable.bustwo,R.drawable.star,R.drawable.heart,"Logo Design"));
        listInspire.add(new InspireModel(R.drawable.busthree,R.drawable.star,R.drawable.heart,"Ali"));
        listInspire.add(new InspireModel(R.drawable.busone,R.drawable.star,R.drawable.heart,"Development"));
        listInspire.add(new InspireModel(R.drawable.bustwo,R.drawable.star,R.drawable.heart,"Logo Design"));
        listInspire.add(new InspireModel(R.drawable.busthree,R.drawable.star,R.drawable.heart,"Greating"));

//        listRecent.add(new RecentModel(R.drawable.cardone,R.drawable.favourite,"MainText"));
//        listRecent.add(new RecentModel(R.drawable.cardtwo,R.drawable.favourite,"MainText"));
//        listRecent.add(new RecentModel(R.drawable.cardthree,R.drawable.favourite,"MainText"));
//        listRecent.add(new RecentModel(R.drawable.cardfour,R.drawable.favourite,"MainText"));
//        listRecent.add(new RecentModel(R.drawable.cardone,R.drawable.favourite,"MainText"));

//        listPopular.add(new PopularServiceModel(R.drawable.one," Logo Design"));
//        listPopular.add(new PopularServiceModel(R.drawable.two," Development"));
//        listPopular.add(new PopularServiceModel(R.drawable.three," Logo Design"));
//        listPopular.add(new PopularServiceModel(R.drawable.four,"development"));
//        listPopular.add(new PopularServiceModel(R.drawable.five," Logo Design"));


    }
}