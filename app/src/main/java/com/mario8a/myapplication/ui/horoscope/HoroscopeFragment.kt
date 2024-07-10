package com.mario8a.myapplication.ui.horoscope

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.mario8a.myapplication.databinding.FragmentHoroscopeBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HoroscopeFragment : Fragment() {

    //conectando el viewmodel con el fragment
    private val horoscopeViewModel by viewModels<HoroscopeViewModel>()

    private var _biding: FragmentHoroscopeBinding? = null
    private val binding get() = _biding!!

    // Busco este metodo desde Code>OverrideMethods
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    private fun initUI() {
        initUIState()
    }

    private fun initUIState() {
        //enganchando al Model
        // Corrutinas: Es una forma de gestionar hilos para realizar tareas ya sea en segundo plano o primer
        lifecycleScope.launch {
            // Esta corrutina se encgancha al ciclo de vida del fragment
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                horoscopeViewModel.horoscope.collect { // El collect es como decir enganchate a el
                    Log.i("Mario", it.toString())
                }
            }
        }
    }

    // onCreateView forma parte del ciclo de vida, este es el que crea la vista del fragment
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _biding = FragmentHoroscopeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
}