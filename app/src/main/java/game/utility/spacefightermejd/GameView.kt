package game.utility.spacefightermejd

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Handler
import android.util.Log
import android.view.MotionEvent
import android.view.SurfaceHolder
import android.view.SurfaceView

/**
 * Created by lourencogomes on 10/02/18.
 */
class GameView: SurfaceView , Runnable {

    var playing : Boolean = false
    var gameThread : Thread? = null

    var player: Player? = null

    var paint: Paint? =null
    var canvas: Canvas? =null

    var screenWidth : Int = 0
    var screenHeight : Int = 0

    var surfaceHolder: SurfaceHolder? = null

    constructor(context:Context, width:Int, height: Int) : super(context) {

        screenHeight=width
        screenHeight=height

        player= Player(context, screenWidth, screenHeight)
        surfaceHolder=holder
        paint= Paint()


        Log.d("spacefightermejd","helloconsr" )

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
    }

    private fun draw(){

        if (surfaceHolder?.surface!!.isValid){
            canvas = surfaceHolder?.lockCanvas()
            canvas?.drawColor(Color.RED)
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
        //Log.d("spacefightermejd","helloconsr" +event.toString())
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

                //Log.d("spacefightermejd","helloconsr" +event.toString())
            }
        }
        return true
    }
}