package com.mario8a.myapplication.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mario8a.myapplication.domain.model.HoroscopeModel
import com.mario8a.myapplication.domain.usecase.GetPredictionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

// Injectan los casos de uso
@HiltViewModel
class HoroscopeDetailViewModel @Inject constructor(private val getPredictionUseCase: GetPredictionUseCase): ViewModel() {

    private var _state = MutableStateFlow<HoroscopeDetailState>(HoroscopeDetailState.Loading)
    val state: StateFlow<HoroscopeDetailState> = _state

    lateinit var horoscope: HoroscopeModel

    fun getHoroscope(sign: HoroscopeModel) {
        horoscope = sign
        // se debe llamar a una corrutina con viewModelScope
        // (Dispatchers.IO) se asigna un hilo, si no se coloca entonces se asigna el hilo principal
        viewModelScope.launch {
            // Hilo principal
            _state.value = HoroscopeDetailState.Loading
            val result = withContext(Dispatchers.IO) { getPredictionUseCase(sign.name) } // Hilo secundario
            // Hilo principal
            if (result != null) {
                _state.value = HoroscopeDetailState.Success(result.horoscope, result.sign, horoscope)
            } else{
                _state.value = HoroscopeDetailState.Error("Ha ocurrido un error, intentelo mas tarde")
            }
        }
    }
}