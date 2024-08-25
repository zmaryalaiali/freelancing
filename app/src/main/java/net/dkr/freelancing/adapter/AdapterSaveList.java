package net.dkr.freelancing.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
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
import net.dkr.freelancing.db.SaveListDb;
import net.dkr.freelancing.db.SaveListModel;

import java.util.List;

public class AdapterSaveList extends RecyclerView.Adapter<AdapterSaveList.SaveListHolder> {

    private List<SaveListModel> list;
    private Context context;

    public AdapterSaveList(List<SaveListModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public SaveListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.view_save_list, parent, false);

        return new SaveListHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SaveListHolder holder, int position) {
        SaveListModel model = list.get(position);
        holder.tvTitle.setText(model.getGigName());
        byte[] b = model.getImage();
        Bitmap bitmap = BitmapFactory.decodeByteArray(b, 0, b.length);
        holder.imageView.setImageBitmap(bitmap);

        holder.tvDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        SaveListDb db = SaveListDb.getDb(context);
                        db.doa().deletSaveListItem(model);
                        list.remove(position);
                    }
                }).start();
                notifyDataSetChanged();
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, GigDetailesActivity.class);
                intent.putExtra("gigId", model.getGigId());
                intent.putExtra("userId", model.getUserId());
                intent.putExtra("subCategoryId", model.getSubCategoryId());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class SaveListHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView tvTitle;
        TextView tvDelete;

        public SaveListHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv_saveList);
            tvTitle = itemView.findViewById(R.id.tv_saveList);
            tvDelete = itemView.findViewById(R.id.tv_saveList_delete);
        }
    }
}
