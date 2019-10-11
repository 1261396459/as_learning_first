package com.example.notebook10;


import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class DisplayAdapter extends RecyclerView.Adapter<DisplayAdapter.DisplayViewHolder> {
    private List<Display> mDisplayList;

    static class DisplayViewHolder extends RecyclerView.ViewHolder{
        LinearLayout layout;
        TextView textview;
        View eventView;

        public DisplayViewHolder(View view) {
            super(view);
            eventView = view ;//整个recycleview单元
            layout = view.findViewById(R.id.di_ll);//内部部件
            textview = view.findViewById(R.id.di_tv);//内部部件

        }
    }

    public DisplayAdapter(List<Display> displayList){
        mDisplayList = displayList;
    }

    @Override
    public DisplayViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.display_item, parent, false);
        final DisplayViewHolder holder = new DisplayViewHolder(view);
        holder.eventView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Display display = mDisplayList.get(position);//对于单个view的对象
                Intent intent = new Intent(v.getContext(),EditEvent.class);//指定跳转的起点和终点
                intent.putExtra("extra_data",display.getId());//向下一个活动传输信息

                Toast.makeText(v.getContext(),"id="+display.getId(),Toast.LENGTH_SHORT).show();
                v.getContext().startActivity(intent);//开始跳转
                //Activity activity = (Activity)v.getContext();
                //activity.startActivityForResult();

            }
        });
        return holder;

    }


    public void onBindViewHolder(DisplayViewHolder holder, int position) {
        Display display= mDisplayList.get(position);//position为list编号。从0开始
        holder.textview.setText(display.getContent());

    }

    @Override
    public int getItemCount() {
        return mDisplayList.size();
    }
}
