package net.dkr.freelancing.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import net.dkr.freelancing.R;
import net.dkr.freelancing.SearchActivity;
import net.dkr.freelancing.model.SearchModel;

import java.util.List;

public class AdapterSearchSubCategory extends RecyclerView.Adapter<AdapterSearchSubCategory.SearchSubCategoryHolder> {

    private Context context;
    List<SearchModel.SubCategory> list;

    public AdapterSearchSubCategory(Context context, List<SearchModel.SubCategory> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public SearchSubCategoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(context).inflate(R.layout.view_search_sub_category_item,parent,false);
        return  new SearchSubCategoryHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchSubCategoryHolder holder, int position) {
    holder.tvSearchSubCategoryName.setText(list.get(position).getName());

    holder.itemView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context, SearchActivity.class);
            intent.putExtra("subCategoryId",list.get(position).get_id());
            context.startActivity(intent);
        }
    });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class SearchSubCategoryHolder extends RecyclerView.ViewHolder{

        TextView tvSearchSubCategoryName;
        public SearchSubCategoryHolder(@NonNull View itemView) {
            super(itemView);
            tvSearchSubCategoryName = itemView.findViewById(R.id.tv_search_subCategory_name);
        }
    }
}
