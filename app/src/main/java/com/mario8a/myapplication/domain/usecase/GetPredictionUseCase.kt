package com.mario8a.myapplication.domain.usecase

import com.mario8a.myapplication.domain.Repository
import javax.inject.Inject

// un caso de uso es una clase que tiene una unica responsabilidad
// El viewmodel va llamar al caso de uso
// Recupera lo necesario para realizar la accion
// Crear otro provider en el network module que provea el repositorio
// No es necesario siempre crear casos de uso, para este caso solo usamos una funcion
// Pero se podria colocar directamente el repository en el viewModel
class GetPredictionUseCase @Inject constructor(private val repository: Repository) {
    // operator permite sobreescribir algunas funciones de la creacion de esta clase
    suspend operator fun invoke(sign: String) = repository.getPrediction(sign)
}