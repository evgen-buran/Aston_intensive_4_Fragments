package com.buranchikov.fragmentsastonapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.buranchikov.fragmentsastonapp.databinding.FragmentDBinding

class FragmentD : Fragment() {
    private lateinit var binding: FragmentDBinding
    private val fragmentB = FragmentB()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding.btnDtoB.setOnClickListener {
            while (parentFragmentManager.findFragmentByTag("tag3")!=FragmentB())
                parentFragmentManager.popBackStack()
        }
    }

}