package com.example.egyadv.Retrofitclient;

import com.example.egyadv.Model.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface APi {
    @FormUrlEncoded
    @POST("loginUser")
    Call<LoginResponse> LoginUser(
            @Field("user_email")String email ,
            @Field("password")String password








    );

}
