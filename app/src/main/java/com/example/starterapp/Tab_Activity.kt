package com.example.starterapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.core.view.iterator
import androidx.databinding.DataBindingUtil
import com.example.starterapp.Adapters.ViewpagerAdapter
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

        val adapter = ViewpagerAdapter(supportFragmentManager,lifecycle)
        binding.viewPage2.adapter = adapter
        binding.viewPage2.isUserInputEnabled = false
        binding.viewPage2.offscreenPageLimit = 3
        binding.apply {
            TabLayoutMediator(tabLayout,viewPage2,false,false){tab,position->
            when (position){
                0-> {
                    tab.text = "One"
                    tab.setIcon(R.drawable.ic_favorite)
                }
                1-> {
                    tab.text = "Two"
                    tab.setIcon(R.drawable.ic_person)
                }
                2->{
                    tab.text = "Three"
                    tab.setIcon(R.drawable.ic_call)
                }
                3->{
                    tab.text = "Four"
                    tab.setIcon(R.drawable.ic_recyclerview)
                }
            }
                val tabView = LayoutInflater.from(this@Tab_Activity)?.inflate(R.layout.tab_home,null) as View
                (tabView.findViewById(R.id.textView) as TextView?)?.text
                tab?.customView = tabView

        }.attach()

//            binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
//                override fun onTabSelected(tab: TabLayout.Tab?) {}
//                override fun onTabUnselected(tab: TabLayout.Tab?) {}
//                override fun onTabReselected(tab: TabLayout.Tab?) {}    })
        }
    }

}