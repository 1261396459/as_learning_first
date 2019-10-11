package com.example.notebook10;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import org.litepal.LitePal;

import java.util.ArrayList;
import java.util.List;

    public class HomePage extends AppCompatActivity {

        private List<Display> displayList = new ArrayList<>();
        private EditText inputText;
        private Button send;
        private RecyclerView displayRecyclerView;
        private DisplayAdapter adapter;

        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.home_page);
//        Intent intent = getIntent();//接收上个Intent
//        final int data = intent.getIntExtra("data_return",1);//接收上个Intent中key为"data_return"的数据

            ActionBar act = getSupportActionBar();//隐藏顶部标题
            act.hide();//隐藏顶部标题

            Button newEvent2 = findViewById(R.id.new_event2);
            newEvent2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(HomePage.this, SetEvent.class);
                    startActivityForResult(intent,1);
                }
            });//点击跳转到新建事件页面


            inputText = (EditText) findViewById(R.id.hp_et_input);
            inputText.setHint("功能未开放");
            send = findViewById(R.id.hp_bt_send);
            send.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    refreshDisplays();
                    Toast.makeText(HomePage.this,"Refresh Finish",Toast.LENGTH_SHORT).show();
                }
            });//帮助刷新

            LitePal.getDatabase();//创建数据库
            displayRecyclerView = (RecyclerView) findViewById(R.id.hp_rv_show);
            displayRecyclerView.setLayoutManager(new LinearLayoutManager(this));
            displayRecyclerView.setAdapter(new DisplayAdapter(displayList));
            //配置recyclerview
            initDisplays();//初始化

        }

//    @Override
//    protected void onActivityResult(int requestCode,int resultCode,Intent data){
//        String returnedData = data.getStringExtra("data_return");
//        //if(requestCode == RESULT_OK)
//                if(returnedData == "Set_Already"){
//                    refreshDisplays();
//        }
//    }//活动间传递数据的尝试

        private void initDisplays() {//将litepal中的内容分配到recyclerview中并显示
            List<Event> events = LitePal.findAll(Event.class);
            for (Event event : events) {
                Display display = new Display(event.getContent());
                displayList.add(display);
                display.setID(event.getId());
                //adapter.notifyItemInserted(displayList.size()-1); // 当有新消息时， 刷新RecyclerView中的显示
                displayRecyclerView.scrollToPosition(displayList.size() - 1); // 将 RecyclerView定位到最后一行
            }
        }

        private void refreshDisplays() {//更新recyclerview中的内容
            displayList.clear();
            List<Event> events = LitePal.findAll(Event.class);
            for (Event event : events) {
                Display display = new Display(event.getContent());
                displayList.add(display);
                display.setID(event.getId());
                //adapter.notifyItemInserted(displayList.size()-1); // 当有新消息时， 刷新RecyclerView中的显示
                displayRecyclerView.scrollToPosition(displayList.size() - 1); // 将 RecyclerView定位到最后一行
            }
        }
    }


