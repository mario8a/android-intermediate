package com.mario8a.myapplication.ui.horoscope

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mario8a.myapplication.databinding.FragmentHoroscopeBinding

class HoroscopeFragment : Fragment() {
    private var _biding: FragmentHoroscopeBinding? = null
    private val binding get() = _biding!!

    // onCreateView forma parte del ciclo de vida, este es el que crea la vista del fragment
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _biding = FragmentHoroscopeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
}