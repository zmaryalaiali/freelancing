package net.dkr.freelancing.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import net.dkr.freelancing.R;
import net.dkr.freelancing.model.SellerLanguageModel;
import net.dkr.freelancing.model.UserModel;

import java.util.List;

public class AdapterSellerLanguage extends RecyclerView.Adapter<AdapterSellerLanguage.SellerLanguageHolder> {

        private Context context;
        List<UserModel.Language> list;

    public AdapterSellerLanguage(Context context, List<UserModel.Language> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public SellerLanguageHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.view_seller_languages,parent,false);
        return  new SellerLanguageHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SellerLanguageHolder holder, int position) {

        UserModel.Language model = list.get(position);

        holder.tvSellerLanguageName.setText(model.getLanguage());
        holder.tvSellerLanguageDesc.setText(model.getProficiency());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class SellerLanguageHolder extends RecyclerView.ViewHolder {
            TextView tvSellerLanguageName,tvSellerLanguageDesc;

            public SellerLanguageHolder(@NonNull View itemView) {
                super(itemView);

                tvSellerLanguageName = itemView.findViewById(R.id.tv_seller_rvItem_language_name);
                tvSellerLanguageDesc = itemView.findViewById(R.id.tv_seller_rvItem_language_desc);
            }
        }


}
