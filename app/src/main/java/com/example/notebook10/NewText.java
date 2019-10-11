package com.example.notebook10;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.feezu.liuli.timeselector.TimeSelector;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NewText extends AppCompatActivity {

    private TextView t_time;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return  true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.fanhui:
                Toast.makeText(NewText.this,"返回",Toast.LENGTH_SHORT).show();
                finish();
                break;
            default:
                break;
        }
        return true;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_text);

        ActionBar act= getSupportActionBar();//隐藏顶部标题
        act.hide();//隐藏顶部标题

        init();
        initData();
    }
    private void initData() {
        t_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Date date = new Date();
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm");
                String format1 = format.format(date);
                TimeSelector timeSelector = new TimeSelector(NewText.this, new TimeSelector.ResultHandler() {
                    @Override
                    public void handle(String time) {
                        t_time.setText(time);
                    }
                }, format1, "2050-1-1 24:00");
                timeSelector.show();

            }
        });
    }//时间选择器

    private void init() {
        t_time = (TextView) findViewById(R.id.t_time);
    }
}
