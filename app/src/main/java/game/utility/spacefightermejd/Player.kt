package game.utility.spacefightermejd

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory

/**
 * Created by lourencogomes on 10/02/18.
 */

class Player(context: Context, screenWidth:Int , screenHeight:Int) {

    var bitmap : Bitmap? =null

    var x : Int = 0
    var y : Int = 0

    var speed : Int = 0
    var boosting : Boolean = false
    val GRAVITY = -10
    var maxY = 0
    var minY = 0
    val MIN_SPEED = 1
    val MAX_SPEED = 20

    init {
        x = 75
        y = 50
        speed = 1
        bitmap = BitmapFactory.decodeResource(context.resources, R.drawable.player)

        maxY = screenHeight - bitmap!!.height
        minY = 0
    }

    public fun update() {
        if (boosting)speed += 2
        else speed -= 5
        if (speed > MAX_SPEED) speed=MAX_SPEED
        if (speed > MIN_SPEED) speed=MIN_SPEED

        y -= speed + GRAVITY

        if (y<minY) y=minY
        if (y>maxY) y=maxY

    }
}