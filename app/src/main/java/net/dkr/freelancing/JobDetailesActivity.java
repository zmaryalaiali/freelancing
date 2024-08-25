package net.dkr.freelancing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import net.dkr.freelancing.adapter.AdapterBuyerJob;
import net.dkr.freelancing.model.JobBuyerModel;
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

public class JobDetailesActivity extends AppCompatActivity {

    Button btnApplay;
    Retrofit retrofit;
    TextView tvName, tvJobTime, tvJobDesc, tvJobPrice, tvJobSellerLevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_detailes);

        btnApplay = findViewById(R.id.btn_applay_to_job);
        tvName = findViewById(R.id.tv_job_detailes_name);
        tvJobTime = findViewById(R.id.tv_job_detailes_posted_time);
        tvJobPrice = findViewById(R.id.tv_job_detailes_price);
        tvJobDesc = findViewById(R.id.tv_job_detailes_desc);
        tvJobSellerLevel = findViewById(R.id.tv_job_detailes_expert);

        JobBuyerModel model = getIntent().getParcelableExtra("model");

                            tvName.setText(model.getTitle());
                            tvJobDesc.setText(model.getDescription());
                            tvJobPrice.setText(model.getBudget());
                            tvJobTime.setText(model.getStartDate());
                            tvJobSellerLevel.setText(model.getSellerLevel());





//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                retrofit = RestSingleTon.getRetrofit();
//                RestApi restApi = retrofit.create(RestApi.class);
//
//                Call<JobBuyerModel[]> call = restApi.getJob(cookie, jobId);
//                call.enqueue(new Callback<JobBuyerModel[]>() {
//                    @Override
//                    public void onResponse(Call<JobBuyerModel[]> call, Response<JobBuyerModel[]> response) {
//                        if (response.isSuccessful()) {
//                            JobBuyerModel[] model = response.body();
////                            JobBuyerModel jobBuyerModel = model[0];
////                            tvName.setText(model.getTitle());
////                            tvJobDesc.setText(model.getDescription());
////                            tvJobPrice.setText(model.getBudget());
////                            tvJobTime.setText(model.getStartDate());
////                            tvJobSellerLevel.setText(model.getSellerLevel());
//                            Toast.makeText(JobDetailesActivity.this, "success"+model.length, Toast.LENGTH_SHORT).show();
//                        } else {
//                            tvName.setText("some Error " + response.errorBody());
//                        }
//                    }
//                    @Override
//                    public void onFailure(Call<JobBuyerModel[]> call, Throwable throwable) {
//                        tvName.setText("error " + throwable.getMessage());
//                    }
//                });
//
//            }
//        }).start();

        btnApplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(JobDetailesActivity.this, SubmitProposalActivity.class);
                i.putExtra("jobId",model.get_id());
                startActivity(i);

            }
        });
    }
}