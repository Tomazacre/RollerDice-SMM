package net.ivanvega.mirollera

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var btnDice: Button
    lateinit var lblSuma: TextView
    lateinit var auxImgU: ImageView
    lateinit var auxImgD: ImageView

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_roller)

        lblSuma = findViewById(R.id.lblSaludo)
        btnDice = findViewById(R.id.btnRoller)
        auxImgU = findViewById(R.id.imgRoller)
        auxImgD = findViewById(R.id.imgRoller2)

        auxImgU.setImageDrawable(resources.getDrawable(R.drawable.dice_1))
        auxImgD.setImageDrawable(resources.getDrawable(R.drawable.dice_1))

        btnDice.setOnClickListener {
            val al = diceRoller()
            val el = diceRoller()

            Toast.makeText(
                applicationContext,
                "La suma de los valores es ->" + (al+el),
                Toast.LENGTH_LONG
            ).show()

            auxImgU.setImageResource(imageRoller(al))
            auxImgD.setImageResource(imageRoller(el))
            lblSuma.text = ("Resultado -> " + (al+el))
        }
    }
    var n: Int =diceRoller()
        private fun diceRoller(): Int {
        return (1..6).random()
    }
    private fun imageRoller(n:Int):Int{
        return when (n) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> R.drawable.empty_dice
        }
    }

}