package com.mario8a.myapplication.ui.palmistry

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mario8a.myapplication.databinding.FragmentPalmistryBinding

class PalmistryFragment : Fragment() {
    private var _biding: FragmentPalmistryBinding? = null
    private val binding get() = _biding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _biding = FragmentPalmistryBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
}