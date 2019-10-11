package com.example.notebook10;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SetEvent extends AppCompatActivity {

    public static int ID=0;

    private EditText ettheme;
    private EditText ettype;
    private EditText ettime;
    private EditText etcontent;
    private Button btfinish;
    private Button btswitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new2);

        ettheme = findViewById(R.id.new2_theme);
        ettype = findViewById(R.id.new2_type);
        ettime = findViewById(R.id.new2_time);
        etcontent = findViewById(R.id.new2_content);
        btfinish = findViewById(R.id.new2_finish);
        btswitch = findViewById(R.id.new2_switch);

        btfinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String theme=ettheme.getText().toString();
                String time=ettime.getText().toString();//Integer.parseInt(etpage.getText().toString());
                String type=ettype.getText().toString();
                String content =etcontent.getText().toString(); //Float.valueOf(etprice.getText().toString());

                Event event = new Event();
                event.setId(ID++);
                event.setTheme(theme);
                event.setType(type);
                event.setTimes(time);
                event.setContent(content);
                event.save();

//                Intent intent = new Intent();
//                intent.putExtra("data_return","Set_Already");
//                setResult(RESULT_OK,intent);
                //活动间返回数据的尝试
                finish();
            }
        });

        btswitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SetEvent.this, NewText.class);
                startActivity(intent);
            }
        });
    }
}
