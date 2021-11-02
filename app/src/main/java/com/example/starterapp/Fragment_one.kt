/*
 * Copyright 2018, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.starterapp

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import com.example.starterapp.data.Data_class
import com.example.starterapp.databinding.FragmetOneBinding

class Fragment_one : Fragment() {
        private var data:Data_class = Data_class()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding:FragmetOneBinding = DataBindingUtil.inflate(layoutInflater,R.layout.fragmet_one,container,false)

      binding.dataClass = data

        binding.apply {
            sendBtn.setOnClickListener {
                val result = Bundle()
                dataClass?.et_text_one= etText1.text.toString()
                val input = dataClass?.et_text_one.toString()
                result.putString("data",input)
                setFragmentResult("DataKey", result)
                Log.i("message", "$result")
            }
        }

        return binding.root
    }
}
