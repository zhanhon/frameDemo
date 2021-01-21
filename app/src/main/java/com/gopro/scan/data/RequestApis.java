package com.gopro.scan.data;

import com.zhanh.utilslibrary.network.response.ResponseEntity;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;


/**
 * 请求的接口
 */
public interface RequestApis {
    //生效场景
    @GET("lora/stage")
    Observable<ResponseEntity<String>> loraStage(@Query("type") int type);

    @POST("login")
    @FormUrlEncoded
    Observable<ResponseEntity<String>> login(@Field("user") String user, @Field("pwd") String pwd);


}
