package com.example.login;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface PostApi {
    @POST("users/signin")
    Call<loginResponse> userlogin(@Body loginData data);

    @POST("users/signup")
    Call<Void> usersignup(@Body signupData data);

    @GET("/todolist/mypage")
    Call<mypageData> userTodo(@Header("Authorization") String Authorization);
}
