package com.mario8a.myapplication.data.network.response

import com.google.gson.annotations.SerializedName
import com.mario8a.myapplication.domain.model.PredictionModel

// Lo que esta dentro de SerializedName debe coincidir con la response de la API que retorna
data class PredictionResponse(
    @SerializedName("date") val date: String,
    @SerializedName("horoscope") val horoscope: String,
    @SerializedName("sign") val sign: String,
) {
    fun toDomain(): PredictionModel {
        return PredictionModel(
            horoscope = horoscope,
            sign = sign
        )
    }
}