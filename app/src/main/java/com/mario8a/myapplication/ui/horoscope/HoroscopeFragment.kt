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
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.mario8a.myapplication.databinding.FragmentHoroscopeBinding
import com.mario8a.myapplication.domain.model.HoroscopeInfo.*
import com.mario8a.myapplication.domain.model.HoroscopeModel
import com.mario8a.myapplication.ui.horoscope.adapter.HoroscopeAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HoroscopeFragment : Fragment() {

    //conectando el viewmodel con el fragment
    private val horoscopeViewModel by viewModels<HoroscopeViewModel>()
    private lateinit var horoscopeAdapter: HoroscopeAdapter // Para mostrar en pantalla

    private var _biding: FragmentHoroscopeBinding? = null
    private val binding get() = _biding!!

    // Busco este metodo desde Code>OverrideMethods
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    private fun initUI() {
        initList() // initRecyclerView
        initUIState()
    }

    private fun initList() {
        horoscopeAdapter = HoroscopeAdapter(onItemSelected = {
            val type = when(it) {
                Aquarius -> HoroscopeModel.Aquarius
                Aries -> HoroscopeModel.Aries
                Cancer -> HoroscopeModel.Cancer
                Capricorn -> HoroscopeModel.Capricorn
                Gemini -> HoroscopeModel.Gemini
                Leo -> HoroscopeModel.Leo
                Libra -> HoroscopeModel.Libra
                Pisces -> HoroscopeModel.Pisces
                Sagittarius -> HoroscopeModel.Sagittarius
                Scorpio -> HoroscopeModel.Scorpio
                Taurus -> HoroscopeModel.Taurus
                Virgo -> HoroscopeModel.Virgo
            }
            findNavController().navigate(
                HoroscopeFragmentDirections.actionHoroscopeFragmentToHoroscopeDetailActivity(type)
            )
        })
        binding.rvHoroscope.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = horoscopeAdapter
        }

    }

    private fun initUIState() {
        //enganchando al Model
        // Corrutinas: Es una forma de gestionar hilos para realizar tareas ya sea en segundo plano o primer
        lifecycleScope.launch {
            // Esta corrutina se encgancha al ciclo de vida del fragment
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                horoscopeViewModel.horoscope.collect { // El collect es como decir enganchate a el
                    Log.i("Mario", it.toString())
                    // CAMBIOS EN HOROSCOPE
                    horoscopeAdapter.updateList(it)
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