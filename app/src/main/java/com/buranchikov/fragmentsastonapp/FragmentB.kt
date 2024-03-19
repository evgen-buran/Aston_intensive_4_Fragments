package com.buranchikov.fragmentsastonapp

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResult
import com.buranchikov.fragmentsastonapp.databinding.FragmentBBinding

class FragmentB : Fragment() {
    private lateinit var FRAG_REQUEST: String
    private lateinit var HELLO: String
    private lateinit var binding: FragmentBBinding
    private lateinit var fragmentOperation:FragmentsOperationInterface

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBBinding.inflate(inflater)

        FRAG_REQUEST = getString(R.string.request)
        HELLO = getString(R.string.hello_frag_c)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        fragmentOperation.getCurrentFragment(parentFragmentManager.findFragmentById(R.id.fragmentContainerView), getString(R.string.tofrag_b))
        val fragmentC = FragmentC()
        binding.btnBtoA.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
        binding.btnBtoC.setOnClickListener {
            val bundle = Bundle()
            bundle.putString(HELLO, getString(R.string.hello_fragment_c))
            setFragmentResult(FRAG_REQUEST, bundle)
           fragmentOperation.showFragment(fragmentC, getString(R.string.tofrag_c))
        }
    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is FragmentsOperationInterface) {
            fragmentOperation = context
        }
    }
}