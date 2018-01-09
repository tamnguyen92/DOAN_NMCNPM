package com.king.jerem.animation_2;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class MainKetQuaActivity extends AppCompatActivity implements View.OnClickListener {

    TextView txtwin,txtgoldd,txtexp;
    Button btndongy;
    Thread thread;
    Handler handler;
    int dem=0;
    int gold=0;
    int exp=0;
    int demexp=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_ket_qua);
        txtgoldd=findViewById(R.id.txtgoldd);
        txtexp=findViewById(R.id.txtexp);
        txtwin=findViewById(R.id.txtwin);
        btndongy=findViewById(R.id.btnbtn);
        btndongy.setOnClickListener(this);
        Intent intent=getIntent();
        gold=intent.getIntExtra("gold",0);
        exp=intent.getIntExtra("exp",0);

        if(gold<=0 && exp <=0)
        {
            txtwin.setText("GAME OVER");
            txtgoldd.setText(gold+"");
            txtexp.setText(exp+"");
        }
        else {

            txtwin.setText("WINNER");




            handler=new Handler(new Handler.Callback() {
                @Override
                public boolean handleMessage(Message message) {

                    if(dem<gold && gold>0)
                    {
                        dem=dem + message.what;
                        txtgoldd.setText(dem+"");
                    }

                    if(demexp<exp && exp>0)
                    {
                        demexp=demexp + 2;
                        txtexp.setText(demexp+"");
                    }
                    return false;
                }
            });

            Timer timer=new Timer();
            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    handler.sendEmptyMessage(1);
                }
            },100,100);
        }
        Toast.makeText(this,gold+"="+exp,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        Intent intent=new Intent(MainKetQuaActivity.this,MainActivity.class);
        startActivity(intent);
    }
}
