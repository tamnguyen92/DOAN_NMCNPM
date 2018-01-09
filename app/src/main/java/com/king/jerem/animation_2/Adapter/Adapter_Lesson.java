package com.king.jerem.animation_2.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jerem on 06/01/2018.
 */

public class Adapter_Lesson extends RecyclerView.Adapter<Adapter_Lesson.ViewHolder> {
    Context context;
    int layout;
    List<String>dsbanphim;

    public Adapter_Lesson(Context context, int layout) {
        this.context=context;
        this.layout=layout;
        dsbanphim=new ArrayList<String>();
        dsbanphim.add("Q");dsbanphim.add("W");dsbanphim.add("E");dsbanphim.add("R");dsbanphim.add("T");dsbanphim.add("Y");dsbanphim.add("U");
        dsbanphim.add("I");dsbanphim.add("O");dsbanphim.add("P");dsbanphim.add("A");dsbanphim.add("S");dsbanphim.add("D");dsbanphim.add("F");
        dsbanphim.add("G");dsbanphim.add("H");dsbanphim.add("J");dsbanphim.add("K");dsbanphim.add("L");dsbanphim.add("Z");dsbanphim.add("X");
        dsbanphim.add("C");dsbanphim.add("V");dsbanphim.add("B");dsbanphim.add("N");dsbanphim.add("M");dsbanphim.add("Q");dsbanphim.add("Q");
        dsbanphim.add("Q");dsbanphim.add("Q");dsbanphim.add("Q");dsbanphim.add("Q");dsbanphim.add("Q");dsbanphim.add("Q");dsbanphim.add("Q");

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
