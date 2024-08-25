package net.dkr.freelancing.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import net.dkr.freelancing.R;
import net.dkr.freelancing.model.MessageModel;

import java.util.List;

public class AdapterMessage extends RecyclerView.Adapter<AdapterMessage.MessageHolder> {

    private Context context;
    List<MessageModel> list;

    public AdapterMessage(Context context, List<MessageModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MessageHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.message_view, parent, false);
        return new MessageHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MessageHolder holder, int position) {

        MessageModel model = list.get(position);
        if (model.getSentBy().equals(MessageModel.SENT_BY)) {
            holder.userCard.setVisibility(View.GONE);
            holder.serverCard.setVisibility(View.VISIBLE);
            holder.serverTv.setText(model.getMessage());
            holder.tvServerDate.setText(model.getDate());
        } else {
            holder.serverCard.setVisibility(View.GONE);
            holder.userCard.setVisibility(View.VISIBLE);
            holder.userTv.setText(model.getMessage());
            holder.tvUserDate.setText(model.getDate());
        }

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(context, model.getMessage()+" copy", Toast.LENGTH_SHORT).show();

                return true;
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MessageHolder extends RecyclerView.ViewHolder {

        TextView userTv, serverTv;
        CardView userCard,serverCard;
        TextView tvUserDate,tvServerDate;

        public MessageHolder(@NonNull View itemView) {
            super(itemView);

            userTv = itemView.findViewById(R.id.user_text);
            serverTv = itemView.findViewById(R.id.server_text);
            serverCard = itemView.findViewById(R.id.card_server);
            userCard = itemView.findViewById(R.id.card_user);
            tvServerDate = itemView.findViewById(R.id.server_date);
            tvUserDate = itemView.findViewById(R.id.user_date);
        }
    }

}
