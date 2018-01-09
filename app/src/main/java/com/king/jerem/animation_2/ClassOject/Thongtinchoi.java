package com.king.jerem.animation_2.ClassOject;

import android.widget.ImageView;

/**
 * Created by jerem on 07/01/2018.
 */

public class Thongtinchoi {
    int gold;
    int exp;
    ImageView imageView;
    public Thongtinchoi(ImageView imageView) {
        this.imageView=imageView;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }
}
