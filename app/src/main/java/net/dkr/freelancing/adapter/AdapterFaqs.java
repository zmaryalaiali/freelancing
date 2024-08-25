package net.dkr.freelancing.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import net.dkr.freelancing.R;
import net.dkr.freelancing.model.RecentModel;
import net.dkr.freelancing.model.SingleGigModel;

import java.util.List;

public class AdapterFaqs extends RecyclerView.Adapter<AdapterFaqs.FaqsHolder> {
    Context context;
    List<SingleGigModel.Faq> list;

    public AdapterFaqs(Context context, List<SingleGigModel.Faq> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public FaqsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.view_faqs_item,parent,false);
        return new FaqsHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FaqsHolder holder, int position) {

        SingleGigModel.Faq model = list.get(position);
        holder.tvQuestion.setText(model.getQuestion());
        holder.tvAnswer.setText(model.getAnswer());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class FaqsHolder extends RecyclerView.ViewHolder{

        TextView tvQuestion,tvAnswer;
        public FaqsHolder(@NonNull View itemView) {
            super(itemView);
            tvAnswer = itemView.findViewById(R.id.tv_gig_seller_faqs_ans);
            tvQuestion = itemView.findViewById(R.id.tv_gig_seller_faqs_qu);


        }
    }

}
