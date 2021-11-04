package com.example.starterapp.Extra

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.starterapp.data.MyName
import com.example.starterapp.R
import com.example.starterapp.databinding.ActivityLayoutBinding

class Layout_Activity : AppCompatActivity() {
    lateinit var binding :ActivityLayoutBinding

    private var myNameData: MyName = MyName()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_layout)

        binding.myNameClass = myNameData

        binding.btn.setOnClickListener {
            sendEtText()
            val hideSoftKeyboard = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            hideSoftKeyboard.hideSoftInputFromWindow(currentFocus?.windowToken, InputMethodManager.SHOW_FORCED)
        }
    }

    private fun sendEtText() {
        binding.apply {
            myNameClass?.etName = etName.text.toString()
//            val etText = etName.text

            invalidateAll()
            tvName.text = myNameClass?.etName
            etName.visibility = View.GONE
            btn.visibility = View.GONE
            tvName.visibility = View.VISIBLE
        }
    }

}