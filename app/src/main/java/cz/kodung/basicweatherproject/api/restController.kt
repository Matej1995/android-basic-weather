package cz.kodung.basicweatherproject.api

import okhttp3.Interceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor


class RestController {

    init {
        buildRetrofit()
    }


    private fun buildRetrofit(): WeatherApi? {
        val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("")
                .client(httpClient())
                .build()

        return retrofit.create(WeatherApi::class.java)
    }

    private fun httpClient(): OkHttpClient? {
        return OkHttpClient.Builder().addInterceptor(getInterceptor()).build()
    }

    private fun getInterceptor(): Interceptor? {
        return HttpLoggingInterceptor(HttpLoggingInterceptor.Logger.DEFAULT).setLevel(HttpLoggingInterceptor.Level.BODY)
    }

}