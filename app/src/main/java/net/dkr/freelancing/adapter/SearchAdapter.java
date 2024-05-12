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
import net.dkr.freelancing.model.SearchModel;

import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchHolder>{
    List<SearchModel> list;
    Context context;

    public SearchAdapter(List<SearchModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public SearchHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.search_view,parent,false);
        return new SearchHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchHolder holder, int position) {
        SearchModel searchModel = list.get(position);
        holder.ivCategory.setImageResource(searchModel.getCategoryImage());
        holder.tvCategoryName.setText(searchModel.getCategoryName());
        holder.tvCategoryDescription.setText(searchModel.getCategoryDescription());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class SearchHolder extends RecyclerView.ViewHolder{
        ImageView ivCategory;
        TextView tvCategoryName,tvCategoryDescription;

        public SearchHolder(@NonNull View itemView) {
            super(itemView);

            ivCategory = itemView.findViewById(R.id.iv_category);
            tvCategoryDescription = itemView.findViewById(R.id.tv_category_description);
            tvCategoryName = itemView.findViewById(R.id.tv_category_name);
        }
    }

}
