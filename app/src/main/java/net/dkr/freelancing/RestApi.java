package net.dkr.freelancing;

import net.dkr.freelancing.auth.LoginModel;
import net.dkr.freelancing.auth.SignupActivity;
import net.dkr.freelancing.auth.SignupModel;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RestApi {

    @POST("signup")
    Call<JSONObject> createUser(@Body SignupModel signupModel);

  @POST("signin")
    Call<JSONObject> loginUser(@Body LoginModel loginModel);

}
