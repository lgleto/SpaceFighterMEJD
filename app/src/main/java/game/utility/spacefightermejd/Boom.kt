package game.utility.spacefightermejd

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory

/**
 * Created by lourencogomes on 22/02/18.
 */

class Boom(context: Context, screenWidth:Int, screenHeight:Int) {

    var bitmap: Bitmap? = null

    var x: Int = 0
    var y: Int = 0

    init {
        bitmap = BitmapFactory.decodeResource(context.resources, R.drawable.boom)
        x = -250
        y = -250
    }

}