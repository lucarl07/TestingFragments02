package com.example.testingfragments02

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.testingfragments02.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState); enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val firstFragment = FirstFragment()
        val secondFragment = SecondFragment()

        // Initialize the frame view with an already selected fragment:
        swapFragments(R.id.fl_fragment, firstFragment)

        binding.btnFragment01.setOnClickListener {
            swapFragments(R.id.fl_fragment, firstFragment)
        }
        binding.btnFragment02.setOnClickListener {
            swapFragments(R.id.fl_fragment, secondFragment)
        }
    }

    private fun swapFragments(frameView: Int, fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(frameView, fragment)
            addToBackStack(null)
            commit()
        }
    }
}