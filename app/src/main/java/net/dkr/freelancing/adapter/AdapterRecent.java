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

import com.google.android.material.snackbar.Snackbar;

import net.dkr.freelancing.GigDetailesActivity;
import net.dkr.freelancing.R;
import net.dkr.freelancing.db.Doa;
import net.dkr.freelancing.db.SaveListDb;
import net.dkr.freelancing.model.RecentModel;
import net.dkr.freelancing.db.SaveListModel;

import java.util.List;

public class AdapterRecent extends RecyclerView.Adapter<AdapterRecent.RecentHolder> {
    private Context context;
    List<RecentModel> list;

    public AdapterRecent(Context context, List<RecentModel> list) {
        this.context = context;
        this.list = list;
    }

    public void searchGig(List<RecentModel> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recent_view, parent, false);

        return new RecentHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecentHolder holder, int position) {
        final boolean[] favorite = {false};

        RecentModel model = list.get(position);
        byte[] bytes = model.getImages().get(0)
                .getImg().getData().getData();
        holder.ivRecent.setImageBitmap(BitmapFactory.decodeByteArray(bytes, 0, bytes.length));
        holder.mainTexttv.setText(model.getTitle());
        holder.tvSellerLevel.setText(model.getStatus() + " ");
        holder.tvSellerPrice.setText(model.getPrice() + " ");
        holder.tvSelleName.setText(model.getCustomeTitle());
        holder.tvRate.setText(model.getRatingsAverage() + "");


        new Thread(new Runnable() {
            @Override
            public void run() {
                SaveListDb db = SaveListDb.getDb(context);
                Doa doa = db.doa();
                if ((doa.isSaved(model.getId()) != null)) {
                    holder.ivFavorite.setImageResource(R.drawable.heart_read);
//                    doa.saveListAdd(model1);
                    favorite[0] = true;
                }

            }
        }).start();

        holder.ivFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (favorite[0]) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            SaveListDb db = SaveListDb.getDb(context);
                            Doa doa = db.doa();
                            if (!(doa.isSaved(model.getId()) != null)) {
                                SaveListModel model1 = new SaveListModel(bytes, model.getCustomeTitle(), model.getId(), model.getUser().getId(), model.getSubCategory());
                                doa.saveListAdd(model1);
                                favorite[0] = true;
                            } else {
                                SaveListModel model1 = new SaveListModel(bytes, model.getCustomeTitle(), model.getId(), model.getUser().getId(), model.getSubCategory());

                                doa.deletSaveListItem(model1);
                            }
                        }
                    }).start();

                    holder.ivFavorite.setImageResource(R.drawable.heart);
                    favorite[0] = false;

                }
                else {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            SaveListDb db = SaveListDb.getDb(context);
                            Doa doa = db.doa();
                            if (!(doa.isSaved(model.getId()) != null)) {
                                SaveListModel model1 = new SaveListModel(bytes, model.getCustomeTitle(), model.getId(), model.getUser().getId(), model.getSubCategory());
                                doa.saveListAdd(model1);
                                favorite[0] = true;
                                holder.ivFavorite.setImageResource(R.drawable.heart_read);
                            } else {
                                Snackbar.make(v, "Already saved", Snackbar.LENGTH_LONG).show();
//                                Toast.makeText(context, , Toast.LENGTH_SHORT).show();
                            }

//                            Toast.makeText(context, "done", Toast.LENGTH_SHORT).show();

                        }
                    }).start();


                }
            }
        });

//        holder.tvNumberUser.setText(model.getReviews()+"");
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, GigDetailesActivity.class);
            intent.putExtra("gigId", model.getId());
            intent.putExtra("userId", model.getUser().getId());
            intent.putExtra("subCategoryId", model.getSubCategory());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class RecentHolder extends RecyclerView.ViewHolder {
        ImageView ivRecent, ivFavorite;
        TextView mainTexttv, tvSelleName, tvSellerLevel, tvSellerPrice, tvNumberUser, tvRate;

        public RecentHolder(@NonNull View itemView) {
            super(itemView);

            ivRecent = itemView.findViewById(R.id.recent_iv);
            mainTexttv = itemView.findViewById(R.id.tv_main_text);
            tvSellerPrice = itemView.findViewById(R.id.tv_money);
            tvSelleName = itemView.findViewById(R.id.tv_seller_name);
            tvSellerLevel = itemView.findViewById(R.id.tv_seller_levell);
            tvNumberUser = itemView.findViewById(R.id.tv_number_user);
            tvRate = itemView.findViewById(R.id.tv_rate);
            ivFavorite = itemView.findViewById(R.id.iv_favorite);
        }
    }
}
