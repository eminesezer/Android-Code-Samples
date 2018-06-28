package com.example.eminesezer.sessiondenemesi;

import android.app.Application;

public class SessionClass extends Application {
    private String username;
    private String info;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
