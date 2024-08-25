package net.dkr.freelancing;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import net.dkr.freelancing.adapter.SpinnerCategory;
import net.dkr.freelancing.model.JobBuyerModel;
import net.dkr.freelancing.model.JobCreateModel;
import net.dkr.freelancing.model.SearchModel;
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

public class CreateJobActivity extends AppCompatActivity {

    EditText etTitle, etBudget, etDelivery, etDesc;
    Spinner spinnerCategory, spinnerSellerLevel;
    Button btnJobPost;
    ArrayList<SearchModel.Category> categoryList = null;
    List<String> sellerList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_job);
        etTitle = findViewById(R.id.et_job_post_title);
        etBudget = findViewById(R.id.et_job_post_budget);
        etDelivery = findViewById(R.id.et_job_post_delevery_days);
        etDesc = findViewById(R.id.et_job_post_describtion);
        spinnerCategory = findViewById(R.id.spinner_job_post_category);
        spinnerSellerLevel = findViewById(R.id.spinner_job_post_seller_level);
        btnJobPost = findViewById(R.id.btn_job_post);

        sellerList.add("new seller");
        sellerList.add("profession");
        sellerList.add("intermediate");
        sellerList.add("expert");
        ArrayAdapter sellerAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,sellerList);
        spinnerSellerLevel.setAdapter(sellerAdapter);

        SharedText sharedText = new SharedText(CreateJobActivity.this);
        String cookie = sharedText.getCookie();
        String  buyer = sharedText.getUserId();

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
                                Toast.makeText(CreateJobActivity.this,(response.body().getStatus()), Toast.LENGTH_SHORT).show();
                                categoryList = new ArrayList<>(Arrays.asList(response.body().getCategories()));
                                List<String> list = new ArrayList<>();
                                for (int i = 0; i < categoryList.size(); i++) {
                                    list.add(categoryList.get(i).getName());
                                }
                                ArrayAdapter<String > adapter = new ArrayAdapter<>(CreateJobActivity.this, android.R.layout.simple_list_item_1,list);
                                SpinnerCategory spinnerCategory1 = new SpinnerCategory(CreateJobActivity.this,categoryList);
                                spinnerCategory.setAdapter(adapter);
//                                rvPopular.setAdapter(adapterPopular);
//                                ArrayAdapter adapter = new ArrayAdapter<>(CreateJobActivity.this,response.body().getCategories());

                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<SearchModel> call, Throwable throwable) {
                        Toast.makeText(CreateJobActivity.this,"nothing", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        }).start();


        btnJobPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title, desc, delivery, budget, category, sellerLevel,subCategory = "66477a6c2a2f569ad8623dd1";
                title = etTitle.getText().toString();
                delivery = etDelivery.getText().toString();
                budget = etBudget.getText().toString();
                desc = etDesc.getText().toString();
                budget = etBudget.getText().toString();
                category = categoryList.get(spinnerCategory.getCount()-1).get_id();
                sellerLevel = sellerList.get(spinnerSellerLevel.getCount()-1);

                if (title.isEmpty() || desc.isEmpty() || delivery.isEmpty() || budget.isEmpty() ||
                category.isEmpty() || sellerLevel.isEmpty()){
                    Toast.makeText(CreateJobActivity.this, "All fieled required", Toast.LENGTH_SHORT).show();
                    etTitle.setError("All fieled required");
                }
                else {
                    JobCreateModel model = new JobCreateModel(title,desc,budget,sellerLevel,delivery,buyer,category,subCategory);
                    Retrofit retrofit = RestSingleTon.getRetrofit();
                    RestApi api = retrofit.create(RestApi.class);
                    Call<JobBuyerModel> call = api.CreateJob(cookie,buyer,model);
                    call.enqueue(new Callback<JobBuyerModel>() {
                        @Override
                        public void onResponse(Call<JobBuyerModel> call, Response<JobBuyerModel> response) {
                            if (response.isSuccessful()){
                                Toast.makeText(CreateJobActivity.this, response.body().toString(), Toast.LENGTH_SHORT).show();
                            }
                            else {
                                Toast.makeText(CreateJobActivity.this, "some erro "+response.errorBody(), Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<JobBuyerModel> call, Throwable throwable) {
                            Toast.makeText(CreateJobActivity.this, "error "+throwable.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
                }

            }
        });
    }
}