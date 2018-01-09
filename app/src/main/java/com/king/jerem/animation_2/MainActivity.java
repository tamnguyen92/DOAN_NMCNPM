package com.king.jerem.animation_2;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
Button btnrun,btnstop,btnjumb,btnslide;
ImageView imageView,ivCity;
AnimationDrawable animationDrawable;
TextView txtthangthua;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnrun=findViewById(R.id.btnrun);
        btnstop=findViewById(R.id.btnstop);
        btnjumb=findViewById(R.id.btnjumb);
        btnslide=findViewById(R.id.btnslide);
        btnslide.setOnClickListener(this);
        btnjumb.setOnClickListener(this);
        btnrun.setOnClickListener(this);
        btnstop.setOnClickListener(this);
        txtthangthua=findViewById(R.id.txtthangthua);

        String k=txtthangthua.getText().toString();
         doimau(k);



    }

    private void doimau(String text) {
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View view) {

            }

            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                int color = ContextCompat.getColor(MainActivity.this, R.color.colorPrimary);
                ds.setColor(color);
                ds.setUnderlineText(false);
            }
        };

// initialize a new SpannableStringBuilder instance
        SpannableStringBuilder ssBuilder = new SpannableStringBuilder(text);

// apply the clickable text to the span
        ssBuilder.setSpan(
                clickableSpan, // span to add
                text.indexOf("TH"), // start of the span (inclusive)
                text.indexOf("TH") + String.valueOf("TH").length(), // end of the span (exclusive)
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE // do not extend the span when text add later
        );

// underline
        ssBuilder.setSpan(
                new UnderlineSpan(),
                text.indexOf("UA"),
                text.indexOf("UA") + String.valueOf("UA").length(),
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        );

// bold
        ssBuilder.setSpan(
                new StyleSpan(Typeface.BOLD),
                text.indexOf("UA"),
                text.indexOf("UA") + String.valueOf("UA").length(),
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        );

        txtthangthua.setText(ssBuilder);

// this step is mandated for the url and clickable styles
        txtthangthua.setMovementMethod(LinkMovementMethod.getInstance());
        txtthangthua.setHighlightColor(Color.TRANSPARENT);
    }

    public  int getScreenWidth()
    {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;
        return width;
    }

void addresource(int ten,ImageView imageView)
{
    if(animationDrawable!=null)
    {
        animationDrawable=null;
    }

    imageView.setBackgroundResource(ten);
    animationDrawable= (AnimationDrawable) imageView.getBackground();
}
    @Override
    public void onClick(View view) {
        int id=view.getId();
        switch (id)
        {
            case R.id.btnrun:
                addresource(R.drawable.hinh_cua_tui,imageView);
                animationDrawable.start();
                break;
            case R.id.btnstop:
                animationDrawable.stop();
                break;
            case R.id.btnjumb:
               Intent intentmanchoi=new Intent(this,Manchoi_Activity.class);
               startActivity(intentmanchoi);
                break;
            case R.id.btnslide:
                Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
        }
    }
}
