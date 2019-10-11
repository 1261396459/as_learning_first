package com.example.notebook10;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Title extends LinearLayout {

    public Title(Context context, AttributeSet attrs){
        super(context,attrs);
        LayoutInflater.from((context)).inflate(R.layout.activity_title,this);//建立自定义控件
        TextView Back=findViewById(R.id.tt_back);

        Back.setOnClickListener(new View.OnClickListener() {//点击按钮1触发点击事件
            @Override
            public void onClick(View v) {
                ((Activity)getContext()).finish();//销毁当前活动返回上一活动
            }
        });
    }
}
