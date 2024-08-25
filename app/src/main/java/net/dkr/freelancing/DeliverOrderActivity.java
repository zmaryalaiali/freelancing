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

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import net.dkr.freelancing.model.DeliveryWorkModel;
import net.dkr.freelancing.util.RealPathUtil;
import net.dkr.freelancing.util.RestApi;
import net.dkr.freelancing.util.RestSingleTon;
import net.dkr.freelancing.util.SharedText;

import java.io.File;
import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class DeliverOrderActivity extends AppCompatActivity {
    TextView upload;

    EditText etMessage;
    Button btnUpload;

    String path;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deliver_order);
        upload = findViewById(R.id.tv_upload_work);
        etMessage = findViewById(R.id.et_comment_to_buyer);
        btnUpload = findViewById(R.id.btn_deliver_work);



        SharedText sharedText = new SharedText(this);
        String currentUserId = sharedText.getUserId();
        String orderId = getIntent().getStringExtra("orderId");

        Retrofit retrofit = RestSingleTon.getRetrofit();
        RestApi api = retrofit.create(RestApi.class);

        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(DeliverOrderActivity.this, android.Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(DeliverOrderActivity.this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},1);
                }
                else {
                    Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(intent,1);
                }
            }
        });

        btnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Gson gson = new GsonBuilder()
                        .setLenient()
                        .create();
                File file = new File(path);
                RequestBody body  = RequestBody.create(MediaType.parse("multipart/form-data"),file);
                MultipartBody.Part part = MultipartBody.Part.createFormData("files",file.getName(),body);

                RequestBody cover = RequestBody.create(MediaType.parse("multipart/form-data"),etMessage.getText().toString());
//
                RequestBody link = RequestBody.create(MediaType.parse("multipart/form-data"),file.getName());
//
                Call<String> call = api.delivery(sharedText.getCookie(),currentUserId,orderId,part,cover);
                call.enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        if (response.isSuccessful()){

                        }else {
                            Toast.makeText(DeliverOrderActivity.this, "some Error "+response.errorBody(), Toast.LENGTH_SHORT).show();
                        }
                    }
                    @Override
                    public void onFailure(Call<String> call, Throwable throwable) {
                        Toast.makeText(DeliverOrderActivity.this, "Error "+throwable.getMessage(), Toast.LENGTH_LONG).show();
                        etMessage.setText("error "+throwable.getMessage());
                    }
                });
            }
        });


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1 && grantResults.length > 0 && grantResults[0]== PackageManager.PERMISSION_GRANTED){
            Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(intent,1);
        }
        else {
            finish();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK && data != null){
            Uri uri = data.getData();
            path = RealPathUtil.getRealPath(DeliverOrderActivity.this,uri);
            Bitmap bitmap = null;
            try {
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(),data.getData());
            } catch (IOException e) {
                e.fillInStackTrace();
            }



        }
    }
}