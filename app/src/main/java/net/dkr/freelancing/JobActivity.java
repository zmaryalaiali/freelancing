package net.dkr.freelancing;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

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

public class JobActivity extends AppCompatActivity {

    List<JobBuyerModel> modelBuyerJobs;
    RecyclerView recyclerView;

    Retrofit retrofit;
    TextView tvJob;
    FloatingActionButton faBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job);
        recyclerView = findViewById(R.id.rv_buyer_job);
        tvJob = findViewById(R.id.tvJob);
        faBtn = findViewById(R.id.floatingActionButton);

        recyclerView.setLayoutManager(new LinearLayoutManager(JobActivity.this));

        SharedText sharedText = new SharedText(JobActivity.this);
        String cookie = sharedText.getCookie();


        new Thread(new Runnable() {
            @Override
            public void run() {
                retrofit = RestSingleTon.getRetrofit();
                RestApi restApi = retrofit.create(RestApi.class);

                Call<JobBuyerModel[]> call = restApi.getJobs(cookie);
                call.enqueue(new Callback<JobBuyerModel[]>() {
                    @Override
                    public void onResponse(Call<JobBuyerModel[]> call, Response<JobBuyerModel[]> response) {
                        if (response.isSuccessful()){
                            Toast.makeText(JobActivity.this, "success", Toast.LENGTH_SHORT).show();
                            List<JobBuyerModel> list = new ArrayList<>(Arrays.asList(response.body()));
                            AdapterBuyerJob job = new AdapterBuyerJob(JobActivity.this,list);
                            recyclerView.setAdapter(job);

                        }
                        else {
                            Toast.makeText(JobActivity.this, "more error "+response.errorBody(), Toast.LENGTH_LONG).show();
                            tvJob.setText(response.message()+" and "+ response.errorBody());
                        }
                    }

                    @Override
                    public void onFailure(Call<JobBuyerModel[]> call, Throwable throwable) {

                        Toast.makeText(JobActivity.this, "error "+throwable.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
            }
        }).start();


        faBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(JobActivity.this,CreateJobActivity.class);
                startActivity(intent);
            }
        });
//        modelBuyerJobs=new ArrayList<>();
//        modelBuyerJobs.add(new JobBuyerModel("i want to hair a person"));
//        modelBuyerJobs.add(new JobBuyerModel("i want to hair a person"));
//        modelBuyerJobs.add(new JobBuyerModel("i want to hair a person"));
//        modelBuyerJobs.add(new JobBuyerModel("i want to hair a person"));
//        modelBuyerJobs.add(new JobBuyerModel("i want to hair a person"));
//        modelBuyerJobs.add(new JobBuyerModel("i want to hair a person"));
//
//        AdapterBuyerJob  adapterBuyerJob = new AdapterBuyerJob(JobActivity.this,modelBuyerJobs);
//        recyclerView.setAdapter(adapterBuyerJob);




    }
}