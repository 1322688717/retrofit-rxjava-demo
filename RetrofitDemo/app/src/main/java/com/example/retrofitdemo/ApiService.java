package com.example.retrofitdemo;



import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    //https://devapi.qweather.com/v7/weather/now?location=101010100&key=66d721a1d6024ca8b6c257fcab036de7

    @GET("/v7/weather/now")
    Observable<BeanWeather> getNowWeather(@Query("key") String key, @Query("location") String location);

}
