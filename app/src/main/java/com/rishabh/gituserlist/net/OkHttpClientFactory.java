package com.rishabh.gituserlist.net;

import android.text.TextUtils;
import android.util.Base64;

import com.rishabh.gituserlist.BuildConfig;
import com.rishabh.gituserlist.core.GithubCredentials;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpClientFactory {

    private static final Object lock = new Object();
    private static OkHttpClient okHttpClient;

    private OkHttpClientFactory() {
    }

    public static OkHttpClient getInstance() {
        if (okHttpClient == null) {
            synchronized (lock) {
                if (okHttpClient == null) {
                    OkHttpClient.Builder builder = new OkHttpClient.Builder()
                            .connectTimeout(10, TimeUnit.SECONDS)
                            .readTimeout(10, TimeUnit.SECONDS)
                            .addNetworkInterceptor(new Interceptor() { // Add Interceptor to add necessary
                                // Headers
                                @Override
                                public Response intercept(Chain chain) throws IOException {
                                    Request.Builder reqBuilder = chain.request().newBuilder();
                                    reqBuilder.addHeader("Accept", "application/vnd.github.v3+json");
                                    if (!TextUtils.isEmpty(GithubCredentials.USERNAME) && !TextUtils
                                            .isEmpty(GithubCredentials.PERSONAL_ACCESS_TOKEN)) {
                                        reqBuilder.addHeader("Authorization", "Basic " +
                                                Base64.encodeToString(String.format("%s:%s",
                                                        GithubCredentials.USERNAME, GithubCredentials
                                                                .PERSONAL_ACCESS_TOKEN).getBytes(),
                                                        Base64.NO_WRAP));
                                    }
                                    return chain.proceed(reqBuilder.build());
                                }
                            });

                    if (BuildConfig.DEBUG) {
                        builder.addNetworkInterceptor(new com.facebook.stetho.okhttp3.StethoInterceptor());
                        // Add Stetho Interceptor for easy debugging
                    }

                    okHttpClient = builder.build();
                }
            }
        }
        return okHttpClient;
    }
}
