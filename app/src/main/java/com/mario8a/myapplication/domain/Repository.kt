package com.mario8a.myapplication.domain
import com.mario8a.myapplication.domain.model.PredictionModel

// un repositorio va hacer la comunicacion que va tener la capa de data y dominio
// Se definen las cosas que se necesitan de data
// El dominio solo sabe leer una interfaz, por ejemplo aqui dice que quiere una predicion pero le da igual como la haga

// NO deberia saber que existe un PredictionResponse, debe ser el predictionModel
interface Repository {
    suspend fun getPrediction(sign: String): PredictionModel?
}