package com.example.login;

import android.media.session.MediaSession;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.HEAD;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface AddApi {
    @POST("todolist/create")
    Call<Void> usercontent(
            @Header("Authorization") String Authorization,
            @Body ContentData contentData
    );
}
