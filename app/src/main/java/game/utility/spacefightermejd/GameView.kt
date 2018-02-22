package game.utility.spacefightermejd

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.os.Handler
import android.util.Log
import android.view.MotionEvent
import android.view.SurfaceHolder
import android.view.SurfaceView
import java.util.ArrayList

/**
 * Created by lourencogomes on 10/02/18.
 */
class GameView: SurfaceView , Runnable {

    var playing : Boolean = false
    var gameThread : Thread? = null

    var player: Player? = null
    var stars : MutableList<Star> = ArrayList<Star>()
    var enemies : MutableList<Enemy> = ArrayList<Enemy>()
    var boom: Boom? = null

    var paint: Paint? =null
    var canvas: Canvas? =null

    var screenWidth : Int = 0
    var screenHeight : Int = 0

    var surfaceHolder: SurfaceHolder? = null

    constructor(context:Context, width:Int, height: Int) : super(context) {

        screenWidth=width
        screenHeight=height

        player= Player(context, screenWidth, screenHeight)
        surfaceHolder=holder
        paint= Paint()

        for (i in 0..99){
            val s = Star(context, screenWidth, screenHeight)
            stars.add(s)
        }

        for (i in 0..2){
            val e = Enemy(context, screenWidth, screenHeight)
            enemies.add(e)
        }

        boom = Boom(context, screenWidth, screenHeight)
    }

    override fun run() {
        while (playing){
            update()
            draw()
            control()
        }
    }

    private fun update(){
        player?.update()

        boom?.x = -250
        boom?.y = -250

        for (s in stars ){
            s.update(player!!.speed)
        }
        for (e in enemies ){
            e.update(player!!.speed)

            if (Rect.intersects(player?.detectCollision,e.detectCollision)){

                boom?.x=e.x
                boom?.y=e.y

                e.x = -200
            }
        }


    }

    private fun draw(){

        if (surfaceHolder?.surface!!.isValid){
            canvas = surfaceHolder?.lockCanvas()
            canvas?.drawColor(Color.BLACK)


            paint?.setColor(Color.WHITE)
            for (s in stars ){
                paint?.strokeWidth = s.getStarWidth()
                canvas?.drawPoint( s.x.toFloat(), s.y.toFloat(), paint)
            }

            for (e in enemies ){
                canvas?.drawBitmap(e?.bitmap, e?.x!!.toFloat(),e?.y!!.toFloat(),paint)

            }


            canvas?.drawBitmap(boom?.bitmap, boom?.x!!.toFloat(),boom?.y!!.toFloat(),paint)

            canvas?.drawBitmap(player?.bitmap, player?.x!!.toFloat(),player?.y!!.toFloat(),paint)


            surfaceHolder?.unlockCanvasAndPost(canvas)
        }

    }

    private fun control(){
        Thread.sleep(17)
    }

    public fun resume(){
        playing=true
        gameThread= Thread(this)
        gameThread?.start()
    }

    public fun pause(){
        playing=false
        gameThread?.join()
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when (event?.action!!.and(MotionEvent.ACTION_MASK)){

            MotionEvent.ACTION_UP -> {
                Log.d("spacefightermejd","ACTION_UP")
                player?.boosting = false
            }
            MotionEvent.ACTION_DOWN -> {
                Log.d("spacefightermejd","ACTION_DOWN")
                player?.boosting = true
            }
            else ->{

            }
        }
        return true
    }
}