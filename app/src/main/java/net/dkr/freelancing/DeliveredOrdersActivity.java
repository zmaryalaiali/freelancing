package net.dkr.freelancing;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import net.dkr.freelancing.model.DeliveryWorkModel;
import net.dkr.freelancing.model.RecentModel;
import net.dkr.freelancing.util.RealPathUtil;
import net.dkr.freelancing.util.RestApi;
import net.dkr.freelancing.util.RestSingleTon;
import net.dkr.freelancing.util.SharedText;

import java.io.File;
import java.io.IOException;

import okhttp3.Cache;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class DeliveredOrdersActivity extends AppCompatActivity {
    TextView tvSellerName, tvTitle, tvPrice, tvTime;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivered_orders);
        tvTitle = findViewById(R.id.tv_order_tital_buyer);
        tvSellerName = findViewById(R.id.tv_order_detail_delivered_buyerName);

//        tvDeliveryDate = findViewById(R.id.tv_order_deleaveryTime);
//        tvOrderPrice = findViewById(R.id.tv_order_detail_price);
//        tvOrderNumber = findViewById(R.id.tv_order_detail_buyerId);
//        tvDeliveryTimeRemain = findViewById(R.id.tv_deliver_time_remaind);

        Intent intent = getIntent();
//        RecentModel.User seller = (RecentModel.User) intent.getSerializableExtra("seller");
//        RecentModel.User buyer =(RecentModel.User) intent.getSerializableExtra("buyer");
//        String sellerName = intent.getStringExtra("sellerName");
//        tvSellerName.setText(sellerName);
//        tvTitle.setText(intent.getStringExtra("title"));
    }
}