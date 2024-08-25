package net.dkr.freelancing;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import net.dkr.freelancing.adapter.AdapterGig;
import net.dkr.freelancing.adapter.AdapterSellerSkill;
import net.dkr.freelancing.model.RecentModel;
import net.dkr.freelancing.util.AllURL;
import net.dkr.freelancing.util.RestApi;
import net.dkr.freelancing.util.RestSingleTon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class SearchActivity extends AppCompatActivity {

    RecyclerView rv_shop_by,rv_show_gigs;
//    List<SellerSkillModel> shop_by_list;
    List<RecentModel> gig_list;
    AdapterSellerSkill adapter_shop_by ;
    AdapterGig adapterGig ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

//        rv_shop_by=findViewById(R.id.rv_search_shop_by);
        rv_show_gigs=findViewById(R.id.rv_show_gigs);

//        shop_by_list=new ArrayList<>();
        String subID = getIntent().getStringExtra("subCategoryId");

        Retrofit retrofit = RestSingleTon.getRetrofit();
        RestApi restApi = retrofit.create(RestApi.class);
        String url = AllURL.BASE_URL+"users/all/gigs?subCategory="+subID;
        Call<RecentModel[]> call = restApi.getGigsBySubCategory(url);
        call.enqueue(new Callback<RecentModel[]>() {
            @Override
            public void onResponse(Call<RecentModel[]> call, Response<RecentModel[]> response) {
                if (response.isSuccessful()){
                    gig_list = new ArrayList<>(Arrays.asList(response.body()));
                    adapterGig = new AdapterGig(SearchActivity.this,gig_list);
                    rv_show_gigs.setAdapter(adapterGig);

                }
            }

            @Override
            public void onFailure(Call<RecentModel[]> call, Throwable throwable) {

            }
        });

//        rv_shop_by.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        rv_show_gigs.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

//        shop_by_list.add(new SellerSkillModel("style"));
//        shop_by_list.add(new SellerSkillModel("service includes"));
//        shop_by_list.add(new SellerSkillModel("seller level"));
//        shop_by_list.add(new SellerSkillModel("price"));
//        shop_by_list.add(new SellerSkillModel("Logo Option"));
//        shop_by_list.add(new SellerSkillModel("Budget"));

//        gig_list.add(new Gig_Model(R.drawable.busone,"3.3","111",true,11,"create, edit,redesign minimalist bussnise ..."));
//        gig_list.add(new Gig_Model(R.drawable.bustwo,"3.4","111",true,34,"create, minimalist bussnise ..."));

//        adapter_shop_by = new AdapterSellerSkill(this,shop_by_list);
//        rv_shop_by.setAdapter(adapter_shop_by);




    }
}