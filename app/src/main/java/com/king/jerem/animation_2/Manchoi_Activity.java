package com.king.jerem.animation_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.king.jerem.animation_2.Adapter.Adapter_manchoi;
import com.king.jerem.animation_2.ClassOject.ManChoi;

import java.util.ArrayList;
import java.util.List;

public class Manchoi_Activity extends AppCompatActivity {
RecyclerView recycleManChoi;
    RecyclerView.LayoutManager layoutManager;
    List<ManChoi>dsmanchoi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manchoi_);
        recycleManChoi=findViewById(R.id.recycleManChoi);
        dsmanchoi=new ArrayList<>();
        themdata();
        RecyclerView.LayoutManager layoutManager=new GridLayoutManager(this,2);
        Adapter_manchoi adapter_manchoi=new Adapter_manchoi(this,dsmanchoi);
        recycleManChoi.setLayoutManager(layoutManager);
        recycleManChoi.setAdapter(adapter_manchoi);
        adapter_manchoi.notifyDataSetChanged();

    }

    private void themdata() {
        ManChoi manChoi1=new ManChoi("Stockholm",9000,null,R.drawable.background1,true,100,500,R.drawable.bac1);
        ManChoi manChoi2=new ManChoi("Germany",9000,null,R.drawable.background2,true,100,500,R.drawable.bac2);
        ManChoi manChoi3=new ManChoi("New york City",8000,null,R.drawable.background3,true,100,500,R.drawable.bac3);
        ManChoi manChoi4=new ManChoi("Amazon jungle",8000,null,R.drawable.background4,false,100,500,R.drawable.bac4);
        ManChoi manChoi5=new ManChoi("Mexico",7000,null,R.drawable.background5,false,150,1000,R.drawable.bac5);
        ManChoi manChoi6=new ManChoi("CAMBODIA",7000,null,R.drawable.background6,false,150,1000,R.drawable.bac6);
        ManChoi manChoi7=new ManChoi("Chile",6000,null,R.drawable.background7,false,150,1200,R.drawable.bac7);

        ManChoi manChoi9=new ManChoi("China",6000,null,R.drawable.background9,false,150,1500,R.drawable.bac9);
        ManChoi manChoi10=new ManChoi("ICELAND",5000,null,R.drawable.background10,false,200,2000,R.drawable.bac10);
        ManChoi manChoi11=new ManChoi("AFGHANISTAN",5000,null,R.drawable.background11,false,200,2000,R.drawable.bac11);
        ManChoi manChoi12=new ManChoi("Egypt",4000,null,R.drawable.background12,false,200,2000,R.drawable.bac12);
        ManChoi manChoi13=new ManChoi("BRITISH",4000,null,R.drawable.background13,false,200,2000,R.drawable.bac13);
        ManChoi manChoi14=new ManChoi("JAPAN",4000,null,R.drawable.background14,false,200,2000,R.drawable.bac14);
        ManChoi manChoi15=new ManChoi("BRAZIL",3000,null,R.drawable.background15,false,200,2000,R.drawable.bac15);
        ManChoi manChoi16=new ManChoi("Viet Nam",3000,null,R.drawable.background16,false,500,5000,R.drawable.bac16);
        ManChoi manChoi17=new ManChoi("North Korean",2000,null,R.drawable.background17,false,500,5000,R.drawable.bac17);
        ManChoi manChoi8=new ManChoi("PANAMA",2000,null,R.drawable.background8,false,500,5000,R.drawable.bac8);
        ManChoi manChoi18=new ManChoi("JAMAICA",2000,null,R.drawable.background18,false,500,5000,R.drawable.bac18);
        ManChoi manChoi19=new ManChoi("Amtesdam",2000,null,R.drawable.background19,false,500,5000,R.drawable.bac19);
        ManChoi manChoi20=new ManChoi("Hymalaya",2000,null,getResources().getIdentifier("background20", "drawable", getPackageName()),false,500,5000,R.drawable.bac20);

        ManChoi manChoi21=new ManChoi("Netherlands",2000,null,R.drawable.background21,false,500,5000,R.drawable.bac21);

        ManChoi manChoi22=new ManChoi("Russia",2000,null,R.drawable.background22,false,500,5000,R.drawable.bac22);

        ManChoi manChoi23=new ManChoi("Pacific Ocean",2000,null,R.drawable.background23,false,500,5000,R.drawable.bac23);

        ManChoi manChoi24=new ManChoi("Sahara Desert",2000,null,R.drawable.background24,false,500,5000,R.drawable.bac24);

        ManChoi manChoi25=new ManChoi("Hawaii",2000,null,R.drawable.background25,false,500,5000,R.drawable.bac25);


        dsmanchoi.add(manChoi2);
        dsmanchoi.add(manChoi1);
        dsmanchoi.add(manChoi3);
        dsmanchoi.add(manChoi4);
        dsmanchoi.add(manChoi5);
        dsmanchoi.add(manChoi6);
        dsmanchoi.add(manChoi7);

        dsmanchoi.add(manChoi9); dsmanchoi.add(manChoi10); dsmanchoi.add(manChoi11); dsmanchoi.add(manChoi12);
        dsmanchoi.add(manChoi13);
        dsmanchoi.add(manChoi14);
        dsmanchoi.add(manChoi15);
        dsmanchoi.add(manChoi16);
        dsmanchoi.add(manChoi18);
        dsmanchoi.add(manChoi17); dsmanchoi.add(manChoi8); dsmanchoi.add(manChoi25);
        dsmanchoi.add(manChoi19); dsmanchoi.add(manChoi20); dsmanchoi.add(manChoi21); dsmanchoi.add(manChoi22); dsmanchoi.add(manChoi23); dsmanchoi.add(manChoi24);



    }
}
