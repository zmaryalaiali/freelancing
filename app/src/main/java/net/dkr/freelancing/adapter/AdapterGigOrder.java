package net.dkr.freelancing.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowId;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import net.dkr.freelancing.OrderDetailActivity;
import net.dkr.freelancing.R;
import net.dkr.freelancing.model.GigOrderModel;

import java.util.List;

public class AdapterGigOrder extends RecyclerView.Adapter<AdapterGigOrder.GigOrderHolder> {

    private Context context;
    List<GigOrderModel> list;

    public AdapterGigOrder(Context context, List<GigOrderModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public GigOrderHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.view_gig_order,parent,false);
        return new GigOrderHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GigOrderHolder holder, int position) {
        GigOrderModel model = list.get(position);
//        holder.ivGigOrderImage.setImageResource(model.getGigOrderUserImage());
//        holder.tvGigOrderDate.setText(model.getGigOrderDate());
        holder.tvGigOrderPrice.setText(model.price);
//        holder.tvGigOrderDesc.setText(model.getGigOrderDesc());
        holder.tvGigOrderUserName.setText(model.seller.getName());
        holder.tvGigOrderUserName.setText(model.title);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, OrderDetailActivity.class);
                intent.putExtra("title",model.title);
                intent.putExtra("price",model.price);
                intent.putExtra("status",model.status);
                intent.putExtra("seller",model.seller);
                intent.putExtra("buyer",model.buyer);
                intent.putExtra("date",model.startDate);


                intent.putExtra("orderId",model._id);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class GigOrderHolder extends RecyclerView.ViewHolder{

        ImageView ivGigOrderImage;
        TextView tvGigOrderUserName,tvGigOrderDesc,tvGigOrderDate,tvGigOrderPrice;
        public GigOrderHolder(@NonNull View itemView) {
            super(itemView);

            tvGigOrderDate = itemView.findViewById(R.id.tv_gig_order_date);
            tvGigOrderDesc = itemView.findViewById(R.id.tv_gig_order_gigDesc);
            tvGigOrderUserName = itemView.findViewById(R.id.tv_gig_order_userName);
            tvGigOrderPrice = itemView.findViewById(R.id.tv_gig_order_price);
            ivGigOrderImage = itemView.findViewById(R.id.iv_gig_order_image);

        }
    }
}
