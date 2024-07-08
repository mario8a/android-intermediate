package com.mario8a.myapplication.ui.luck

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mario8a.myapplication.databinding.FragmentLuckBinding

class LuckFragment : Fragment() {
    private var _biding: FragmentLuckBinding? = null
    private val binding get() = _biding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _biding = FragmentLuckBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
}