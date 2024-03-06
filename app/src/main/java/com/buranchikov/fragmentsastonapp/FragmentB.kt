package com.buranchikov.fragmentsastonapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.buranchikov.fragmentsastonapp.databinding.FragmentBBinding

class FragmentB : Fragment() {
    private lateinit var binding: FragmentBBinding
//    private val fragmentC = FragmentC()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBBinding.inflate(inflater)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding.btnBtoA.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
        binding.btnBtoC.setOnClickListener {
//            parentFragmentManager.beginTransaction()
//                .replace(R.id.fragmentContainerView, fragmentC, "tag3")
//                .addToBackStack("pos3").commit()
        }
    }

}