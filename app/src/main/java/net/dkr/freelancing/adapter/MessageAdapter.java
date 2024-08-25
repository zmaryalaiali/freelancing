package net.dkr.freelancing.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import net.dkr.freelancing.R;
import net.dkr.freelancing.model.MessageModel;

import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageHolder> {

    private Context context;
   List<MessageModel> list;
    @NonNull
    @Override
    public MessageHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.message_view,parent,false);
        return new MessageHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MessageHolder holder, int position) {

        MessageModel model = list.get(position);
        if (model.getSentBy().equals(MessageModel.SENT_BY)){
            holder.userTv.setVisibility(View.GONE);
            holder.serverTv.setVisibility(View.VISIBLE);
            holder.serverTv.setText(model.getSentBy());
        }
        else {
            holder.userTv.setVisibility(View.VISIBLE);
            holder.serverTv.setVisibility(View.GONE);
            holder.userTv.setText(model.getMessage());
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MessageHolder extends RecyclerView.ViewHolder{

TextView userTv,serverTv;
        public MessageHolder(@NonNull View itemView) {
            super(itemView);

            userTv = itemView.findViewById(R.id.user_text);
            serverTv = itemView.findViewById(R.id.server_text);
        }
    }

}
