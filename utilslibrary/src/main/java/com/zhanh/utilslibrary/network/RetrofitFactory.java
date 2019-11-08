package com.zhanh.utilslibrary.network;

import androidx.annotation.Nullable;

import com.alibaba.fastjson.support.retrofit.Retrofit2ConverterFactory;
import com.zhanh.utilslibrary.network.https.HttpsUtils;
import com.zhanh.utilslibrary.network.interceptor.CacheInterceptor;

import okhttp3.ConnectionPool;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.InputStream;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/**
 * Retrofit+RxJava网络请求封装
 */
public class RetrofitFactory {
    private volatile static RetrofitFactory singleton = null;
    private static final int DEFAULT_MILLISECONDS = 5 * 1000;//默认的超时时间
    private final Retrofit.Builder retrofitBuilder;
    private OkHttpClient.Builder okHttpClientBuilder;

    private RetrofitFactory() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        okHttpClientBuilder = new OkHttpClient().newBuilder()
                .hostnameVerifier(new DefaultHostnameVerifier())
                .readTimeout(DEFAULT_MILLISECONDS, TimeUnit.MILLISECONDS)
                .connectTimeout(DEFAULT_MILLISECONDS, TimeUnit.MILLISECONDS)
                .addInterceptor(httpLoggingInterceptor)
                .addNetworkInterceptor(new CacheInterceptor());

        retrofitBuilder = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(new Retrofit2ConverterFactory());

    }

    public static RetrofitFactory getInstance() {
        if (singleton == null){
            synchronized (RetrofitFactory.class){
                if (singleton == null){
                    singleton = new RetrofitFactory();
                }
            }
        }
        return singleton;
    }

    /**
     * 此类是用于主机名验证的基接口。 在握手期间，如果 URL 的主机名和服务器的标识主机名不匹配，
     * 则验证机制可以回调此接口的实现程序来确定是否应该允许此连接。策略可以是基于证书的或依赖于其他验证方案。
     * 当验证 URL 主机名使用的默认规则失败时使用这些回调。如果主机名是可接受的，则返回 true
     */
    public class DefaultHostnameVerifier implements HostnameVerifier {
        @Override
        public boolean verify(String hostname, SSLSession session) {
            return true;
        }
    }

    /**
     * https的全局访问规则
     */
    public RetrofitFactory setHostnameVerifier(HostnameVerifier hostnameVerifier) {
        okHttpClientBuilder.hostnameVerifier(hostnameVerifier);
        return this;
    }

    /**
     * https的全局自签名证书
     */
    public RetrofitFactory setCertificates(InputStream... certificates) {
        HttpsUtils.SSLParams sslParams = HttpsUtils.getSslSocketFactory(null, null, certificates);
        okHttpClientBuilder.sslSocketFactory(sslParams.sSLSocketFactory, sslParams.trustManager);
        return this;
    }

    /**
     * https双向认证证书
     */
    public RetrofitFactory setCertificates(InputStream bksFile, String password, InputStream... certificates) {
        HttpsUtils.SSLParams sslParams = HttpsUtils.getSslSocketFactory(bksFile, password, certificates);
        okHttpClientBuilder.sslSocketFactory(sslParams.sSLSocketFactory, sslParams.trustManager);
        return this;
    }

    /**
     * 全局读取超时时间
     */
    public RetrofitFactory setReadTimeOut(long readTimeOut) {
        okHttpClientBuilder.readTimeout(readTimeOut, TimeUnit.MILLISECONDS);
        return this;
    }

    /**
     * 全局写入超时时间
     */
    public RetrofitFactory setWriteTimeOut(long writeTimeout) {
        okHttpClientBuilder.writeTimeout(writeTimeout, TimeUnit.MILLISECONDS);
        return this;
    }

    /**
     * 全局连接超时时间
     */
    public RetrofitFactory setConnectTimeout(long connectTimeout) {
        okHttpClientBuilder.connectTimeout(connectTimeout, TimeUnit.MILLISECONDS);
        return this;
    }

    /**
     * 添加全局拦截器
     */
    public RetrofitFactory addInterceptor(Interceptor interceptor) {
        okHttpClientBuilder.addInterceptor(checkNotNull(interceptor, "interceptor == null"));
        return this;
    }

    /**
     * 添加全局网络拦截器
     */
    public RetrofitFactory addNetworkInterceptor(Interceptor interceptor) {
        okHttpClientBuilder.addNetworkInterceptor(checkNotNull(interceptor, "interceptor == null"));
        return this;
    }

    /**
     * 全局设置代理
     */
    public RetrofitFactory setOkproxy(Proxy proxy) {
        okHttpClientBuilder.proxy(checkNotNull(proxy, "proxy == null"));
        return this;
    }

    /**
     * 全局设置请求的连接池
     */
    public RetrofitFactory setOkconnectionPool(ConnectionPool connectionPool) {
        okHttpClientBuilder.connectionPool(checkNotNull(connectionPool, "connectionPool == null"));
        return this;
    }

    /**
     * 全局为Retrofit设置自定义的OkHttpClient
     */
    public RetrofitFactory setOkclient(OkHttpClient.Builder okHttpClientBuilder) {
        this.okHttpClientBuilder = (checkNotNull(okHttpClientBuilder, "OkHttpClient.Builder == null"));
        return this;
    }


    /**
     * 根据Api接口类生成Api实体
     * @param baseUrl baseUrl
     * @param clazz   传入的Api接口类
     * @return Api实体类
     */
    public <T> T create(String baseUrl, Class<T> clazz) {
        retrofitBuilder.client(okHttpClientBuilder.build());
        return retrofitBuilder.baseUrl(baseUrl).build().create(clazz);
    }

    private <T> T checkNotNull(@Nullable T object, String message) {
        if (object == null) {
            throw new NullPointerException(message);
        }
        return object;
    }



}

