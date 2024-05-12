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
import net.dkr.freelancing.model.InspireModel;
import net.dkr.freelancing.model.RecentModel;

import java.util.List;

public class AdapterRecent extends RecyclerView.Adapter<AdapterRecent.RecentHolder> {
    private Context context;
    List<RecentModel> list;

    public AdapterRecent(Context context, List<RecentModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recent_view,parent,false);

        return new RecentHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecentHolder holder, int position) {
        holder.iv.setImageResource(list.get(position).getIamge());
        holder.faovriteiv.setImageResource(list.get(position).getProfileImage());
//        holder.rateiv.setImageResource(list.get(position).get);
holder.mainTexttv.setText(list.get(position).getMainText());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class RecentHolder extends RecyclerView.ViewHolder{
        ImageView iv,rateiv,faovriteiv;
        TextView mainTexttv;

        public RecentHolder(@NonNull View itemView) {
            super(itemView);

            iv  = itemView.findViewById(R.id.recent_iv);
            rateiv = itemView.findViewById(R.id.iv_rate);
            faovriteiv = itemView.findViewById(R.id.iv_favorite);
            mainTexttv  = itemView.findViewById(R.id.tv_main_text);
        }
    }}
