package net.dkr.freelancing;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import net.dkr.freelancing.model.ChatModel;
import net.dkr.freelancing.model.ChatResponse;
import net.dkr.freelancing.model.GigOrderModel;
import net.dkr.freelancing.model.OrderDetailModel;
import net.dkr.freelancing.model.RecentModel;
import net.dkr.freelancing.util.AllURL;
import net.dkr.freelancing.util.RestApi;
import net.dkr.freelancing.util.RestSingleTon;
import net.dkr.freelancing.util.SharedText;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class OrderDetailActivity extends AppCompatActivity {

    TextView tvTitle, tvSellerName, tvDeliveryDate, tvOrderNumber, tvDeliveryTimeRemain, tvOrderPrice;
    EditText etMessageText;
    Button btnSentMessage, btnDeliveryOrder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_order_detail);
        tvTitle = findViewById(R.id.order_detail_tital);
        tvSellerName = findViewById(R.id.order_detail_tital);
        tvDeliveryDate = findViewById(R.id.tv_order_deleaveryTime);
        tvOrderPrice = findViewById(R.id.tv_order_detail_price);
        tvOrderNumber = findViewById(R.id.tv_order_detail_buyerId);
        tvDeliveryTimeRemain = findViewById(R.id.tv_deliver_time_remaind);
        btnSentMessage = findViewById(R.id.btn_sentMessage_toBuyer);
        btnDeliveryOrder = findViewById(R.id.btn_deliver_order);
        etMessageText = findViewById(R.id.editTextTextMultiLine);


        Intent intent = getIntent();
        RecentModel.User seller = (RecentModel.User) intent.getSerializableExtra("seller");
        RecentModel.User buyer =(RecentModel.User) intent.getSerializableExtra("buyer");
        String sellerName = seller.getName();
        tvSellerName.setText(sellerName);
        tvTitle.setText(intent.getStringExtra("title"));
        tvDeliveryDate.setText(intent.getStringExtra("date"));
        tvOrderPrice.setText(intent.getStringExtra("price"));
//        tvDeliveryTimeRemain.setText(intent.getStringExtra("remainTime"));
        tvOrderNumber.setText(intent.getStringExtra("orderId"));

        btnSentMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    SharedText sharedText = new SharedText(OrderDetailActivity.this);
                    String currentUser = sharedText.getUserId();
                    Retrofit retrofit1 = RestSingleTon.getRetrofit();
                    RestApi api = retrofit1.create(RestApi.class);
                    String url = AllURL.BASE_URL + "chat/find/" + currentUser + "/" + buyer.getId();
                    Call<ChatResponse> call = api.getChat(url);
                    call.enqueue(new Callback<ChatResponse>() {
                        @Override
                        public void onResponse(Call<ChatResponse> call, Response<ChatResponse> response) {
                            if (response.isSuccessful()) {
                                if (response.body() != null) {
                                    Intent intent = new Intent(OrderDetailActivity.this, MessageActivity.class);
                                    intent.putExtra("chatId", response.body().get_id());
                                    intent.putExtra("userId", response.body().getMembers()[0]);
                                    startActivity(intent);
                                } else {
                                    Retrofit retrofit1 = RestSingleTon.getRetrofit();
                                    RestApi api = retrofit1.create(RestApi.class);

                                    ChatModel model = new ChatModel(buyer.getId(), currentUser);

                                    Call<ChatResponse> call1 = api.createChat(model);
                                    call1.enqueue(new Callback<ChatResponse>() {
                                        @Override
                                        public void onResponse(Call<ChatResponse> call, Response<ChatResponse> response) {
                                            if (response.isSuccessful()) {
                                                Intent intent = new Intent(OrderDetailActivity.this, MessageActivity.class);
                                                intent.putExtra("chatId", response.body().get_id());
                                                intent.putExtra("userId", response.body().getMembers()[0]);
                                                startActivity(intent);
                                            } else {
                                                Toast.makeText(OrderDetailActivity.this, "some error " + response.errorBody(), Toast.LENGTH_LONG).show();
                                            }
                                        }

                                        @Override
                                        public void onFailure(Call<ChatResponse> call, Throwable throwable) {
                                            Toast.makeText(OrderDetailActivity.this, "error " + throwable.getMessage(), Toast.LENGTH_SHORT).show();

                                        }
                                    });

                                }
                            }
                        }

                        @Override
                        public void onFailure(Call<ChatResponse> call, Throwable throwable) {
                            Toast.makeText(OrderDetailActivity.this, "error " + throwable.getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    });


            }
        });

        btnDeliveryOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (new SharedText(OrderDetailActivity.this).userType()){
                    Intent intent1 = new Intent(OrderDetailActivity.this, DeliverOrderActivity.class);
                    intent1.putExtra("orderId",intent.getStringExtra("orderId"));
                    String sellerName = seller.getName();
                    intent1.putExtra("sellerName",sellerName);
                    intent1.putExtra("title",intent.getStringExtra("title"));
                    intent1.putExtra("date",intent.getStringExtra("date"));
                    intent1.putExtra("price",intent.getStringExtra("price"));
                    startActivity(intent1);
                }
                else {
                    Intent intent1 = new Intent(OrderDetailActivity.this, DeliveredOrdersActivity.class);
                    intent1.putExtra("orderId",intent.getStringExtra("orderId"));
                    String sellerName = seller.getName();
                    intent1.putExtra("sellerName",sellerName);
                    intent1.putExtra("title",intent.getStringExtra("title"));
                    intent1.putExtra("date",intent.getStringExtra("date"));
                    intent1.putExtra("price",intent.getStringExtra("price"));
                    startActivity(intent1);                }

            }
        });


//        Retrofit retrofit = RestSingleTon.getRetrofit();
//        RestApi api = retrofit.create(RestApi.class);
//        SharedText sharedText = new SharedText(this);
//        String userId = sharedText.getUserId();
//        String orderId = getIntent().getStringExtra("orderId");
//        String url = AllURL.BASE_URL + "users/" + userId + "/manageOrders/" + orderId;
//        Call<OrderDetailModel> call = api.getOrder(sharedText.getCookie(),
//                url);
//        call.enqueue(new Callback<OrderDetailModel>() {
//            @Override
//            public void onResponse(Call<OrderDetailModel> call, Response<OrderDetailModel> response) {
//                if (response.isSuccessful()) {
//                    Toast.makeText(OrderDetailActivity.this, "success", Toast.LENGTH_SHORT).show();
//                } else {
//                    Toast.makeText(OrderDetailActivity.this, "some error "+response.errorBody()+"ando code "+response.code(), Toast.LENGTH_LONG).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<OrderDetailModel> call, Throwable throwable) {
//                Toast.makeText(OrderDetailActivity.this, "error " + throwable.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        Call<JSONObject> call = api.
//

    }
}