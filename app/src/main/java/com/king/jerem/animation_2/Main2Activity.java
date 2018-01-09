package com.king.jerem.animation_2;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.os.Message;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.akexorcist.roundcornerprogressbar.IconRoundCornerProgressBar;
import com.akexorcist.roundcornerprogressbar.RoundCornerProgressBar;
import com.king.jerem.animation_2.ClassOject.ProgressBarAnimation;
import com.king.jerem.animation_2.ClassOject.Thongtinchoi;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener{
    Button btnrun;
    Animation animationhinh;
    TextView txtDoanvan,txtgold,txtvanban;
   Button btnQ,btnW,btnE,btnR,btnT,btnY,btnU,btnI,btnO,btnP,btnA,btnS,btnD,btnF,btnG,btnH,btnJ,btnK,btnL,btnZ,btnX,btnC,btnV,btnB,btnN,btnM,btnSpace;
    IconRoundCornerProgressBar progress2,progressBar;
    GamePanel gamePanel;
    AnimationDrawable animationDrawable;
    ImageView imageView,imageViewđichen;
    FrameLayout frameLayout;
    List<Button>dsbutton;
    List<String>dsbaivan;
    Random rd;
    int gold=0;
    int exp=100;
    int xulyhientai=100;
    int time=7000;
    int dokho=8000;
    ProgressBarAnimation anim,anim1;
    int mahinh=R.drawable.background1;
    Thongtinchoi thongtinchoi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main2);
        Intent intentmanchoi=getIntent();
        if(intentmanchoi!=null)
        {
            exp=intentmanchoi.getIntExtra("expmanchoi",0);
            dokho=intentmanchoi.getIntExtra("dokho",0);
            mahinh=intentmanchoi.getIntExtra("mahinh",0);



        }
        addcontroll();

        gamePanel=findViewById(R.id.panel);

        if(mahinh==0)
        {
             mahinh=R.drawable.background1;
        }
        if(exp==0)
        {
            exp=100;
        }
        if(dokho==0)
        {
            dokho=10000;
        }
        Log.d("ma hinh",mahinh+"");
        gamePanel.layout=mahinh;
        addresource(R.drawable.hinh_cua_tui,imageView);
        animationDrawable.start();
        doimau(txtvanban.getText().toString(),txtvanban);
        txtvanban.setVisibility(View.GONE);
        addProgressbar();



    }

    private void addProgressbar() {
        progress2.setMax(100);
        progress2.setProgress(100);



        addEvent();
        animationhinh = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.animation_scale);
        animationhinh.setRepeatCount(Animation.INFINITE);
        imageViewđichen.setAnimation(animationhinh);

        anim = new ProgressBarAnimation(progress2, 100, 0,this,animationDrawable,imageView,0,thongtinchoi,imageViewđichen,gamePanel);
        anim.setDuration(dokho);
        progress2.startAnimation(anim);

        anim1 = new ProgressBarAnimation(progressBar, 0, 100,this,animationDrawable,imageView,1,thongtinchoi,imageViewđichen,gamePanel);
        anim1.setDuration(40000);
        // anim.setRepeatCount(anim.INFINITE);
        progressBar.startAnimation(anim1);
    }

    private void addEvent() {
        btnQ.setOnClickListener(this);
        btnW.setOnClickListener(this);btnE.setOnClickListener(this);btnR.setOnClickListener(this);btnT.setOnClickListener(this);
        btnY.setOnClickListener(this);btnU.setOnClickListener(this);btnI.setOnClickListener(this);btnO.setOnClickListener(this);
        btnP.setOnClickListener(this);btnA.setOnClickListener(this);btnS.setOnClickListener(this);btnD.setOnClickListener(this);
        btnF.setOnClickListener(this);btnG.setOnClickListener(this);btnH.setOnClickListener(this);btnJ.setOnClickListener(this);
        btnK.setOnClickListener(this);btnL.setOnClickListener(this);btnZ.setOnClickListener(this);btnX.setOnClickListener(this);
        btnC.setOnClickListener(this);btnV.setOnClickListener(this);btnB.setOnClickListener(this);btnN.setOnClickListener(this);
        btnM.setOnClickListener(this);btnSpace.setOnClickListener(this);
    }



    private void addcontroll() {
        addBaiVan();
        rd=new Random();
        txtDoanvan=findViewById(R.id.txtdoanvan);
        int r=rd.nextInt(dsbaivan.size());

        txtDoanvan.setText(dsbaivan.get(r).trim());

        thongtinchoi=new Thongtinchoi(imageViewđichen);
        thongtinchoi.setGold(0);
        thongtinchoi.setExp(0);
        txtgold=findViewById(R.id.txtgold);
        frameLayout=findViewById(R.id.frame);
       imageViewđichen=findViewById(R.id.imgdichden);

        imageView=findViewById(R.id.imageView1);

        progress2 = findViewById(R.id.progress_1);
        txtvanban=findViewById(R.id.txtvanban);
        progressBar=findViewById(R.id.progress_2);
        btnQ=findViewById(R.id.btnQ);btnW=findViewById(R.id.btnW);btnE=findViewById(R.id.btnE);btnR=findViewById(R.id.btnR);
        btnT=findViewById(R.id.btnT);btnY=findViewById(R.id.btnY);btnU=findViewById(R.id.btnU);btnI=findViewById(R.id.btnI);
        btnO=findViewById(R.id.btnO);btnP=findViewById(R.id.btnP);btnA=findViewById(R.id.btnA);btnS=findViewById(R.id.btnS);
        btnD=findViewById(R.id.btnD);btnF=findViewById(R.id.btnF);btnG=findViewById(R.id.btnG);btnH=findViewById(R.id.btnH);
        btnZ=findViewById(R.id.btnZ);btnL=findViewById(R.id.btnL);btnK=findViewById(R.id.btnK);btnJ=findViewById(R.id.btnJ);
        btnX=findViewById(R.id.btnX);btnC=findViewById(R.id.btnC);btnV=findViewById(R.id.btnV);btnB=findViewById(R.id.btnB);
        btnN=findViewById(R.id.btnN);btnM=findViewById(R.id.btnM);btnSpace=findViewById(R.id.btnSpace);
        dsbutton=new ArrayList<>();
        dsbutton.add(btnQ);dsbutton.add(btnW);dsbutton.add(btnE);dsbutton.add(btnR);dsbutton.add(btnT);dsbutton.add(btnY);
        dsbutton.add(btnU);dsbutton.add(btnI);dsbutton.add(btnO);dsbutton.add(btnP);dsbutton.add(btnA);dsbutton.add(btnS);
        dsbutton.add(btnD);dsbutton.add(btnF);dsbutton.add(btnG);dsbutton.add(btnZ);dsbutton.add(btnL);dsbutton.add(btnK);
        dsbutton.add(btnJ);dsbutton.add(btnX);dsbutton.add(btnC);dsbutton.add(btnV);dsbutton.add(btnB);dsbutton.add(btnN);
        dsbutton.add(btnM);dsbutton.add(btnSpace);

    }

    private void addBaiVan() {
        dsbaivan=new ArrayList<>();
        dsbaivan.add("behold beheld beheld ngam nhin");
        dsbaivan.add("arise arose arisen phat sinh");
        dsbaivan.add("awake awoke awoken danh thuc");
        dsbaivan.add("become became become tro nen");
        dsbaivan.add("bespeak bespoke bespoken chung to");
        dsbaivan.add("forgive forgave forgiven tha thu");
        dsbaivan.add("forsake forsook forsaken ruong bo");
        dsbaivan.add("freeze froze frozen lam lanh");
        dsbaivan.add("know knew known quen biet");
        dsbaivan.add("mislay mislaid mislaid de lac mat");
        dsbaivan.add("misspell misspelt misspelt viet sai chinh ta");
        dsbaivan.add("misunderstand misunderstood misunderstood hieu lam");
        dsbaivan.add("see saw seen nhin thay");
        dsbaivan.add("stand stood stood dung");
        dsbaivan.add("swim swam swum boi loi");
        dsbaivan.add("understand understood understood hieu");
        dsbaivan.add("write wrote written viet");
        dsbaivan.add("think thought thought suy nghi");
        dsbaivan.add("teach taught taught giang day");
    }

    private void hoanvi2button()
    {
        for(int i=0;i<5;i++)
        {

            int j=rd.nextInt(dsbutton.size());
            int k=rd.nextInt(dsbutton.size());
            String text=dsbutton.get(j).getText().toString();
            dsbutton.get(j).setText(dsbutton.get(k).getText().toString());
            dsbutton.get(k).setText(text);

        }
    }
    private void randomHienButton()
    {
        for(int i=0;i<12;i++)
        {

            int j=rd.nextInt(dsbutton.size());
            dsbutton.get(j).setTextColor(Color.parseColor("#212121"));
        }
    }
    private void randomButton() {
        for(int i=0;i<20;i++)
        {

            int j=rd.nextInt(dsbutton.size());
            dsbutton.get(j).setTextColor(Color.parseColor("#00FFFFFF"));
        }


    }

    void addresource(int ten,ImageView imageView)
    {
        imageView.setBackgroundResource(ten);
        animationDrawable= (AnimationDrawable) imageView.getBackground();
    }

    void kiemtradoanvan(String s)
    {
        if(txtDoanvan.getText().toString()!=null && txtDoanvan.getText().toString().length()>0)
        {
            char[] m=txtDoanvan.getText().toString().toCharArray();
            String n=String.valueOf(m[0]);

            if(s.compareToIgnoreCase(n)==0)
            {
                String k=txtDoanvan.getText().toString();
                StringBuilder sB= new StringBuilder(k);

                Log.d("mau chu",n+"     "+k);
                //doimau(k,txtDoanvan);

                sB.deleteCharAt(0);
                if(txtDoanvan.getText().toString().length()==1)
                {
                    if(dokho<=4000)
                    {
                        randomButton();
                        randomHienButton();
                    }
                    else if(dokho<=7000 && dokho>4000)
                    {
                        hoanvi2button();
                    }

                    gold++;
                    txtgold.setText(gold+"");
                    thongtinchoi.setGold(gold);
                    thongtinchoi.setExp(exp);

                    txtDoanvan.setText(sB.toString());

                    int r=rd.nextInt(dsbaivan.size());

                    txtDoanvan.setText(dsbaivan.get(r).trim());


                    int b= (int) progress2.getProgress();

                    anim = new ProgressBarAnimation(progress2, b+1, 0,this,animationDrawable,imageView,0,thongtinchoi,imageViewđichen,gamePanel);
                    anim.setDuration(dokho);
                   // anim.setRepeatCount(anim.INFINITE);
                    progress2.startAnimation(anim);
                    progress2.setProgress(b);
                }
                else {
                    if(dokho<5000)
                    {
                        randomButton();
                        randomHienButton();
                    }
                    else if(dokho<=7000 && dokho>4000)
                    {
                        hoanvi2button();
                    }
                    gold++;
                    txtgold.setText(gold+"");
                    thongtinchoi.setGold(gold);
                    thongtinchoi.setExp(100);
                    int l= (int) progress2.getProgress();
                   //anim.setFrom(50);

                    anim = new ProgressBarAnimation(progress2, l+5, 0,this,animationDrawable,imageView,0,thongtinchoi,imageViewđichen,gamePanel);
                    anim.setDuration(dokho);
                   // anim.setRepeatCount(anim.INFINITE);
                    progress2.startAnimation(anim);
                   // progress2.setProgress(l);
                    txtDoanvan.setText(sB.toString());
                }


            }
        }



    }
    private void doimau(String text,TextView textView) {
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View view) {

            }

            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                int color = ContextCompat.getColor(Main2Activity.this, R.color.colorPrimary);
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

        textView.setText(ssBuilder);

// this step is mandated for the url and clickable styles
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setHighlightColor(Color.TRANSPARENT);
    }
    @Override
    public void onClick(View view) {
        int id=view.getId();
        switch (id)
        {
//            case R.id.btnrun:
//
//                break;
            case R.id.btnQ:



                if(txtDoanvan.getText().toString()!=null)
                {
                    kiemtradoanvan(btnQ.getText().toString());
                }

                break;
            case R.id.btnW:

                if(txtDoanvan.getText().toString()!=null)
                {
                    kiemtradoanvan(btnW.getText().toString());
                }

                break;
            case R.id.btnE:

                if(txtDoanvan.getText().toString()!=null)
                {
                    kiemtradoanvan(btnE.getText().toString());
                }

                break;
            case R.id.btnR:

                if(txtDoanvan.getText().toString()!=null)
                {
                    kiemtradoanvan(btnR.getText().toString());
                }

                break;
            case R.id.btnT:

                if(txtDoanvan.getText().toString()!=null)
                {
                    kiemtradoanvan(btnT.getText().toString());
                }

                break;
            case R.id.btnY:

                if(txtDoanvan.getText().toString()!=null)
                {
                    kiemtradoanvan(btnY.getText().toString());
                }

                break;
            case R.id.btnU:

                if(txtDoanvan.getText().toString()!=null)
                {
                    kiemtradoanvan(btnU.getText().toString());
                }

                break;
            case R.id.btnI:

                if(txtDoanvan.getText().toString()!=null)
                {
                    kiemtradoanvan(btnI.getText().toString());
                }

                break;
            case R.id.btnO:

                if(txtDoanvan.getText().toString()!=null)
                {
                    kiemtradoanvan(btnO.getText().toString());
                }

                break;
            case R.id.btnP:

                if(txtDoanvan.getText().toString()!=null)
                {
                    kiemtradoanvan(btnP.getText().toString());
                }

                break;
            case R.id.btnA:

                if(txtDoanvan.getText().toString()!=null)
                {
                    kiemtradoanvan(btnA.getText().toString());
                }

                break;
            case R.id.btnS:

                if(txtDoanvan.getText().toString()!=null)
                {
                    kiemtradoanvan(btnS.getText().toString());
                }

                break;
            case R.id.btnD:

                if(txtDoanvan.getText().toString()!=null)
                {
                    kiemtradoanvan(btnD.getText().toString());
                }

                break;
            case R.id.btnF:

                if(txtDoanvan.getText().toString()!=null)
                {
                    kiemtradoanvan(btnF.getText().toString());
                }

                break;
            case R.id.btnG:

                if(txtDoanvan.getText().toString()!=null)
                {
                    kiemtradoanvan(btnG.getText().toString());
                }

                break;
            case R.id.btnH:

                if(txtDoanvan.getText().toString()!=null)
                {
                    kiemtradoanvan(btnH.getText().toString());
                }

                break;
            case R.id.btnJ:

                if(txtDoanvan.getText().toString()!=null)
                {
                    kiemtradoanvan(btnJ.getText().toString());
                }

                break;
            case R.id.btnK:

                if(txtDoanvan.getText().toString()!=null)
                {
                    kiemtradoanvan(btnK.getText().toString());
                }

                break;
            case R.id.btnL:

                if(txtDoanvan.getText().toString()!=null)
                {
                    kiemtradoanvan(btnL.getText().toString());
                }

                break;
            case R.id.btnZ:

                if(txtDoanvan.getText().toString()!=null)
                {
                    kiemtradoanvan(btnZ.getText().toString());
                }

                break;
            case R.id.btnX:

                if(txtDoanvan.getText().toString()!=null)
                {
                    kiemtradoanvan(btnX.getText().toString());
                }

                break;
            case R.id.btnC:

                if(txtDoanvan.getText().toString()!=null)
                {
                    kiemtradoanvan(btnC.getText().toString());
                }

                break;
            case R.id.btnV:

                if(txtDoanvan.getText().toString()!=null)
                {
                    kiemtradoanvan(btnV.getText().toString());
                }

                break;
            case R.id.btnB:

                if(txtDoanvan.getText().toString()!=null)
                {
                    kiemtradoanvan(btnB.getText().toString());
                }

                break;
            case R.id.btnN:

                if(txtDoanvan.getText().toString()!=null)
                {
                    kiemtradoanvan(btnN.getText().toString());
                }

                break;
            case R.id.btnM:

                if(txtDoanvan.getText().toString()!=null)
                {
                    kiemtradoanvan(btnM.getText().toString());
                }

                break;
            case R.id.btnSpace:

                if(txtDoanvan.getText().toString()!=null)
                {
                    kiemtradoanvan(" ");
                }

                break;


        }

    }
}
