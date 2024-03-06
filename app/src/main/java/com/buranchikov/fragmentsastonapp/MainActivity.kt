package com.buranchikov.fragmentsastonapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.buranchikov.fragmentsastonapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val fragmentManager = supportFragmentManager
    private val fragmentA:FragmentA = FragmentA()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()
        fragmentManager.beginTransaction().replace(
            R.id.fragmentContainerView,
            fragmentA)
            .addToBackStack("toFrag_A")
            .commit()
    }
}