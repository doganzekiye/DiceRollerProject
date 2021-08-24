package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener {
            rollDice()
        }
    }
    private fun rollDice(){
        val diceImage: ImageView = findViewById(R.id.imageView_dice)
        val dice = Dice(6)
        val rolledDice = dice.roll()
        val drawableResource = when(rolledDice){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(drawableResource)
        diceImage.contentDescription = rolledDice.toString()
        checkLuckyNumber(rolledDice)
    }
    private fun checkLuckyNumber(rolledDice : Int){
        val luckyNumber = 3
        when(rolledDice){
            luckyNumber -> showMessage("You win!")
            1 -> showMessage("So sorry! You rolled a 1. Try again!")
            2 -> showMessage("Sadly, you rolled a 2. Try again!")
            4 -> showMessage("Unfortunately, you rolled a 4. Try again!")
            5 -> showMessage("Don't cry! You rolled a 5. Try again!")
            6 -> showMessage("Apologies! you rolled a 6. Try again!")
        }
    }

    private fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}

class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}