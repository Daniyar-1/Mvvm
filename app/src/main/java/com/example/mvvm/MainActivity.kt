package com.example.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.mvvm.adapters.VpFragmentAdapter
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_first.*
import kotlinx.android.synthetic.main.fragment_second.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = VpFragmentAdapter(this, 3)
        val viewPager = vp_main
        viewPager.adapter = adapter

        val bottomNav: BottomNavigationView = findViewById(R.id.bottom_nav)
        bottomNav.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.menu_add_or_subtract -> {
                    viewPager.currentItem = 0
                }
                R.id.menu_total -> {
                    viewPager.currentItem = 1
                }
                R.id.menu_print -> {
                    viewPager.currentItem = 2
                }
            }
            return@setOnNavigationItemSelectedListener true
        }
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                when (position) {
                    0 -> {
                        bottomNav.menu.findItem(R.id.menu_add_or_subtract).isChecked = true
                    }
                    1 -> {
                        bottomNav.menu.findItem(R.id.menu_total).isChecked = true
                    }
                    2 -> {
                        bottomNav.menu.findItem(R.id.menu_print).isChecked = true
                    }
                }
            }
        })
    }
}