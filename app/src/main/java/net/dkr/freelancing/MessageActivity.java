package net.dkr.freelancing;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textfield.TextInputLayout;

import net.dkr.freelancing.adapter.AdapterMessage;
import net.dkr.freelancing.model.MessageModel;
import net.dkr.freelancing.model.MessageModelA;
import net.dkr.freelancing.model.MessageResponse;
import net.dkr.freelancing.model.NotificationModel;
import net.dkr.freelancing.model.NotificationModelResponse;
import net.dkr.freelancing.model.UserModel;
import net.dkr.freelancing.util.AllURL;
import net.dkr.freelancing.util.RestApi;
import net.dkr.freelancing.util.RestSingleTon;
import net.dkr.freelancing.util.SharedText;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MessageActivity extends AppCompatActivity {

    List<String> listMessages;

    List<MessageModel> messageModelList;
    RecyclerView rvMessage;
    TextInputLayout etMessageText;
    ImageView btnSent;

    ImageView btnChouseFile, ivUserImage;

    Toolbar toolbar;

    String chatId;

    //    Retrofit retrofit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        rvMessage = findViewById(R.id.rvMessage);
        etMessageText = findViewById(R.id.etMessageText);
        btnSent = findViewById(R.id.btnSent);
        btnChouseFile = findViewById(R.id.btnChouseFile);
        toolbar = findViewById(R.id.toolbar_message_activity);
        ivUserImage = findViewById(R.id.iv_message_userImage);

        setSupportActionBar(toolbar);

        Intent intent = getIntent();

        chatId = intent.getStringExtra("chatId");
        String userId = intent.getStringExtra("userId");

        new Thread(new Runnable() {
            @Override
            public void run() {
                Retrofit retrofit = RestSingleTon.getRetrofit();
                RestApi api = retrofit.create(RestApi.class);
                String url = AllURL.BASE_URL + "users/" + userId;
                Call<UserModel> call = api.getUser(url);
                call.enqueue(new Callback<UserModel>() {
                    @Override
                    public void onResponse(Call<UserModel> call, Response<UserModel> response) {
                        if (response.isSuccessful()) {
                            if (response.body().getProfile() != null) {
                                UserModel model = response.body();
                                getSupportActionBar().setTitle(model.getName());

                                byte[] b = model.getProfile().getPhoto().getImg().getData().getData();
                                ivUserImage.setImageBitmap(BitmapFactory.decodeByteArray(b, 0, b.length));
//                            ivUser.setImageBitmap(BitmapFactory.decodeByteArray(b, 0, b.length));

//                            tvUserName.setText(model.getName());
//                            tvUserType.setText(model.getProfile().getLevel());
                            }
                        } else {
                            Toast.makeText(MessageActivity.this, "some Error " + response.errorBody(), Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<UserModel> call, Throwable throwable) {
                        Toast.makeText(MessageActivity.this, "Error " + throwable.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }).start();

        ivUserImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MessageActivity.this, SellerActivity.class);
                i.putExtra("userId", userId);
                startActivity(i);
            }
        });


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        messageModelList = new ArrayList<>();


        rvMessage.setLayoutManager(new LinearLayoutManager(MessageActivity.this));
        AdapterMessage adapterMessage = new AdapterMessage(MessageActivity.this, messageModelList);
        rvMessage.setAdapter(adapterMessage);
        String currentUserId = new SharedText(this).getUserId();
        // get all chat of current user
        new Thread(new Runnable() {
            @Override
            public void run() {
                Retrofit retrofit = RestSingleTon.getRetrofit();
                RestApi api = retrofit.create(RestApi.class);
                SharedText sharedText = new SharedText(MessageActivity.this);
                String senderId = sharedText.getUserId();
                String messageUrl = AllURL.BASE_URL + "message/" + chatId;

                Call<MessageResponse[]> call = api.getMessages(messageUrl);
                call.enqueue(new Callback<MessageResponse[]>() {
                    @Override
                    public void onResponse(Call<MessageResponse[]> call, Response<MessageResponse[]> response) {
                        if (response.isSuccessful()) {

                            for (int i = 0; i < response.body().length; i++) {
                                if (response.body()[i].getSender().equals(currentUserId)) {
                                    messageModelList.add(new MessageModel(response.body()[i].getText(), MessageModel.SENT_ME, response.body()[i].getCreatedAt()));

                                } else {
                                    messageModelList.add(new MessageModel(response.body()[i].getText(), MessageModel.SENT_BY, response.body()[i].getCreatedAt()));

                                }
                            }


                        } else {
                            messageModelList.add(new MessageModel("some error " + response.errorBody(), MessageModel.SENT_ME, new Date(System.currentTimeMillis()).toString()));

                        }
                        adapterMessage.notifyDataSetChanged();

                    }

                    @Override
                    public void onFailure(Call<MessageResponse[]> call, Throwable throwable) {
                        messageModelList.add(new MessageModel("error " + throwable.getMessage(), MessageModel.SENT_ME, new Date(System.currentTimeMillis()).toString()));
                        adapterMessage.notifyDataSetChanged();
                    }
                });

            }
        }).start();
        btnSent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String etr = etMessageText.getEditText().getText().toString().trim();
                if (!etr.isEmpty()) {
                    Retrofit retrofit = RestSingleTon.getRetrofit();
                    RestApi api = retrofit.create(RestApi.class);
                    SharedText sharedText = new SharedText(MessageActivity.this);

                    MessageModelA modelA = new MessageModelA(chatId, sharedText.getUserId(), etr);
                    Call<MessageResponse> call = api.message(modelA,chatId);
                    call.enqueue(new Callback<MessageResponse>() {
                        @Override
                        public void onResponse(Call<MessageResponse> call, Response<MessageResponse> response) {
                            if (response.isSuccessful()) {
                                messageModelList.add(new MessageModel(response.body().getText(), MessageModel.SENT_ME, response.body().getCreatedAt()));
                            } else {
                                messageModelList.add(new MessageModel(response.errorBody().toString(), MessageModel.SENT_ME, new Date(System.currentTimeMillis()).toString()));

                            }
                            adapterMessage.notifyDataSetChanged();
                        }

                        @Override
                        public void onFailure(Call<MessageResponse> call, Throwable throwable) {
                            messageModelList.add(new MessageModel(throwable.getMessage(), MessageModel.SENT_ME, new Date(System.currentTimeMillis()).toString()));
                            adapterMessage.notifyDataSetChanged();
                        }
                    });
                    Call<NotificationModelResponse> call1 = api.createNotification(new NotificationModel(etMessageText.getEditText().getText().toString(),"message","/chat",userId));
                    call1.enqueue(new Callback<NotificationModelResponse>() {
                        @Override
                        public void onResponse(Call<NotificationModelResponse> call, Response<NotificationModelResponse> response) {
                            if (response.isSuccessful()){
                                Toast.makeText(MessageActivity.this, "Success", Toast.LENGTH_SHORT).show();
                            }
                            else {

                                Toast.makeText(MessageActivity.this, "some error "+response.errorBody(), Toast.LENGTH_SHORT).show();

                            }
                        }

                        @Override
                        public void onFailure(Call<NotificationModelResponse> call, Throwable throwable) {
                            Toast.makeText(MessageActivity.this, "error "+throwable.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
                    etMessageText.getEditText().setText("");





                }
            }
        });

        btnChouseFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /// create bottom sheet for chouse user file uploads
                AlertDialog.Builder builder = new AlertDialog.Builder(MessageActivity.this)
                        .setMessage("Please chouse  a File ")
                        .setTitle("File chouse");
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}