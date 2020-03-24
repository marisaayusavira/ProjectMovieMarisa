package com.example.project3.network;

import com.example.project3.BuildConfig;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApService {
    private Apinterface apInterface;

    public ApService(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .client(builder())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apInterface = retrofit.create(Apinterface.class);
    }

    private OkHttpClient builder() {
        OkHttpClient.Builder okHttpClient = new OkHttpClient().newBuilder();

        okHttpClient.connectTimeout(20, TimeUnit.SECONDS);
        okHttpClient.writeTimeout(20, TimeUnit.SECONDS);
        okHttpClient.readTimeout(20, TimeUnit.SECONDS);

        if(BuildConfig.DEBUG){
            okHttpClient.addInterceptor(interceptor());
        }
        okHttpClient.addInterceptor(new Interceptor() {

            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request =chain.request();
                HttpUrl url =request.url()
                        .newBuilder()
                        .addQueryParameter("api_key",Constant.API_KEY)
                        .addQueryParameter("language",Constant.LANG_EN)
                        .build();
                request = request.newBuilder().url(url).build();
                return chain.proceed(request);
            }
        });
        return okHttpClient.build();
    }

    private static HttpLoggingInterceptor interceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        return interceptor;
    }

    public void getPopularMovies(int page, Callback callback) {
        apInterface.popularMovies(page).enqueue(callback);
    }


}
