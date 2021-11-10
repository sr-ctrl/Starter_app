package com.example.starterapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.iterator
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.starterapp.Adapters.ViewPagerAdapter
import com.example.starterapp.databinding.ActivityTabBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_tab.*
import kotlinx.android.synthetic.main.tab_home.*

class Tab_Activity : AppCompatActivity() {
    private lateinit var binding:ActivityTabBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =DataBindingUtil.setContentView(this,R.layout.activity_tab)
        setupTab()
    }

    private fun setupTab() {
        binding.viewPager.adapter = ViewPagerAdapter(supportFragmentManager,lifecycle)
        binding.viewPager.isUserInputEnabled = false
        binding.viewPager.offscreenPageLimit = 4
        TabLayoutMediator(
            binding.tabLayout, binding.viewPager, false, false
        ) { tab, position ->
            val tabView =
                LayoutInflater.from(this@Tab_Activity)
                    .inflate(R.layout.tab_home, null) as View
            val titleResId = setTitleNTabIconId(position)
            (tabView.findViewById(R.id.textView_tab) as TextView).text = titleResId[0]
            (tabView.findViewById(R.id.imageView_tab) as ImageView).setImageResource(titleResId[1].toInt())
            tab.customView = tabView
        }.attach()
    }

    private fun setTitleNTabIconId(position: Int): Array<String> {
        when (position) {
            0 -> {
                return arrayOf(getString(R.string.home), R.drawable.home.toString())
            }
            1 -> {
                return arrayOf(getString(R.string.search), R.drawable.search.toString())
            }
            2 -> {
                return arrayOf(
                    getString(R.string.message),
                    R.drawable.message.toString()
                )
            }
            else -> {
                return arrayOf(getString(R.string.settings), R.drawable.settings.toString()
                )
            }

        }
    }

}