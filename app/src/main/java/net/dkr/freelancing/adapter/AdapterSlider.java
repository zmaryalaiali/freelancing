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
import net.dkr.freelancing.model.SliderModel;

import java.util.List;


public class AdapterSlider extends RecyclerView.Adapter<AdapterSlider.SliderHolder> {
    private Context context;
    List<SliderModel> list;

    public AdapterSlider(Context context, List<SliderModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public SliderHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.view_slider,parent,false);
        return new SliderHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SliderHolder holder, int position) {

        SliderModel model = list.get(position);
        holder.textView.setText(model.getName());
        holder.imageView.setImageBitmap(model.getBitmap());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class SliderHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;
        public SliderHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv_gig_seller_sliderImage);
            textView = itemView.findViewById(R.id.tv_gig_seller_sliderText);
        }
    }

}
