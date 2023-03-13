package com.josh.sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton = findViewById<Button>(R.id.btnroll)
        rollButton.setOnClickListener {rollDice()}
        // do a roll when the app starts
        rollDice()
    }
    private fun rollDice(){
        //creating new dice objects with 6 sides and roll it
        val dice=Dice(6)
        val diceRoll = dice.roll()
        //find the image view in the layout
        val diceimage =findViewById<ImageView>(R.id.ivdice)
        //determine which drawableResource id to use based on the dice roll use
        val drawableResource = when(diceRoll){
            1 ->R.drawable.dice_1
            2 ->R.drawable.dice_2
            3 ->R.drawable.dice_3
            4 ->R.drawable.dice_4
            5 ->R.drawable.dice_5
            else -> R.drawable.dice_6


        }
        // update image view with the correct drawable resource id
        diceimage.setImageResource(drawableResource)
        //update the content description
        diceimage.contentDescription=diceRoll.toString()


    }
}