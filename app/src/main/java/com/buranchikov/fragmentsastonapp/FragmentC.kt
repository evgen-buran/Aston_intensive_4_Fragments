package com.buranchikov.fragmentsastonapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResultListener
import com.buranchikov.fragmentsastonapp.databinding.FragmentCBinding

class FragmentC : Fragment() {
    private lateinit var binding: FragmentCBinding
    private val FRAG_REQUEST = "request"
    private val HELLO = "hello_frag_C"
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        val fragmentD = FragmentD()
        setFragmentResultListener(FRAG_REQUEST) { _, bundle ->
            binding.tvMsgC.text = bundle.getString(HELLO)
        }
        binding.btnCtoA.setOnClickListener {
            parentFragmentManager.popBackStack("toFrag_A", 0)
        }
        binding.btnCtoD.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, fragmentD)
                .addToBackStack("toFrag_D").commit()
        }
    }
}