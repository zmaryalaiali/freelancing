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

import net.dkr.freelancing.GigDetailesActivity;
import net.dkr.freelancing.R;
import net.dkr.freelancing.model.RecentModel;

import java.util.List;

public class AdapterGig extends RecyclerView.Adapter<AdapterGig.Gig_view_Holder> {

    private Context context;
    List<RecentModel> list;

    public AdapterGig(Context context, List<RecentModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public Gig_view_Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.gig_design_view, parent, false);
        return new Gig_view_Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Gig_view_Holder holder, int position) {

        RecentModel model = list.get(position);
//        holder.gig_image.setImageResource(list.get(position).getGig_image());
        byte[] bytes = model.getImages().get(0).getImg().getData().getData();
        holder.gig_image.setImageBitmap(BitmapFactory.decodeByteArray(bytes, 0, bytes.length));
//        holder.rate_tv.setText(list.get(position).getRate_tv());
        holder.rate_tv.setText(model.getRatingsAverage() + "");

//        holder.reviews.setText("("+list.get(position).getReviews()+")");
//        holder.reviews.setText(model.getStatus() + "");
//        holder.gig_price.setText(list.get(position).getGig_price()+" $");
        holder.gig_price.setText(model.getPrice() + "$");
//        holder.text.setText(list.get(position).getText());
        holder.text.setText(model.getCustomeTitle());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, GigDetailesActivity.class);
                intent.putExtra("subCategoryId",model.getSubCategory());
                intent.putExtra("userId",model.getUser().getId());
                intent.putExtra("gigId",model.getId());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Gig_view_Holder extends RecyclerView.ViewHolder {

        ImageView gig_image;
        TextView rate_tv, reviews;
        ImageView favorite_Imaege;
        TextView gig_price;
        TextView text;

        public Gig_view_Holder(@NonNull View itemView) {
            super(itemView);
            gig_image = itemView.findViewById(R.id.iv_gig);
            rate_tv = itemView.findViewById(R.id.tv_Review_rate);
//            reviews=itemView.findViewById(R.id.tv_review);
            favorite_Imaege = itemView.findViewById(R.id.iv_gig_favorite);
            gig_price = itemView.findViewById(R.id.tv_gig_price);
            text = itemView.findViewById(R.id.tv_gig_description);

        }
    }
}
