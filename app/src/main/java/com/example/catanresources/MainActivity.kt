package com.example.catanresources

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //find button to push to run app
        val button: Button = findViewById(R.id.button)

        //what happens when the button is clicked
        button.setOnClickListener{randomize()}

    }
    private fun randomize(){
        // create a hexagon resource
        val hexagon= Resource()
        // randomize the hexagon
        val hexagonPick = hexagon.pick()
        /* find text to change */
        val resultTextView: TextView = findViewById(R.id.textView)
        //change textview text based on hexagonPick
        resultTextView.text = hexagonPick.toString()
        //find image to change
        val resultImage: ImageView = findViewById(R.id.imageView2)
        //change image picture based on hexagonPick
        val drawableImage = when (hexagonPick){
            "Stone" -> (R.drawable.st)
            "Wood" -> (R.drawable.wo)
            "Sheep" -> (R.drawable.sh)
            "Brick" -> (R.drawable.br)
            "Trade" -> (R.drawable.tr)
            "None"  -> (R.drawable.no)
            else  -> (R.drawable.ch)
        }
        resultImage.setImageResource(drawableImage)

        //Toast pop up based on hexagon resource
        val resultToast = when (hexagonPick){
            "Stone" -> "Pick a Stone Resource"
            "Wood" -> "Pick a Wood Resource"
            "Sheep" -> "Pick a Sheep Resource"
            "Brick" -> "Pick a Brick Resource"
            "Trade" -> "Option to Trade. Cannot trade without rolling Trade."
            "None"  -> "No Resource"
            else  -> "Pick one of any Resource. Your Choice!"
        }
        val toast = Toast.makeText(this, "${resultToast}", Toast.LENGTH_SHORT)
        toast.show()
    }
}


//a class to pick a random resource out of a pile
class Resource{
    fun pick():String{

        return arrayOf("Stone", "Wood", "Sheep", "Brick", "Trade", "None", "Any", "Stone", "Wood", "Sheep", "Brick", "Trade", "None", "None", "None", "None", "None", "None", "None", "None", "None", "Trade", "Trade", "Trade").random()
    }
}