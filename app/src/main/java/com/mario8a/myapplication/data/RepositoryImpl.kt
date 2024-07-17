package com.mario8a.myapplication.data

import android.util.Log
import com.mario8a.myapplication.data.network.HoroscopeApiService
import com.mario8a.myapplication.domain.Repository
import com.mario8a.myapplication.domain.model.PredictionModel
import javax.inject.Inject

// Esta clase va a extender de Repository
// Esta implementacion va hacer toda la magia y se la va enviar al dominio
class RepositoryImpl @Inject constructor(private val apiService: HoroscopeApiService) : Repository {

    override suspend fun getPrediction(sign: String): PredictionModel? {
        // Peticion retrofit
        // runCatching es una forma de ejecutar una tarea
        runCatching { apiService.getHoroscope(sign) }
            .onSuccess { return it.toDomain() }
            .onFailure { Log.i("mario8a", "Ha ocurrido un error ${it.message}") }

        return null
    }
}