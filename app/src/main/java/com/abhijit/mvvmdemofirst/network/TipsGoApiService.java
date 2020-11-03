package com.abhijit.mvvmdemofirst.network;


import com.google.gson.JsonElement;

import io.reactivex.Single;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface TipsGoApiService {

    @POST("LodhaSM/api/loginapp")
    @FormUrlEncoded
    Single<JsonElement> loginUser(@Field("username") String username,
                                  @Field("password") String password,
                                  @Field("version_code") int version_code,
                                  @Field("token") String token);

   /* @POST("LodhaSM/api/loginapp")
    @FormUrlEncoded
    Single<JsonElement> listData(@Field("username") String username,
                                  @Field("password") String passwordn);
*/
}
