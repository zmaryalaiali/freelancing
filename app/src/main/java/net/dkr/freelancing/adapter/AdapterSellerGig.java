package net.dkr.freelancing.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import net.dkr.freelancing.R;
import net.dkr.freelancing.model.SellerGigModel;

import java.util.List;

public class AdapterSellerGig extends RecyclerView.Adapter<AdapterSellerGig.SellerGigHolder> {
    private Context context;
    private List<SellerGigModel> list;

    public AdapterSellerGig(Context context, List<SellerGigModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public SellerGigHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(context).inflate(R.layout.view_seller_gig,parent,false);
       return new SellerGigHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SellerGigHolder holder, int position) {
        SellerGigModel model = list.get(position);
        holder.ivGig.setImageResource(model.getSellerGigImage());
        holder.tvGigStatus.setText(model.getSellerGigStatus());
        holder.tvGigPrice.setText(model.getSellerGigPrice());
        holder.tvGigDesc.setText(model.getSellerGigText());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class SellerGigHolder extends RecyclerView.ViewHolder{
        ImageView ivGig;
        TextView tvGigStatus,tvGigDesc,tvGigPrice;

        public SellerGigHolder(@NonNull View itemView) {
            super(itemView);
            tvGigDesc = itemView.findViewById(R.id.tv_gig_seller_description);
            tvGigPrice = itemView.findViewById(R.id.tv_gig_seller_price);
            tvGigStatus = itemView.findViewById(R.id.tv_gig_seller_status);
            ivGig = itemView.findViewById(R.id.iv_seller_gig_image);
        }
    }
}
