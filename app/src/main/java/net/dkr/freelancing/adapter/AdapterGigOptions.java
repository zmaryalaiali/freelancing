package net.dkr.freelancing.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import net.dkr.freelancing.model.RecentModel;
import net.dkr.freelancing.model.SingleGigModel;

import java.util.List;


public class AdapterGigOptions extends RecyclerView.Adapter<AdapterGigOptions.GigDetailsComponenetHolder> {

    Context context;
    List<SingleGigModel.Option>list;

    public AdapterGigOptions(Context context, List<SingleGigModel.Option> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public GigDetailsComponenetHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(context).inflate(net.dkr.freelancing.R.layout.view_gig_details_components,parent,false);
       return new GigDetailsComponenetHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GigDetailsComponenetHolder holder, int position) {

        if (list.get(position).getStatus().equals("true")) {
            holder.tvComponentName.setText(list.get(position).getName());
            holder.itemView.setVisibility(View.VISIBLE);
        }


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class GigDetailsComponenetHolder extends RecyclerView.ViewHolder{

        TextView tvComponentName,tvComponentValue;
        ImageView ivComponentImage;
        public GigDetailsComponenetHolder(@NonNull View itemView) {
            super(itemView);

            tvComponentName = itemView.findViewById(net.dkr.freelancing.R.id.tv_gig_details_component_name);
//            tvComponentValue = itemView.findViewById(net.dkr.freelancing.R.id.tv_gig_details_component_value);
            ivComponentImage = itemView.findViewById(net.dkr.freelancing.R.id.iv_gig_details_component_image);
        }
    }
}
