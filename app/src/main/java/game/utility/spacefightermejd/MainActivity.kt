package game.utility.spacefightermejd

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var textViewHello : TextView? = null
    var buttonTranslate : Button? = null
    var linearLayout : LinearLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        textViewHello = TextView(this)
        textViewHello!!.setText("Olá mundo")

        buttonTranslate = Button(this)
        buttonTranslate!!.setText("Traduzir")
        buttonTranslate!!.setOnClickListener {
            textViewHello?.setText("Hello World")
        }

        linearLayout = LinearLayout(this)
        linearLayout!!.addView(textViewHello)
        linearLayout!!.addView(buttonTranslate)


        setContentView(linearLayout)


        //setContentView(R.layout.activity_main)
    }

}
