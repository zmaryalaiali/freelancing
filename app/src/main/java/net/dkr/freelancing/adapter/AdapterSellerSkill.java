package net.dkr.freelancing.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import net.dkr.freelancing.R;

import java.util.List;

public class AdapterSellerSkill extends RecyclerView.Adapter<AdapterSellerSkill.SellerSkillHolder> {

    private Context context;
    List<String> list;

    public AdapterSellerSkill(Context context, List<String > list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public SellerSkillHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.view_seller_skills, parent, false);
        return new SellerSkillHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SellerSkillHolder holder, int position) {
        holder.tvSellerSkill.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class SellerSkillHolder extends RecyclerView.ViewHolder {
        TextView tvSellerSkill;

        public SellerSkillHolder(@NonNull View itemView) {
            super(itemView);

            tvSellerSkill = itemView.findViewById(R.id.tv_seller_rvItem_skill);
        }
    }
}
