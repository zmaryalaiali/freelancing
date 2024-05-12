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

import java.util.List;

public class AdapterInspire extends RecyclerView.Adapter<AdapterInspire.InspirHolder> {
    private Context context;
    List<InspireModel> list;

    public AdapterInspire(Context context, List<InspireModel> list) {
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
        holder.faovriteiv.setImageResource(list.get(position).getFaoriteImaege());
        holder.rateiv.setImageResource(list.get(position).getImage());
        holder.iv.setImageResource(list.get(position).getImage());
        holder.mainTexttv.setText(list.get(position).getText());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class InspirHolder extends RecyclerView.ViewHolder{
ImageView iv,rateiv,faovriteiv;
TextView mainTexttv;

        public InspirHolder(@NonNull View itemView) {
            super(itemView);

            iv  = itemView.findViewById(R.id.iv_inspire);
            rateiv = itemView.findViewById(R.id.iv_inspire_rate);
            faovriteiv = itemView.findViewById(R.id.iv_inspire_favorite);
            mainTexttv  = itemView.findViewById(R.id.tv_inspire_main_text);
        }
    }
}
