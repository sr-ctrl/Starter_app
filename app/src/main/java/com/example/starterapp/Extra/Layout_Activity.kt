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

        binding.myNameClass = myNameData                //myNameClass is variable name we mentioned in the Layout File// In layout and activity file we call variable by this name with . oprator
                                                        //myNameData is variable we created and assign the data class to it, remember to call class with constructor ()
        binding.btn.setOnClickListener {
            sendEtText()
            val InsvKeyPad = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            InsvKeyPad.hideSoftInputFromWindow(currentFocus?.windowToken, InputMethodManager.SHOW_FORCED)
        }
    }

    private fun sendEtText() {
        binding.apply {
            myNameClass?.etName = etName.text.toString()
//            val etText = etName.text
            // in order to refresh data we need to invalidate all binding expression (binding.) so they can recreated with right data
            invalidateAll() // it will invalidate and check all the view we access throught the binding. oprator
            tvName.text = myNameClass?.etName
            etName.visibility = View.GONE
            btn.visibility = View.GONE
            tvName.visibility = View.VISIBLE
        }
//        val InsvKeyPad = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
//        InsvKeyPad.hideSoftInputFromWindow(currentFocus?.windowToken, InputMethodManager.SHOW_FORCED)
    }

}