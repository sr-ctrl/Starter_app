package com.example.starterapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.starterapp.databinding.FragmentWelcomBinding

class Welcom_Fragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment using the data binding
       val binding:FragmentWelcomBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_welcom,container,false)

        return binding.root
    }

}