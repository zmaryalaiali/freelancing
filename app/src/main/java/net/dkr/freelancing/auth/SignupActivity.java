package net.dkr.freelancing.auth;



import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

import net.dkr.freelancing.R;
import net.dkr.freelancing.RestApi;

import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class SignupActivity extends AppCompatActivity {

    TextInputLayout etEmail,etUserName,etPassword,etPasswordConfirm;

    Button btnSignup;

    TextView tvTermOfServices;

    RestApi restApi ;
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

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                        .baseUrl(AllURL.BASE_URL)
                                .build();

        restApi = retrofit.create(RestApi.class);



        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email,password,passwordConfirm,userName;
                email = etEmail.getEditText().getText().toString();
                userName = etUserName.getEditText().getText().toString();
                passwordConfirm = etPasswordConfirm.getEditText().getText().toString();
                password = etPassword.getEditText().getText().toString();

                if (email.isEmpty() || userName.isEmpty() || password.isEmpty() || passwordConfirm.isEmpty()){

                }
                else {
                    Call<JSONObject> call = restApi.createUser(new SignupModel(userName,email,password,passwordConfirm));
                    call.enqueue(new Callback<JSONObject>() {
                        @Override
                        public void onResponse(Call<JSONObject> call, Response<JSONObject> response) {
                            if (response.isSuccessful()){
                                String str = null;
                                try {
                                    str = response.body().getString("status");
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                                Intent intent = new Intent(SignupActivity.this,LoginActivity.class);
                                startActivity(intent);
                                Toast.makeText(SignupActivity.this, "response "+response.body().toString(), Toast.LENGTH_SHORT).show();
                            }
                            else {
                                Toast.makeText(SignupActivity.this, "unknown response", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<JSONObject> call, Throwable throwable) {
                            Toast.makeText(SignupActivity.this, "error "+throwable.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });




    }
}