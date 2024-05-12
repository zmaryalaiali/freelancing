package net.dkr.freelancing.auth;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

import net.dkr.freelancing.MainActivity;
import net.dkr.freelancing.R;
import net.dkr.freelancing.RestApi;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {

    Button btnSignup,btnLogin;
    TextInputLayout etEmail,etPassword;

    RestApi restApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        etEmail = findViewById(R.id.editTextEmailSignIn);
        etPassword = findViewById(R.id.editTextPasswordlSignIn);
        btnLogin = findViewById(R.id.btnLogin);
        btnSignup = findViewById(R.id.btnSignup);


        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(AllURL.BASE_URL)
                .build();

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
                }
                else {
                    Call<JSONObject> call = restApi.loginUser(new LoginModel(email,password));
                   call.enqueue(new Callback<JSONObject>() {
                       @Override
                       public void onResponse(Call<JSONObject> call, Response<JSONObject> response) {
                           if (response.isSuccessful()){

                               Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                               startActivity(intent);
                               Toast.makeText(LoginActivity.this, "login", Toast.LENGTH_SHORT).show();
                           }
                           else {
                               Toast.makeText(LoginActivity.this, "not login", Toast.LENGTH_SHORT).show();
                           }
                       }

                       @Override
                       public void onFailure(Call<JSONObject> call, Throwable throwable) {

                           Toast.makeText(LoginActivity.this, "error "+throwable.getMessage(), Toast.LENGTH_SHORT).show();
                       }
                   });
                }
            }
        });
    }
}