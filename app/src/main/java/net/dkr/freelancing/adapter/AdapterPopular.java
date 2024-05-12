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
import net.dkr.freelancing.model.PopularServiceModel;

import java.util.List;

public class AdapterPopular extends RecyclerView.Adapter<AdapterPopular.PopulartHolder> {
    private Context context;
    List<PopularServiceModel> list;

    public AdapterPopular(Context context, List<PopularServiceModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public PopulartHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.popular_service_view,parent,false);
        return new PopulartHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PopulartHolder holder, int position) {
holder.maintext.setText(list.get(position).getText());
holder.ivpopular.setImageResource(list.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class PopulartHolder extends RecyclerView.ViewHolder{
        ImageView ivpopular;
        TextView maintext;

        public PopulartHolder(@NonNull View itemView) {
            super(itemView);

            ivpopular  = itemView.findViewById(R.id.popular_service_iv);

            maintext  = itemView.findViewById(R.id.popularTextView);
        }
    }
}
