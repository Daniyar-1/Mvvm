package com.example.mvvm.adapters

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.mvvm.ui.FirstFragment
import com.example.mvvm.ui.SecondFragment
import com.example.mvvm.ui.ThirdFragment
import com.google.android.material.bottomnavigation.BottomNavigationMenu

class VpFragmentAdapter(activity: AppCompatActivity, val itemsCount: Int) :
    FragmentStateAdapter(activity) {

    override fun getItemCount(): Int {
        return itemsCount
    }


    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> FirstFragment()
            1 -> SecondFragment()
            2 -> ThirdFragment()
            else -> Fragment()
        }
    }


}