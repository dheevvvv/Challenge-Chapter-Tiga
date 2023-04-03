package com.example.challenge_chapter3_tanpanavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.challenge_chapter3_tanpanavigation.databinding.ActivityMainBinding

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragmentAbjad = FragmentAbjad()
        setCurrentFragment(fragmentAbjad)

    }


    private fun setCurrentFragment(fragment: Fragment): FragmentTransaction =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_holder, FragmentAbjad())
            commit()
        }

}