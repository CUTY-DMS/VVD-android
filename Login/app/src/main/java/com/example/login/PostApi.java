package com.example.login;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface PostApi {
    @POST("user/signin")
    Call<loginRequest> userlogin(@Body loginData data);

    @POST("user/signup")
    Call<Void> usersignup(@Body signupData data);
}
