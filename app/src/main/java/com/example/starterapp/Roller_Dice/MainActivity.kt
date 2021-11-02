package com.example.starterapp.Roller_Dice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import com.example.starterapp.R
import com.example.starterapp.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var diceImage:ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.btnRoll.setOnClickListener {
           RollDice()
            }
        }

    private fun RollDice() {
        val Random_int = Random.nextInt(7)
         binding.diceImage.setImageResource(when(Random_int){
             1-> R.drawable.dice_1
             2-> R.drawable.dice_2
             3-> R.drawable.dice_3
             4-> R.drawable.dice_4
             5-> R.drawable.dice_5
             else -> R.drawable.dice_6
         })
}
}