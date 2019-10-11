package com.example.notebook10;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.litepal.LitePal;


public class LogIn extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return  true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.fanhui:
                Toast.makeText(LogIn.this,"返回",Toast.LENGTH_SHORT).show();
                finish();
                break;
            default:
                break;
        }
        return true;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_in);

        ActionBar act= getSupportActionBar();//隐藏顶部标题
        act.hide();//隐藏顶部标题


        Button button = findViewById(R.id.log_in);
        TextView textView = findViewById(R.id.忘记密码);
        final EditText et1=findViewById(R.id.Account);
        final EditText et2=findViewById(R.id.Password);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //登录后跳转到首页
                String str1=et1.getText().toString();
                String str2=et2.getText().toString();
                if(str1.equals(str2)){
                    Intent intent = new Intent(LogIn.this, HomePage.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(LogIn.this,"帐号和密码不一致",Toast.LENGTH_LONG).show();
                }
            }
        });

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LogIn.this,"测试账号为2501314，密码为2501314",Toast.LENGTH_LONG).show();
            }
        });
    }
}
