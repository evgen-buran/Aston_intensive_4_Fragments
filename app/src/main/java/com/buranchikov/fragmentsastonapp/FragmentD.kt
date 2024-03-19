package com.buranchikov.fragmentsastonapp

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.buranchikov.fragmentsastonapp.databinding.FragmentDBinding

class FragmentD : Fragment() {
    private lateinit var binding: FragmentDBinding
    private lateinit var fragmentOperation:FragmentsOperationInterface
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        fragmentOperation.getCurrentFragment(parentFragmentManager.findFragmentById(R.id.fragmentContainerView), getString(R.string.tofrag_d))
        binding.btnDtoB.setOnClickListener {
            parentFragmentManager.popBackStack(getString(R.string.tofrag_b), 0)
        }
    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is FragmentsOperationInterface) {
            fragmentOperation = context
        }
    }
}