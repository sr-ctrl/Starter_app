package com.example.starterapp.Tip_Calculator

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings.Global.getString
import android.util.Log
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import com.example.starterapp.R
import com.example.starterapp.databinding.ActivityTipCalculatorBinding
import java.text.NumberFormat
import kotlin.jvm.internal.Intrinsics

class Tip_Calculator_activity : AppCompatActivity() {
    private lateinit var binding:ActivityTipCalculatorBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_tip_calculator)

        binding.tipCalculate.setOnClickListener {
            calculateTip()
        }
         fun handleKeyEvent(view: View, keyCode: Int): Boolean {
            if (keyCode == KeyEvent.KEYCODE_ENTER) {
                // Hide the keyboard
                val inputMethodManager =
                    getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
                return true
            }
            return false}

    }

    private fun calculateTip() {
        val et_text_fieled = binding.etServiceCost.text.toString()
        val cost = et_text_fieled.toDoubleOrNull()

        if (cost == null){
            binding.ResultTip.text = "Please Give Tip"
            return }

        val tipPercentage = when (binding.radioGroup.checkedRadioButtonId){
            R.id.r_amazing -> 0.2
            R.id.r_good -> 0.18
            else -> 0.15
        }

        var Tip = tipPercentage * cost
        var RoundUp = binding.switchRoundup.isChecked
        if (RoundUp){
            Tip = kotlin.math.ceil(Tip)
        }
        val formatedTip = NumberFormat.getCurrencyInstance().format(Tip)
        Log.i("tip", "$formatedTip: ")
        binding.ResultTip.text = "Total Tip Amount $formatedTip"

    }
}