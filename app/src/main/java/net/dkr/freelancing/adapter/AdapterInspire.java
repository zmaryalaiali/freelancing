package net.dkr.freelancing.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import net.dkr.freelancing.GigDetailesActivity;
import net.dkr.freelancing.R;
import net.dkr.freelancing.model.RecentModel;

import java.util.List;

public class AdapterInspire extends RecyclerView.Adapter<AdapterInspire.InspirHolder> {
    private Context context;
    List<RecentModel> list;

    public AdapterInspire(Context context, List<RecentModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public InspirHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(context).inflate(R.layout.inspired_view,parent,false);
    return new InspirHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InspirHolder holder, int position) {
//        holder.faovriteiv.setImageResource(list.get(position).getFaoriteImaege());
//        holder.rateiv.setImageResource(list.get(position).getRateImage());.
        RecentModel model = list.get(position);
        byte[] b = model.getImages().get(0).getImg().getData().getData();
        holder.iv.setImageBitmap(BitmapFactory.decodeByteArray(b,0,b.length));
        holder.mainTexttv.setText(model.getCustomeTitle());
//        holder.tvNumberUser.setText(model.getUser().getName());
        holder.tvPrice.setText(model.getPrice()+"$");
        holder.tvRate.setText(model.getRatingsAverage()+"");
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, GigDetailesActivity.class);
                intent.putExtra("subCategoryId",model.getSubCategory());
                intent.putExtra("userId",model.getUser().getId());
                intent.putExtra("gigId",model.getId());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class InspirHolder extends RecyclerView.ViewHolder{
            ImageView iv;
            TextView mainTexttv,tvPrice,tvRate,tvNumberUser;

        public InspirHolder(@NonNull View itemView) {
            super(itemView);

            iv  = itemView.findViewById(R.id.iv_inspire);
            tvRate = itemView.findViewById(R.id.tv_inspire_rate);
            tvPrice = itemView.findViewById(R.id.tv_inspire_price);
            tvNumberUser = itemView.findViewById(R.id.tv_inspire_number_user);
            mainTexttv  = itemView.findViewById(R.id.tv_inspire_main_text);
        }
    }
}
