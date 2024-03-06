package com.buranchikov.fragmentsastonapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.buranchikov.fragmentsastonapp.databinding.FragmentCBinding

class FragmentC : Fragment() {
    private lateinit var binding: FragmentCBinding
    private val fragmentD = FragmentD()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding.btnCtoA.setOnClickListener {
        while (parentFragmentManager.findFragmentByTag("tag2")!=FragmentA())
            parentFragmentManager.popBackStack()
        }
        binding.btnCtoD.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, fragmentD, "tag4")
                .addToBackStack("pos4").commit()
        }
    }

}