package com.example.retrofitdemo;


import android.util.Log;


import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class UlitsRetrofit {

    public static void getNowWeather(String key,String location) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        Retrofit retrofit = new Retrofit.Builder()
                .client(builder.build())
                .baseUrl("https://devapi.qweather.com")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        Observable<BeanWeather> observable =  apiService.getNowWeather(key,location);
                observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BeanWeather>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BeanWeather beanWeather) {
                        String temp = beanWeather.getNow().getTemp();
                        Log.w("TAG","temp==========="+temp);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
