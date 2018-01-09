package com.king.jerem.animation_2.ClassOject;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.akexorcist.roundcornerprogressbar.IconRoundCornerProgressBar;
import com.king.jerem.animation_2.GamePanel;
import com.king.jerem.animation_2.Main2Activity;
import com.king.jerem.animation_2.MainActivity;
import com.king.jerem.animation_2.MainKetQuaActivity;
import com.king.jerem.animation_2.R;

/**
 * Created by jerem on 07/01/2018.
 */

public class ProgressBarAnimation extends Animation {
    private IconRoundCornerProgressBar progressBar;
    private float from;
    private float  to;
    Context context;
    Thongtinchoi thongtinchoi;
    AnimationDrawable animationDrawable;
    ImageView imageView,imgviewdich;
    GamePanel gamePanel;
    int k;

    public float getFrom() {
        return from;
    }

    public void setFrom(float from) {
        this.from = from;
    }

    public float getTo() {
        return to;
    }

    public void setTo(float to) {
        this.to = to;
    }

    public ProgressBarAnimation(IconRoundCornerProgressBar progressBar, float from, float to, Context context, AnimationDrawable animationDrawable,
                                ImageView imageView, int k, Thongtinchoi thongtinchoi, ImageView imgdich, GamePanel gamePanel) {
        super();
        this.progressBar = progressBar;
        this.from = from;
        this.to = to;
        this.gamePanel=gamePanel;
        this.context=context;
        this.thongtinchoi=thongtinchoi;
        this.imageView=imageView;
        this.animationDrawable=animationDrawable;
        this.imgviewdich=imgdich;
        this.k=k;
    }


    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        super.applyTransformation(interpolatedTime, t);
        if(k==0)
        {
            if(progressBar.getProgress()<1)
            {

                if(animationDrawable!=null)
                {
                    animationDrawable.stop();
                    animationDrawable=null;

                    imageView.setBackgroundResource(R.drawable.jumb_drawable);
                    animationDrawable= (AnimationDrawable) imageView.getBackground();
                    animationDrawable.start();
                }

                Intent intent=new Intent(context, MainKetQuaActivity.class);
                if(thongtinchoi!=null)
                {
                    intent.putExtra("gold",0);
                    intent.putExtra("exp",0);

                }

                context.startActivity(intent);
                ((Main2Activity)context).finish();
///                gamePanel.thread.stop();
                Log.d("dung thread", "applyTransformation: ");
                this.cancel();
            }
        }
        else
        {
            if(progressBar.getProgress()== 98)
            {
                imgviewdich.setVisibility(View.VISIBLE);
                //thongtinchoi.getImageView().setVisibility(View.INVISIBLE);
            }
            if(progressBar.getProgress()==99)
            {
                Intent intent=new Intent(context, MainKetQuaActivity.class);
                if(thongtinchoi!=null)
                {
                    intent.putExtra("gold",thongtinchoi.getGold());
                    intent.putExtra("exp",thongtinchoi.getExp());

                }


                context.startActivity(intent);
                ((Main2Activity)context).finish();
               // gamePanel.thread.stop();
                this.cancel();
            }


        }

        float value = from + (to - from) * interpolatedTime;
        progressBar.setProgress((int) value);


    }
}
