package com.king.jerem.animation_2;

import android.graphics.Canvas;
import android.util.Log;
import android.view.SurfaceHolder;

import com.akexorcist.roundcornerprogressbar.IconRoundCornerProgressBar;
import com.king.jerem.animation_2.GamePanel;

import java.util.logging.Handler;

public class MainThread extends Thread
{
    private int FPS = 30;
    private double averageFPS;
    private SurfaceHolder surfaceHolder;
    private GamePanel gamePanel;
    private boolean running;
    public static Canvas canvas;
    IconRoundCornerProgressBar progress2;
    android.os.Handler handler;
    int xulyhientai;

    public MainThread( IconRoundCornerProgressBar progress2,
            android.os.Handler handler,int xulihientai)
    {
        super();
        this.progress2 = progress2;
        this.handler = handler;
        this.xulyhientai=xulihientai;
        Log.d("handleeeeee", "handleMessage: ");
    }
    public MainThread(SurfaceHolder surfaceHolder, GamePanel gamePanel)
    {
        super();
        this.surfaceHolder = surfaceHolder;
        this.gamePanel = gamePanel;

    }
    public void run2()
    {
        while (xulyhientai>0)
        {
            xulyhientai= (int) progress2.getProgress();
            handler.sendEmptyMessage(xulyhientai);

        }
        try {
            this.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
this.start();
    }
    @Override
    public void run()
    {

        long startTime;
        long timeMillis;
        long waitTime;
        long totalTime = 0;
        int frameCount =0;
        long targetTime = 1000/FPS;

        while(running) {


            startTime = System.nanoTime();
            canvas = null;

            //try locking the canvas for pixel editing
            try {
                canvas = this.surfaceHolder.lockCanvas();
                synchronized (surfaceHolder) {
                    this.gamePanel.update();
                    this.gamePanel.draw(canvas);
                }
            } catch (Exception e) {
            }
            finally{
                if(canvas!=null)
                {
                    try {
                        surfaceHolder.unlockCanvasAndPost(canvas);
                    }
                    catch(Exception e){e.printStackTrace();}
                }
            }




            timeMillis = (System.nanoTime() - startTime) / 1000000;
            waitTime = targetTime-timeMillis;

            try{
                this.sleep(waitTime);
            }catch(Exception e){}

            totalTime += System.nanoTime()-startTime;
            frameCount++;
            if(frameCount == FPS)
            {
                averageFPS = 1000/((totalTime/frameCount)/1000000);
                frameCount =0;
                totalTime = 0;

            }
//            while (xulyhientai!=0)
//            {
//            if()
//                Log.d("handleeeeee", "handleMessage: ");
//                xulyhientai= (int) progress2.getProgress();
//                handler.sendEmptyMessage(xulyhientai);
////
////            }


        }
    }
    public void setRunning(boolean b)
    {
        running=b;
    }
}