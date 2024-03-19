package com.buranchikov.fragmentsastonapp

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResultListener
import com.buranchikov.fragmentsastonapp.databinding.FragmentCBinding

class FragmentC : Fragment() {
    private lateinit var binding: FragmentCBinding

    private lateinit var FRAG_REQUEST: String
    private lateinit var HELLO: String
    private lateinit var fragmentOperation: FragmentsOperationInterface
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCBinding.inflate(inflater, container, false)
        binding.tvMsgC.text = savedInstanceState?.getString(getString(R.string.keyBundleC))
        FRAG_REQUEST = getString(R.string.request)
        HELLO = getString(R.string.hello_frag_c)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        fragmentOperation.getCurrentFragment(
            parentFragmentManager.findFragmentById(R.id.fragmentContainerView),
            getString(R.string.tofrag_c)
        )
        val fragmentD = FragmentD()
        setFragmentResultListener(FRAG_REQUEST) { _, bundle ->
            binding.tvMsgC.text = bundle.getString(HELLO)
        }
        binding.btnCtoA.setOnClickListener {
            parentFragmentManager.popBackStack(getString(R.string.tofrag_a), 0)
        }
        binding.btnCtoD.setOnClickListener {
            fragmentOperation.showFragment(fragmentD, getString(R.string.tofrag_d))
        }
    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is FragmentsOperationInterface) {
            fragmentOperation = context
        }
    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(getString(R.string.keyBundleC), binding.tvMsgC.text.toString())
    }
}