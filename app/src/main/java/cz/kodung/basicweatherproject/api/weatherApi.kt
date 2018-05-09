package cz.kodung.basicweatherproject.api

import cz.kodung.basicweatherproject.entity.Weather
import io.reactivex.Single
import retrofit2.http.GET


interface WeatherApi {

    @GET("")
    fun loadWeather(): Single<Weather>
}