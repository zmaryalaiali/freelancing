package net.dkr.freelancing;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;


import com.google.android.material.tabs.TabLayout;

import net.dkr.freelancing.adapter.AdapterManageOrdersFragment;
import net.dkr.freelancing.fragments.SellerAboutFragment;
import net.dkr.freelancing.fragments.SellerGigFragment;
import net.dkr.freelancing.fragments.SellerReviewFragment;
import net.dkr.freelancing.model.UserModel;
import net.dkr.freelancing.util.AllURL;
import net.dkr.freelancing.util.RestApi;
import net.dkr.freelancing.util.RestSingleTon;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class SellerActivity extends AppCompatActivity {

    ViewPager viewPager2;
    ImageView ivBack, ivUser;
    TextView tvUserName, tvUserType;
    TabLayout tableLayout;
    AdapterManageOrdersFragment adapterManageOrdersFragment;
    String userId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller);

        userId = getIntent().getStringExtra("userId");
        Toolbar toolbar = findViewById(R.id.toolbar_seller);
        ivBack = findViewById(R.id.iv_seller_back);
        ivUser = findViewById(R.id.iv_seller);
        viewPager2 = findViewById(R.id.vp_seller);
        tableLayout = findViewById(R.id.tab_seller_layout);
        tvUserType = findViewById(R.id.tv_activity_seller_type);
        tvUserName = findViewById(R.id.tv_activity_seller_name);

        setUpViewPager(viewPager2);


        tableLayout.setupWithViewPager(viewPager2);

        tableLayout.setOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewPager2));

        new Thread(() -> {
            Retrofit retrofit = RestSingleTon.getRetrofit();
            RestApi api = retrofit.create(RestApi.class);
            String url = AllURL.BASE_URL + "users/" + userId;
            Call<UserModel> call = api.getUser(url);
            call.enqueue(new Callback<UserModel>() {
                @Override
                public void onResponse(Call<UserModel> call, Response<UserModel> response) {
                    if (response.isSuccessful()) {
                        if (response.body().getProfile() != null) {
                            UserModel model = response.body();
                            byte[] b = model.getProfile().getPhoto().getImg().getData().getData();
                            ivUser.setImageBitmap(BitmapFactory.decodeByteArray(b, 0, b.length));
                            tvUserName.setText(model.getName());
                            tvUserType.setText(model.getProfile().getLevel());
                        }
                    } else {
                        tvUserName.setText("some error " + response.errorBody());
                    }
                }

                @Override
                public void onFailure(Call<UserModel> call, Throwable throwable) {
                    tvUserName.setText(" dont Done " + throwable.getMessage());

                }
            });
        }).start();


//      for going previse page again
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        setSupportActionBar(toolbar);


    }


    private void setUpViewPager(ViewPager viewPager) {

        adapterManageOrdersFragment = new AdapterManageOrdersFragment(getSupportFragmentManager());
        adapterManageOrdersFragment.addFragment(new SellerAboutFragment(userId), "About");
        adapterManageOrdersFragment.addFragment(new SellerGigFragment(), "Gig");
        adapterManageOrdersFragment.addFragment(new SellerReviewFragment(), "Review");
        viewPager2.setAdapter(adapterManageOrdersFragment);


    }

    //for going back to home

}