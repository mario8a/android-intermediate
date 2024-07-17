package com.mario8a.myapplication.data.network

import com.mario8a.myapplication.data.network.response.PredictionResponse
import retrofit2.http.GET
import retrofit2.http.Path

// Interface que define los endpoints, la ruta y tipo de peticion
interface HoroscopeApiService {

    @GET("/{sign}")
    suspend fun getHoroscope(@Path("sign") sign: String): PredictionResponse
}