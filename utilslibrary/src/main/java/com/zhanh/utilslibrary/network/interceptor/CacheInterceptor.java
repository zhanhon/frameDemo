package com.zhanh.utilslibrary.network.interceptor;

import android.text.TextUtils;


import com.zhanh.utilslibrary.util.NetUtils;
import com.zhanh.utilslibrary.util.disklrucache.DiskCacheManager;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * 缓存拦截器
 */
public class CacheInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        String cacheTime = request.header("Cache-Time");
        if (!TextUtils.isEmpty(cacheTime)) {//是否需要配置缓存
            String url = request.url().url().toString();
            if (NetUtils.isNetworkConnected()) {
                Response response = chain.proceed(request);
                //有网
                if (response.isSuccessful()) {
                    String body = response.body().string();//最能调取一次
                    DiskCacheManager.getDiskCacheManager().put(url,body);//缓存

                    ResponseBody responseBody = ResponseBody.create(MediaType.parse(body),body);
                    return response
                            .newBuilder()
                            .body(responseBody)
                            .build();
                }
            } else {
                //无网获取缓存
                String body = DiskCacheManager.getDiskCacheManager().getString(url);
                if (body != null){
                    ResponseBody responseBody = ResponseBody.create(MediaType.parse(body),body);
                    return new Response.Builder()
                            .removeHeader("Pragma")
                            .removeHeader("Cache-Control")
                            .body(responseBody)
                            .request(request)
                            .message("")
                            .protocol(Protocol.HTTP_1_1)
                            .code(200)
                            .build();
                }
            }
        }
        return chain.proceed(request);
    }
}
