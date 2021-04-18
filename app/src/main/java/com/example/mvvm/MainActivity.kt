package com.example.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.example.mvvm.ViewModel.MainViewModel
import com.example.mvvm.adapters.VpFragmentAdapter
import com.google.android.material.bottomnavigation.BottomNavigationMenu
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.fragment_first.*
import kotlinx.android.synthetic.main.fragment_second.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = VpFragmentAdapter(this, 3)
        val viewPager = findViewById<ViewPager2>(R.id.vp_main)
        viewPager.adapter = adapter

        val bottomNav: BottomNavigationView = findViewById(R.id.bottom_nav)
        bottomNav.setOnNavigationItemSelectedListener {
            if (it.itemId == R.id.menu_add_or_subtract) {
                viewPager.setCurrentItem(0)
            } else if (it.itemId == R.id.menu_total) {
                viewPager.setCurrentItem(1)
            } else if (it.itemId == R.id.menu_print) {
                viewPager.setCurrentItem(2)
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