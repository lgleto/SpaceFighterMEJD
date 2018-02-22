package game.utility.spacefightermejd

import android.content.Context
import java.util.*

/**
 * Created by lourencogomes on 22/02/18.
 */


class Star(context: Context, screenWidth:Int, screenHeight:Int) {

    var x : Int = 0
    var y : Int = 0
    private var speed : Int = 0

    private var maxY = 0
    private var minY = 0
    private var maxX = 0
    private var minX = 0

    init {
        maxX = screenWidth
        maxY = screenHeight
        minX = 0
        minY = 0

        var generator = Random();
        speed=generator.nextInt(10)

        x = generator.nextInt(maxX)
        y = generator.nextInt(maxY)
    }

    public fun update(playerSpeed: Int) {

        x -= playerSpeed
        x -= speed

        if (x<0){
            x = maxX
            var generator = Random();
            y = generator.nextInt(maxY)
            speed=generator.nextInt(10)
        }
    }

    public fun getStarWidth () : Float {
        var generator = Random();
        return generator.nextFloat()*4.0f
    }
}