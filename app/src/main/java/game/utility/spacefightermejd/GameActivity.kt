package game.utility.spacefightermejd

import android.graphics.Point
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Display
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

/**
 * Created by lourencogomes on 10/02/18.
 */

class GameActivity : AppCompatActivity() {

    var gameView: GameView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var display: Display = windowManager.defaultDisplay
        val point = Point()
        display.getSize(point)

        gameView = GameView(this, point.x, point.y)
        setContentView(gameView)
    }

    override fun onResume() {
        super.onResume()
        gameView?.resume()
    }

    override fun onPause() {
        super.onPause()
        gameView?.pause()
    }


}