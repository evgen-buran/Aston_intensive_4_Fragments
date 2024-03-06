package com.buranchikov.fragmentsastonapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResult
import com.buranchikov.fragmentsastonapp.databinding.FragmentBBinding

class FragmentB : Fragment() {
    private val FRAG_REQUEST = "request"
    private val HELLO = "hello_frag_C"
    private lateinit var binding: FragmentBBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBBinding.inflate(inflater)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        val fragmentC = FragmentC()
        binding.btnBtoA.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
        binding.btnBtoC.setOnClickListener {
            val bundle = Bundle()
            bundle.putString(HELLO, getString(R.string.hello_fragment_c))
            setFragmentResult(FRAG_REQUEST, bundle)
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, fragmentC)
                .addToBackStack("toFrag_C").commit()
        }
    }
}