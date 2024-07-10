package com.mario8a.myapplication.ui.horoscope

import androidx.lifecycle.ViewModel
import com.mario8a.myapplication.domain.model.HoroscopeInfo
import com.mario8a.myapplication.domain.model.HoroscopeInfo.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class HoroscopeViewModel @Inject constructor():ViewModel() {
    // Flows, programacion reactiva? Comunicacion activa cuando haya cambios
    // creamos un mutable que no pueda ser modificado desde fuera
    // el stateFlow no es mutable lee los datos del private pero no va poder modificarlo
    private var _horoscope = MutableStateFlow<List<HoroscopeInfo>>(emptyList())
    val horoscope:StateFlow<List<HoroscopeInfo>> = _horoscope

    init {
        // es como un onCreate
        // Primer se inicializa como una lista vacia pero cuando se cree va llamar a esto
        _horoscope.value = listOf(
            Aries, Taurus, Gemini
        )
    }

}