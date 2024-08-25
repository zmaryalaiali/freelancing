package net.dkr.freelancing.auth;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

import net.dkr.freelancing.MainActivity;
import net.dkr.freelancing.R;
import net.dkr.freelancing.SellerMainActivity;
import net.dkr.freelancing.model.SignupModel;
import net.dkr.freelancing.util.AddCookieInterceptor;
import net.dkr.freelancing.util.AllURL;
import net.dkr.freelancing.util.GetCookieInterceptor;
import net.dkr.freelancing.util.RestApi;
import net.dkr.freelancing.util.RestSingleTon;
import net.dkr.freelancing.util.SharedText;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.CookieManager;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class SignupActivity extends AppCompatActivity {

    TextInputLayout etEmail, etUserName, etUSerLastName, etPassword, etPasswordConfirm;

    Button btnSignup;

    TextView tvTermOfServices;

    RestApi restApi;
    Retrofit retrofit;

    boolean isSeller;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        etEmail = findViewById(R.id.editTextEmail);
        etUserName = findViewById(R.id.editTextUserName);
        etPassword = findViewById(R.id.editTextPassword);
        etPasswordConfirm = findViewById(R.id.editTextConforme);
        btnSignup = findViewById(R.id.buttonSignUp);
        tvTermOfServices = findViewById(R.id.TermOfServices);
        etUSerLastName = findViewById(R.id.editTextUserLastName);

        isSeller = getIntent().getBooleanExtra("isSeller", false);


        OkHttpClient client = new OkHttpClient();
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addInterceptor(new AddCookieInterceptor(this)); // VERY VERY IMPORTANT
        builder.addInterceptor(new GetCookieInterceptor(this)); // VERY VERY IMPORTANT
        builder.addInterceptor(logging);
        client = builder.build();

        retrofit = new Retrofit.Builder().
                baseUrl(AllURL.BASE_URL).
                addConverterFactory(GsonConverterFactory.create()).
                client(client).
                build();

        restApi = retrofit.create(RestApi.class);

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email, password, passwordConfirm, userName, userLastName;
                email = etEmail.getEditText().getText().toString();
                userName = etUserName.getEditText().getText().toString();
                passwordConfirm = etPasswordConfirm.getEditText().getText().toString();
                password = etPassword.getEditText().getText().toString();
                userLastName = etUSerLastName.getEditText().getText().toString();


                if (email.isEmpty() || userName.isEmpty() || userLastName.isEmpty() || password.isEmpty() || passwordConfirm.isEmpty()) {
                    Toast.makeText(SignupActivity.this, "All fieled required", Toast.LENGTH_SHORT).show();
                    etEmail.setError("All field required");
                } else {
                    Call<SignUpResponse> call = restApi.createUser(new SignupModel(userName, userLastName, email, password, passwordConfirm, isSeller));
                    call.enqueue(new Callback<SignUpResponse>() {
                        @Override
                        public void onResponse(Call<SignUpResponse> call, Response<SignUpResponse> response) {
                            if (response.isSuccessful()) {
                                String name = null, id = null;
                                SharedText sharedText = new SharedText(SignupActivity.this);
                                sharedText.setUserId(id);
                                sharedText.setUserId(response.body().getUser().getId());
                                if (isSeller) {
                                    sharedText.setLog("log");
                                    sharedText.setUserText(isSeller);
                                    Intent i = new Intent(SignupActivity.this, SellerMainActivity.class);
                                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                    startActivity(i);
                                    finish();
                                } else {
                                    sharedText.setLog("log");
                                    sharedText.setUserText(isSeller);
                                    Intent i = new Intent(SignupActivity.this, MainActivity.class);
                                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                    startActivity(i);
                                    finish();
                                }

                                Toast.makeText(SignupActivity.this, "id " + id + "name " + name + " is seller " + isSeller, Toast.LENGTH_SHORT).show();

                                Toast.makeText(SignupActivity.this, "response " + response.body().toString(), Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(SignupActivity.this, "unknown response", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<SignUpResponse> call, Throwable throwable) {
                            Toast.makeText(SignupActivity.this, "error " + throwable.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });


    }
}