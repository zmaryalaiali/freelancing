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

import net.dkr.freelancing.MessageActivity;
import net.dkr.freelancing.R;
import net.dkr.freelancing.model.ChatResponse;
import net.dkr.freelancing.model.UserModel;
import net.dkr.freelancing.util.AllURL;
import net.dkr.freelancing.util.RestApi;
import net.dkr.freelancing.util.RestSingleTon;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class AdapterMessageUser extends RecyclerView.Adapter<AdapterMessageUser.MessageUserHolder> {

    private Context context;
  private   List<ChatResponse> list;
    Retrofit retrofit ;
    RestApi api ;


    public AdapterMessageUser(Context context, List<ChatResponse> list) {
        this.context = context;
        this.list = list;
       retrofit = RestSingleTon.getRetrofit();

     api  = retrofit.create(RestApi.class);
    }

    @NonNull
    @Override
    public MessageUserHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.view_message_user_item,parent,false);
        return  new MessageUserHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MessageUserHolder holder, int position) {
//        MessageUserModel model = list.get(position);
//        holder.tvUserName.setText(model.getUserName());
//        holder.tvMessageDate.setText(model.getDate());
//        holder.ivUserImage.setImageResource(model.getUserImage());
        ChatResponse chatResponse = list.get(position);
        holder.tvMessageDate.setText(chatResponse.getCreatedAt());
//        loadUserInfo(chatResponse.getMembers()[0],holder);
//        holder.tvUserName.setText(chatResponse.getMembers()[0]);


        String url = AllURL.BASE_URL + "users/" + chatResponse.getMembers()[0];
        Call<UserModel> call = api.getUser(url);
        call.enqueue(new Callback<UserModel>() {
            @Override
            public void onResponse(Call<UserModel> call, Response<UserModel> response) {
                if (response.isSuccessful()) {
                    if (response.body().getProfile() != null) {
                        UserModel model = response.body();

                        holder.tvUserName.setText(model.getName());
                        byte[] b = model.getProfile().getPhoto().getImg().getData().getData();
                        holder.ivUserImage.setImageBitmap(BitmapFactory.decodeByteArray(b,0,b.length));
//                            ivUser.setImageBitmap(BitmapFactory.decodeByteArray(b, 0, b.length));

//                            tvUserName.setText(model.getName());
//                            tvUserType.setText(model.getProfile().getLevel());
                    }
                } else {
                    holder.tvUserName.setText("some error " + response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<UserModel> call, Throwable throwable) {
                holder.tvUserName.setText("Error " + throwable.getMessage());
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MessageActivity.class);
                intent.putExtra("chatId",chatResponse.get_id());
                intent.putExtra("userId",chatResponse.getMembers()[0]);

                context.startActivity(intent);

            }
        });

    }

    private void loadUserInfo(String userId , MessageUserHolder view){

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MessageUserHolder extends RecyclerView.ViewHolder{
         ImageView ivUserImage;
        TextView tvUserName,tvMessageDate;

        public MessageUserHolder(@NonNull View itemView) {
            super(itemView);

            ivUserImage = itemView.findViewById(R.id.iv_message_userImage);
            tvMessageDate = itemView.findViewById(R.id.tv_message_messageDate);
            tvUserName = itemView.findViewById(R.id.tv_message_userName);
        }
    }
}
