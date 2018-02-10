package game.utility.spacefightermejd

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var imageButton : ImageButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(R.layout.activity_main)

        imageButton = findViewById(R.id.imageButton)
        imageButton?.setOnClickListener{
            val intent = Intent(this, GameActivity().javaClass )
            startActivity(intent)

        }
    }

}
