package net.dkr.freelancing.auth;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

import net.dkr.freelancing.MainActivity;
import net.dkr.freelancing.SellerMainActivity;
import net.dkr.freelancing.model.LoginModel;
import net.dkr.freelancing.util.AddCookieInterceptor;
import net.dkr.freelancing.util.AllURL;
import net.dkr.freelancing.ChosserActivity;
import net.dkr.freelancing.R;
import net.dkr.freelancing.util.GetCookieInterceptor;
import net.dkr.freelancing.util.RestApi;
import net.dkr.freelancing.util.SharedText;

import org.json.JSONObject;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {

    Button btnSignup,btnLogin;
    TextInputLayout etEmail,etPassword;

    RestApi restApi;
    Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etEmail = findViewById(R.id.editTextEmailSignIn);
        etPassword = findViewById(R.id.editTextPasswordlSignIn);
        btnLogin = findViewById(R.id.btnLogin);
        btnSignup = findViewById(R.id.btnSignup);


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
                Intent intent = new Intent(LoginActivity.this,SignupActivity.class);
                startActivity(intent);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email,password;
                email = etEmail.getEditText().getText().toString();
                password = etPassword.getEditText().getText().toString();

                if (email.isEmpty() || password.isEmpty()){
                    Toast.makeText(LoginActivity.this, "please provide all field", Toast.LENGTH_SHORT).show();
                    etEmail.setError("please provide all field");
                }
                else {
                    Call<SignUpResponse> call = restApi.loginUser(new LoginModel(email,password));

                    call.enqueue(new Callback<SignUpResponse>() {
                       @Override
                       public void onResponse(Call<SignUpResponse> call, Response<SignUpResponse> response) {
                           if (response.isSuccessful()){
                               SharedText sharedText = new SharedText(LoginActivity.this);
                               sharedText.setUserId(response.body().getUser().getId());
                               boolean isSeller = response.body().getUser().getSeller();
                               if (isSeller) {
                                   sharedText.setLog("log");
                                   sharedText.setUserText(isSeller);
                                   Intent i = new Intent(LoginActivity.this, SellerMainActivity.class);
                                   i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                   startActivity(i);
                                   finish();
                               } else {
                                   sharedText.setLog("log");
                                   sharedText.setUserText(isSeller);
                                   Intent i = new Intent(LoginActivity.this, MainActivity.class);
                                   i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                   startActivity(i);
                                   finish();
                               }


                           }
                           else {
                               Toast.makeText(LoginActivity.this, "not login", Toast.LENGTH_SHORT).show();
                           }
                       }

                       @Override
                       public void onFailure(Call<SignUpResponse> call, Throwable throwable) {

                           Toast.makeText(LoginActivity.this, "error "+throwable.getMessage(), Toast.LENGTH_SHORT).show();
                           etEmail.setError("Error "+throwable.getMessage());
                       }
                   });
                }
            }
        });
    }
}