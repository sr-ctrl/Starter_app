package com.example.starterapp.Roller_Dice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.starterapp.R
import com.example.starterapp.databinding.ActivityMainBinding
import kotlin.properties.Delegates
import kotlin.random.Random
import kotlin.random.nextInt

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var diceImage:ImageView
    var Random_dice_one by Delegates.notNull<Int>()
    var Random_dice_two by Delegates.notNull<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)


        binding.btnRoll.setOnClickListener {
            RollDiceOne()
            RollDiceTwo()
            totalScores()
            }
        }

    private fun totalScores() {
        binding.totalScore.text = (Random_dice_one+Random_dice_two).toString()
    }

    fun RollDiceOne() {
          Random_dice_one = Random.nextInt(1..6)
         binding.diceImage.setImageResource(setImageResources(Random_dice_one))
}

    fun RollDiceTwo(){
        Random_dice_two = Random.nextInt(1..6)
        binding.diceImage2.setImageResource(setImageResources(Random_dice_two))
    }

     fun setImageResources( dice_no:Int): Int {
         when(dice_no){
             1-> {
                return R.drawable.dice_1
             }
             2-> {
                return R.drawable.dice_2
             }
             3-> {
                return R.drawable.dice_3
             }
             4-> {
                return R.drawable.dice_4
             }
             5-> {
                 return R.drawable.dice_5
             }
             else -> {
                 return R.drawable.dice_6
             }
         }
     }

}