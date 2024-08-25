package net.dkr.freelancing.adapter;

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

public class AdapterPopular extends RecyclerView.Adapter<AdapterPopular.PopulartHolder> {
    private Context context;
    List<SearchModel.Category> list;

    public AdapterPopular(Context context, List<SearchModel.Category> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public PopulartHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.popular_service_view, parent, false);
        return new PopulartHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PopulartHolder holder, int position) {
        SearchModel.Category category = list.get(position);
        holder.maintext.setText(category.getName());
//        holder.ivpopular.setImageResource(list.get(position).getImage());
        holder.itemView.setOnClickListener(v -> {
            SharedText sharedText = new SharedText(context);
            sharedText.setSearch(true);
            FragmentManager manager = ((AppCompatActivity) context).getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            Fragment fragment = new SearchSubCategoryFragment(category.getSubCategory());
            transaction.add(R.id.frameLayout_home, fragment, "searchsubcategory").replace(R.id.frameLayout_home, fragment).commit();

            Toast.makeText(context, category.getName(), Toast.LENGTH_LONG).show();
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class PopulartHolder extends RecyclerView.ViewHolder {
        ImageView ivpopular;
        TextView maintext;

        public PopulartHolder(@NonNull View itemView) {
            super(itemView);

            ivpopular = itemView.findViewById(R.id.popular_service_iv);

            maintext = itemView.findViewById(R.id.popularTextView);
        }
    }
}
