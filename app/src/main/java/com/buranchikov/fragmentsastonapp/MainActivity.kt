package com.buranchikov.fragmentsastonapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.buranchikov.fragmentsastonapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), FragmentsOperationInterface {
    private lateinit var binding: ActivityMainBinding
    private val fragmentManager = supportFragmentManager
    private val fragmentA: FragmentA = FragmentA()
    private var currentFragment: Fragment = fragmentA
    private var currentTag: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()
        if (currentTag == "") currentTag = getString(R.string.tofrag_a)
            showFragment(currentFragment, currentTag)

    }

    override fun showFragment(fragment: Fragment, tagBackStack: String) {
        fragmentManager.beginTransaction().replace(
            R.id.fragmentContainerView,
            fragment
        )
            .addToBackStack(tagBackStack)
            .commit()
    }

    override fun getCurrentFragment(currentFragment: Fragment?, tag: String) {
        currentFragment?.let { this.currentFragment = currentFragment }
        currentTag = tag
    }
}


