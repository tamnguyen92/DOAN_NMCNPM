package com.king.jerem.animation_2;

import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * Created by jerem on 04/01/2018.
 */

public class Backgrounds {
    private Bitmap image;
    private int x, y, dx;

    public Backgrounds(Bitmap res)
    {
        image = res;
    }
    public void update()
    {
        x+=dx;
        if(x<=-(GamePanel.WIDTH-35)){
            x=x+GamePanel.WIDTH-35;
        }
    }
    public void draw(Canvas canvas)
    {
        canvas.drawBitmap(image, x, y,null);
        if(x<0)
        {
            canvas.drawBitmap(image, x+GamePanel.WIDTH, y, null);
        }
    }
    public void setVector(int dx)
    {
        this.dx = dx;
    }

}
