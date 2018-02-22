package game.utility.spacefightermejd

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Rect
import java.util.*

/**
 * Created by lourencogomes on 22/02/18.
 */
class Enemy(context: Context, screenWidth:Int, screenHeight:Int) {

    var bitmap: Bitmap? = null

    var x: Int = 0
    var y: Int = 0
    private var speed: Int = 0

    private var maxY = 0
    private var minY = 0
    private var maxX = 0
    private var minX = 0

    var detectCollision : Rect? = null

    init {
        bitmap = BitmapFactory.decodeResource(context.resources, R.drawable.enemy)

        maxX = screenWidth
        maxY = screenHeight
        minX = 0
        minY = 0

        var generator = Random();
        speed = generator.nextInt(6) + 10

        x = maxX
        y = generator.nextInt(maxY) - bitmap!!.height

        detectCollision = Rect(x,y,bitmap!!.width,bitmap!!.height)

    }

    public fun update(playerSpeed: Int) {

        x -= playerSpeed
        x -= speed

        if (x < minX - bitmap!!.width) {
            x = maxX
            var generator = Random();
            y = generator.nextInt(maxY) - bitmap!!.height
            speed = generator.nextInt(6) + 10
        }

        detectCollision?.left = x
        detectCollision?.top = y
        detectCollision?.right = x + bitmap!!.width
        detectCollision?.bottom = y + bitmap!!.height
    }

}