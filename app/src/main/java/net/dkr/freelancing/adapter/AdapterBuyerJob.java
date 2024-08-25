package net.dkr.freelancing.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import net.dkr.freelancing.JobDetailesActivity;
import net.dkr.freelancing.R;
import net.dkr.freelancing.model.JobBuyerModel;

import java.util.List;

public class AdapterBuyerJob extends RecyclerView.Adapter<AdapterBuyerJob.JobHolder> {

    private Context context;
    List<JobBuyerModel> list;

    public AdapterBuyerJob(Context context, List<JobBuyerModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public JobHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(context).inflate(R.layout.view_job_item,parent,false);
        return new JobHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JobHolder holder, int position) {

//        holder.jobpostName.setText(list.get(position).getJobpostname());
        JobBuyerModel model = list.get(position);
        holder.jobpostdescription.setText(model.getDescription());
        holder.jobPostedTime.setText(model.getStartDate());
        holder.jobpostName.setText(model.getTitle());
        holder.jobpostprice.setText(model.getBudget());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, JobDetailesActivity.class);
                intent.putExtra("jobId",model.get_id());
                intent.putExtra("model",model);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class JobHolder extends RecyclerView.ViewHolder{

        TextView jobPostedTime,jobpostName,jobpostprice,jobpostdescription,jobpostproposals;
        public JobHolder(@NonNull View itemView) {
            super(itemView);
            jobPostedTime=itemView.findViewById(R.id.JobpostedTime);
            jobpostName=itemView.findViewById(R.id.JobpostName);
            jobpostprice=itemView.findViewById(R.id.Jobpostprice);
            jobpostdescription=itemView.findViewById(R.id.JobpostDescription);
            jobpostproposals=itemView.findViewById(R.id.jobpostProposals);



        }
    }
}
