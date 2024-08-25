package net.dkr.freelancing;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import net.dkr.freelancing.adapter.AdapterFaqs;
import net.dkr.freelancing.adapter.AdapterGigOptions;
import net.dkr.freelancing.adapter.AdapterInspire;
import net.dkr.freelancing.adapter.AdapterSlider;
import net.dkr.freelancing.model.ChatModel;
import net.dkr.freelancing.model.ChatResponse;
import net.dkr.freelancing.model.CreateOrderModel;
import net.dkr.freelancing.model.CreateOrderPostModel;
import net.dkr.freelancing.model.Image;
import net.dkr.freelancing.model.RecentModel;
import net.dkr.freelancing.model.SingleGigModel;
import net.dkr.freelancing.model.SliderModel;
import net.dkr.freelancing.model.UserModel;
import net.dkr.freelancing.util.AllURL;
import net.dkr.freelancing.util.RestApi;
import net.dkr.freelancing.util.RestSingleTon;
import net.dkr.freelancing.util.SharedText;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class GigDetailesActivity extends AppCompatActivity {
    private RecyclerView imageSlider;
    RecyclerView rvGigOptions, rvInspire, rvFaqs;
    AdapterGigOptions adapterGigOptions;
    List<RecentModel> listInspire;
    List<SingleGigModel.Image> imageList;
    TextView tvGigSellerName, tvGigTitle, tvGigDescription, tvGigPrice,
            tvGigTypeDesc, tvGigSummary, tvGigFaqs, tvGoMessage;
    ImageView ivUser;
    Retrofit retrofit;
    RecentModel recentModel;
    boolean isFaqVisible;
    String userID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gig_detailes);
        imageSlider = findViewById(R.id.rv_gig_seller_slider);
        rvInspire = findViewById(R.id.rv_gig_seller_gig_recommend);
        rvGigOptions = findViewById(R.id.rv_gig_seller_gig_component);
        tvGigSellerName = findViewById(R.id.tv_gig_seller_name);
        tvGigTitle = findViewById(R.id.tv_gig_seller_gig_name);
        tvGigDescription = findViewById(R.id.tv_gig_seller_gig_description);
        tvGigPrice = findViewById(R.id.tv_gig_seller_gig_price);
        tvGigTypeDesc = findViewById(R.id.tv_gig_seller_gig_type_description);
        tvGigSummary = findViewById(R.id.tv_gig_seller_gig_summary);
        rvFaqs = findViewById(R.id.rv_gig_seller_gig_faqs);
        tvGigFaqs = findViewById(R.id.tv_gig_seller_gig_faqs);
        ivUser = findViewById(R.id.iv_gig_seller_image);
        tvGoMessage = findViewById(R.id.tv_gig_seller_goMessage);

        retrofit = RestSingleTon.getRetrofit();
       userID = getIntent().getStringExtra("userId");


        imageSlider.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                RestApi restApi = retrofit.create(RestApi.class);
                String subID = getIntent().getStringExtra("gigId");
                String url = AllURL.BASE_URL + "users/" + userID + "/gigs/" + subID;
                Call<SingleGigModel> call = restApi.getGig(url);
                call.enqueue(new Callback<SingleGigModel>() {
                    @Override
                    public void onResponse(Call<SingleGigModel> call, Response<SingleGigModel> response) {

                        if (response.isSuccessful()) {

                            SingleGigModel model = response.body();

                            tvGigSellerName.setText(model.getUser().getName());
                            tvGigTitle.setText(model.getTitle());
                            tvGigDescription.setText(model.getCustomeTitle());
                            tvGigSummary.setText(model.getSummery());
                            tvGigPrice.setText(model.getPrice() + "$");
                            tvGigTypeDesc.setText(model.getCustomeDescription());

                            // for options list
                            List<SingleGigModel.Option> optionList = new ArrayList<>();
                            for (int i = 0; i < model.getOptions().size(); i++) {
                                if (model.getOptions().get(i).getStatus().equals("true")) {
                                    optionList.add(model.getOptions().get(i));
                                }
                            }
//                             options adapter
                            adapterGigOptions = new AdapterGigOptions(GigDetailesActivity.this, optionList);
                            rvGigOptions.setAdapter(adapterGigOptions);

//                             faqs adapter and list
                            AdapterFaqs adapterFaqs = new AdapterFaqs(GigDetailesActivity.this, model.getFaqs());
                            rvFaqs.setLayoutManager(new LinearLayoutManager(GigDetailesActivity.this));
                            rvFaqs.setAdapter(adapterFaqs);
//
//                             for slider imageList and adapter
                            imageList = model.getImages();
                            List<SliderModel> slideModelList = new ArrayList<>();
                            for (int i = 0; i < imageList.size(); i++) {
//                                byte[] b = imageList.get(i).getImg().getData().getData();
                                byte[] b = imageList.get(i).getImg().getData().getData();
                                Bitmap bitmap = BitmapFactory.decodeByteArray(b, 0, b.length);
                                slideModelList.add(new SliderModel(bitmap, model.getCustomeTitle()));
                            }
                            AdapterSlider adapterSlider = new AdapterSlider(GigDetailesActivity.this, slideModelList);
                            imageSlider.setAdapter(adapterSlider);
//
                        } else {
                            Toast.makeText(GigDetailesActivity.this, "some error", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<SingleGigModel> call, Throwable throwable) {
                        recentModel = null;
                        Toast.makeText(GigDetailesActivity.this, "error " + throwable.getMessage(), Toast.LENGTH_SHORT).show();
                        tvGigSellerName.setText(throwable.getMessage());

                    }
                });
            }
        });
        thread.start();

        // related gig list
        new Thread(new Runnable() {
            @Override
            public void run() {
                String subID = getIntent().getStringExtra("subCategoryId");
                RestApi restApi = retrofit.create(RestApi.class);
                String url = AllURL.BASE_URL + "users/all/gigs?subCategory=" + subID;
                Call<RecentModel[]> call = restApi.getGigsBySubCategory(url);
                call.enqueue(new Callback<RecentModel[]>() {
                    @Override
                    public void onResponse(Call<RecentModel[]> call, Response<RecentModel[]> response) {
                        if (response.isSuccessful()) {
                            listInspire = new ArrayList<>(Arrays.asList(response.body()));
                            AdapterInspire adapterGig = new AdapterInspire(GigDetailesActivity.this, listInspire);
                            rvInspire.setAdapter(adapterGig);

                        }
                    }

                    @Override
                    public void onFailure(Call<RecentModel[]> call, Throwable throwable) {
                        Toast.makeText(GigDetailesActivity.this, "error Related" + throwable.getMessage(), Toast.LENGTH_SHORT).show();
                        tvGigSellerName.setText(throwable.getMessage());
                    }
                });

            }
        }).start();

        // other gig of this seller
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//
//
//            }
//        }).start();
//
        // user click to show faqs
        tvGigFaqs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isFaqVisible) {
                    rvFaqs.setVisibility(View.VISIBLE);
                    isFaqVisible = true;
                } else {
                    rvFaqs.setVisibility(View.GONE);
                    isFaqVisible = false;
                }
            }
        });

        // user profile
        new Thread(() -> {
            RestApi api = retrofit.create(RestApi.class);
            String url = AllURL.BASE_URL + "users/" + userID;
            Call<UserModel> call = api.getUser(url);
            call.enqueue(new Callback<UserModel>() {
                @Override
                public void onResponse(Call<UserModel> call, Response<UserModel> response) {
                    if (response.isSuccessful()) {
                        if (response.body().getProfile() != null) {
                            byte[] b = response.body().getProfile().getPhoto().getImg().getData().getData();
                            ivUser.setImageBitmap(BitmapFactory.decodeByteArray(b, 0, b.length));
                        }
                    } else {
                        tvGigFaqs.setText("some error " + response.errorBody());
                    }
                }

                @Override
                public void onFailure(Call<UserModel> call, Throwable throwable) {
                    tvGigFaqs.setText(" dont Done " + throwable.getMessage());

                }
            });
        }).start();

        ivUser.setOnClickListener(v -> {
            Intent intent = new Intent(GigDetailesActivity.this, SellerActivity.class);
            intent.putExtra("userId", userID);
            startActivity(intent);
        });

        tvGoMessage.setOnClickListener(v -> {
            SharedText sharedText = new SharedText(GigDetailesActivity.this);
            String receiverId = sharedText.getUserId();
            Retrofit retrofit1 = RestSingleTon.getRetrofit();
            RestApi api = retrofit1.create(RestApi.class);
            String url = AllURL.BASE_URL + "chat/find/" + receiverId + "/" + userID;
            Call<ChatResponse> call = api.getChat(url);
            call.enqueue(new Callback<ChatResponse>() {
                @Override
                public void onResponse(Call<ChatResponse> call, Response<ChatResponse> response) {
                    if (response.isSuccessful()) {
                        if (response.body() != null) {
                            Intent intent = new Intent(GigDetailesActivity.this, MessageActivity.class);
                            intent.putExtra("chatId", response.body().get_id());
                            intent.putExtra("userId", response.body().getMembers()[0]);
                            startActivity(intent);
                        } else {
                            Retrofit retrofit1 = RestSingleTon.getRetrofit();
                            RestApi api = retrofit1.create(RestApi.class);

                            ChatModel model = new ChatModel(userID, receiverId);

                            Call<ChatResponse> call1 = api.createChat(model);
                            call1.enqueue(new Callback<ChatResponse>() {
                                @Override
                                public void onResponse(Call<ChatResponse> call, Response<ChatResponse> response) {
                                    if (response.isSuccessful()) {
                                        Intent intent = new Intent(GigDetailesActivity.this, MessageActivity.class);
                                        intent.putExtra("chatId", response.body().get_id());
                                        intent.putExtra("userId", response.body().getMembers()[0]);
                                        startActivity(intent);
                                    } else {
                                        Toast.makeText(GigDetailesActivity.this, "some error " + response.errorBody(), Toast.LENGTH_LONG).show();
                                    }
                                }

                                @Override
                                public void onFailure(Call<ChatResponse> call, Throwable throwable) {
                                    Toast.makeText(GigDetailesActivity.this, "error " + throwable.getMessage(), Toast.LENGTH_SHORT).show();

                                }
                            });

                        }
                    }
                }

                @Override
                public void onFailure(Call<ChatResponse> call, Throwable throwable) {
                    Toast.makeText(GigDetailesActivity.this, "error " + throwable.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });

        });

        rvInspire.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rvGigOptions.setLayoutManager(new LinearLayoutManager(this));


    }

    public void countinueOrder(View view) {
        String gigId = getIntent().getStringExtra("gigId");
        SharedText sharedText = new SharedText(this);
        String url = AllURL.BASE_URL+"users/"+sharedText.getUserId()+"/gigs/"+gigId+"/orders/create";
        RestApi api = retrofit.create(RestApi.class);
        Call<CreateOrderModel> call = api.createOrder(new SharedText(this).getCookie(),
                url,new CreateOrderPostModel(gigId));
        call.enqueue(new Callback<CreateOrderModel>() {
            @Override
            public void onResponse(Call<CreateOrderModel> call, Response<CreateOrderModel> response) {
                if (response.isSuccessful()){
                    Intent intent = new Intent(GigDetailesActivity.this,PaymentActivity.class);
                    intent.putExtra("orderId",response.body().getId());
                    intent.putExtra("amount",response.body().getPrice());
                    startActivity(intent);
                }
                else {
                    tvGigTitle.setText(response.errorBody() +"and"+response.code());
                    Toast.makeText(GigDetailesActivity.this, "some error "+response.errorBody(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<CreateOrderModel> call, Throwable throwable) {

                Toast.makeText(GigDetailesActivity.this, "error "+throwable.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }
}