package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val diceRoller : Button = findViewById(R.id.button)


        diceRoller.setOnClickListener{
            rollDice()
        }
        //Do a Dice roll when the app creates
        rollDice()
    }
//Roll the dice and update the screen with result
    private fun rollDice() {

        //create a new dice object with 6 sided and roll th dice
        val dice1 = Dice(6)
        // Create a new dice object wit 10 sided and roll the dice
        val dice2 = Dice(10)

        // Store a new random integer between 1 and 6 using using Dice function.
        val diceInttext = dice1.rollDice()

        // Find the Imageview in the layout.
        val dicedImage : ImageView = findViewById(R.id.imageView)

        // Fing th TextView in the layout
        val dicedText2 : TextView = findViewById(R.id.textView2)

        //Set random number to textview denoted as second dice roller
        dicedText2.text = (dice2.rollDice()).toString()

        //Finding correspond dice image of random number
        val drawableResource =  when (diceInttext){
           1 -> R.drawable.dice_1
           2 -> R.drawable.dice_2
           3 -> R.drawable.dice_3
           4 -> R.drawable.dice_4
           5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        //Set Correspond image as imageview
        dicedImage.setImageResource(drawableResource)

        //Set an description for imageview here the rolled number
        dicedImage.contentDescription = diceInttext.toString()
    }
}

class Dice (private val diseSides: Int){
    fun rollDice():Int{
        return (1..diseSides).random()
    }
}
