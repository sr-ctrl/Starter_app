package com.example.starterapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.starterapp.Adapters.RecyclerView_Adapter
import com.example.starterapp.Adapters.RecyclerView_Adapter.Companion.item_a
import com.example.starterapp.Adapters.RecyclerView_Adapter.Companion.item_b
import com.example.starterapp.databinding.RecyclerViewFragmentBinding


class Recycler_view_Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment using the data binding
        val binding:RecyclerViewFragmentBinding = DataBindingUtil.
                                inflate(layoutInflater,R.layout.recycler_view_fragment,container,false)

        val listviewType: List<Int> = mutableListOf(item_a,item_b,item_a,item_b,
                item_a,item_b,item_a,item_b,item_a,item_b,item_a,item_b,item_a,item_b,item_a,item_b,item_a,item_b,)

        binding.testRecycler.adapter = RecyclerView_Adapter(listViewType = listviewType)
        return binding.root
    }

}