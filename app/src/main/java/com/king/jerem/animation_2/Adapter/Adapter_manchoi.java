package com.king.jerem.animation_2.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.king.jerem.animation_2.ClassOject.ManChoi;
import com.king.jerem.animation_2.Main2Activity;
import com.king.jerem.animation_2.Manchoi_Activity;
import com.king.jerem.animation_2.R;

import java.util.List;

/**
 * Created by jerem on 08/01/2018.
 */

public class Adapter_manchoi extends RecyclerView.Adapter<Adapter_manchoi.ViewHolderManchoi> {
    Context context; List<ManChoi>dsmanchoi;

    public Adapter_manchoi(Context context, List<ManChoi>dsmanchoi) {
        this.context=context;
        this.dsmanchoi=dsmanchoi;
    }

    @Override
    public ViewHolderManchoi onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=inflater.inflate(R.layout.customlayout_manchoi,parent,false);
        ViewHolderManchoi viewHolder=new ViewHolderManchoi(view);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(ViewHolderManchoi holder, int position) {
        final ManChoi manChoi=dsmanchoi.get(position);

        if (manChoi.isUnclock())
        {
            holder.frameunclock.setVisibility(View.INVISIBLE);
        }
        else {
            holder.frameunclock.setVisibility(View.VISIBLE);
        }
        holder.imghinh.setBackgroundResource(manChoi.getMahinhbac());
        holder.txttenmanchoi.setText(manChoi.getTenman());
        holder.txtexpunclock.setText("UNCLOCK "+manChoi.getExpunclock()+"EXP");
        holder.framemanchoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,manChoi.getTenman(),Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(context, Main2Activity.class);

                intent.putExtra("mahinh",manChoi.getMahinh());
                intent.putExtra("dokho",manChoi.getDokho());
                intent.putExtra("expmanchoi",manChoi.getExp());

                context.startActivity(intent);
                ((Manchoi_Activity)context).finish();


            }
        });

    }

    @Override
    public int getItemCount() {
        return dsmanchoi.size();
    }

    public class ViewHolderManchoi extends RecyclerView.ViewHolder {
        ImageView imghinh;
        TextView txttenmanchoi,txtexpunclock;
        FrameLayout frameunclock,framemanchoi;
        public ViewHolderManchoi(View itemView) {
            super(itemView);
            imghinh=itemView.findViewById(R.id.imghinhmanchoi);
            txttenmanchoi=itemView.findViewById(R.id.txttenmanchoi);
            txtexpunclock=itemView.findViewById(R.id.txtexpunclock);
            frameunclock=itemView.findViewById(R.id.frameunclock);
            framemanchoi=itemView.findViewById(R.id.framemanchoi);
        }
    }
}
