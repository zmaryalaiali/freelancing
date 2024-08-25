package net.dkr.freelancing.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import net.dkr.freelancing.R;
import net.dkr.freelancing.util.SharedText;
import net.dkr.freelancing.fragments.SearchSubCategoryFragment;
import net.dkr.freelancing.model.SearchModel;
import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchHolder>{

    Context context;
    List<SearchModel.Category> list;

    public SearchAdapter(Context context, List<SearchModel.Category> list) {
        this.context = context;
        this.list = list;
    }



    public void setFilterdList(List<SearchModel.Category> filterdList)
    {
        this.list=filterdList;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public SearchHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.search_view,parent,false);
        return new SearchHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchHolder holder, @SuppressLint("RecyclerView") int position) {
       SearchModel.Category category = list.get(position);
//        holder.ivCategory.setImageResource(searchModel.getCategoryImage());
        holder.tvCategoryName.setText(category.getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                itemClick.itemClick(position);
                FragmentManager manager = ((AppCompatActivity)context).getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                Fragment fragment = new SearchSubCategoryFragment(category.getSubCategory());
                transaction.add(R.id.frameLayout_home,fragment,"searchsubcategory").replace(R.id.frameLayout_home,fragment).commit();
                SharedText sharedText = new SharedText(context);
                sharedText.setSearch(false);
                Toast.makeText(context,category.getName(),Toast.LENGTH_LONG).show();

            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class SearchHolder extends RecyclerView.ViewHolder {
        ImageView ivCategory;
        TextView tvCategoryName,tvCategoryDescription;

        public SearchHolder(@NonNull View itemView) {
            super(itemView);

            ivCategory = itemView.findViewById(R.id.iv_category);
//            tvCategoryDescription = itemView.findViewById(R.id.tv_category_description);
            tvCategoryName = itemView.findViewById(R.id.tv_category_name);
        }

        }




}
