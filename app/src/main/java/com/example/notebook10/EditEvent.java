package com.example.notebook10;

import android.content.ContentValues;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import org.litepal.LitePal;



public class EditEvent extends AppCompatActivity {

    private EditText ettheme;
    private EditText ettype;
    private EditText ettime;
    private EditText etcontent;
    private Button btfinish;
    private Button btdelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_event);
        Intent intent = getIntent();//接收上个Intent
        final int data = intent.getIntExtra("extra_data",1);//接收上个Intent中key为"extra_data"的数据


        ettheme = findViewById(R.id.edit_event_theme);
        ettype = findViewById(R.id.edit_event_type);
        ettime = findViewById(R.id.edit_event_time);
        etcontent = findViewById(R.id.edit_event_content);
        btfinish = findViewById(R.id.edit_event_finish_edit);
        btdelete = findViewById(R.id.edit_event_delete_event);

        initDisplays(data);//初始化，编辑框内显示原来的信息

        btfinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//更新数据
                String theme=ettheme.getText().toString();
                String time=ettime.getText().toString();//Integer.parseInt(etpage.getText().toString());
                String type=ettype.getText().toString();
                String content =etcontent.getText().toString(); //Float.valueOf(etprice.getText().toString());

                ContentValues values = new ContentValues();
                values.put("theme", theme);
                LitePal.update(Event.class,values,data);
                values.put("times", time);
                LitePal.update(Event.class,values,data);
                values.put("type", type);
                LitePal.update(Event.class,values,data);
                values.put("content", content);
                LitePal.update(Event.class,values,data);
                //更新数据库中的值

                Intent intent = new Intent(EditEvent.this,HomePage.class);
                //intent.putExtra("data_return", "updata already");//传递数据                //活动间返回数据的尝试
                startActivity(intent);
                //finish();//销毁活动
            }
        });

        btdelete.setOnClickListener(new View.OnClickListener() {//删除功能
            @Override
            public void onClick(View v) {
                LitePal.delete(Event.class,data);//删除条件

                Intent intent = new Intent(EditEvent.this,HomePage.class);
                //intent.putExtra("data_return", "delete already");//传递数据                //活动间返回数据的尝试
                startActivity(intent);
                //finish();//销毁活动
            }
        });
    }

    private void initDisplays(int id) {
        Event event = LitePal.find(Event.class,id);
        ettheme.setText(event.getTheme());
        ettime.setText(event.getTimes());
        ettype.setText(event.getType());
        etcontent.setText(event.getContent());
    }
}
