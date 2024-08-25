package net.dkr.freelancing;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.resources.Compatibility;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.PackageManagerCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import net.dkr.freelancing.model.SubmitProposalModel;
import net.dkr.freelancing.util.RealPathUtil;
import net.dkr.freelancing.util.RestApi;
import net.dkr.freelancing.util.RestSingleTon;
import net.dkr.freelancing.util.SharedText;

import org.json.JSONObject;

import java.io.File;
import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class SubmitProposalActivity extends AppCompatActivity {

    TextView btnAttachFile;
    ImageView imageView;
    SharedText sharedText;
    EditText etCoverLetter;
    String path;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_proposal);
etCoverLetter = findViewById(R.id.et_submit_coverLetter);
      imageView = findViewById(R.id.iv_submit_image);

        btnAttachFile = findViewById(R.id.btn_submit_proposal_attachFile);

        sharedText = new SharedText(this);

        btnAttachFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (ContextCompat.checkSelfPermission(SubmitProposalActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(SubmitProposalActivity.this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},1);
                }
                else {
                    Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(intent,1);
                }


            }
        });
    }

    public void submit(View view) {

        Retrofit retrofit = RestSingleTon.getRetrofit();
        RestApi  api = retrofit.create(RestApi.class);
        File file = new File(path);
        RequestBody body  = RequestBody.create(MediaType.parse("multipart/form-data"),file);
        MultipartBody.Part part = MultipartBody.Part.createFormData("images",file.getName(),body);

        RequestBody cover = RequestBody.create(MediaType.parse("multipart/form-data"),etCoverLetter.getText().toString());

        RequestBody link = RequestBody.create(MediaType.parse("multipart/form-data"),"uhuygugtdftgu");

        Call<SubmitProposalModel> call = api.submitProposal(sharedText.getCookie(),
                sharedText.getUserId(),getIntent().getStringExtra("jobId"),part,link,cover);
        call.enqueue(new Callback<SubmitProposalModel>() {
            @Override
            public void onResponse(Call<SubmitProposalModel> call, Response<SubmitProposalModel> response) {
                if (response.isSuccessful()){
                    finish();
                }
                else {
                    Toast.makeText(SubmitProposalActivity.this, "some Error "+response.errorBody(), Toast.LENGTH_SHORT).show();
                    etCoverLetter.setText(response.errorBody() +" and "+ response.code());
                }
            }

            @Override
            public void onFailure(Call<SubmitProposalModel> call, Throwable throwable) {
                Toast.makeText(SubmitProposalActivity.this, "error "+throwable.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void cancel(View view) {
        finish();
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
            path = RealPathUtil.getRealPath(SubmitProposalActivity.this,uri);
            Bitmap bitmap = null;
            try {
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(),data.getData());
            } catch (IOException e) {
                e.fillInStackTrace();
            }

            imageView.setImageBitmap(bitmap);


        }
    }
}