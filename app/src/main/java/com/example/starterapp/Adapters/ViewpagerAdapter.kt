package com.example.starterapp.Adapters

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.starterapp.Fragment_one
import com.example.starterapp.Fragment_two
import com.example.starterapp.Recycler_view_Fragment
import com.example.starterapp.Welcom_Fragment

class ViewPagerAdapter(supportFragmentManager: FragmentManager,lifecycle: Lifecycle): FragmentStateAdapter(supportFragmentManager,lifecycle
) {
    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                Welcom_Fragment()
            }
            1 -> {
                Fragment_one()
            }
            2 -> {
                Fragment_two()
            }
            else -> {
                Recycler_view_Fragment()
            }
        }
    }
}