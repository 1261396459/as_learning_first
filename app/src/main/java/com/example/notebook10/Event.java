package com.example.notebook10;

import org.litepal.crud.LitePalSupport;


public class Event extends LitePalSupport {
    private int id;//序号
    private String theme;//主题
    private String type;//类型
    private String times;//时间
    private String content;//内容


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getType() {
        return type;
    }

    public void setType (String type){ this.type = type;}

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


}
