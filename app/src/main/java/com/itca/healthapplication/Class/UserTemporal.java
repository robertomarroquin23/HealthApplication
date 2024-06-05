package com.itca.healthapplication.Class;

import android.app.Application;

public class UserTemporal extends Application {
    private String userTemporal;
    @Override
    public void onCreate() {
        super.onCreate();
    }

    public String getUserTemporal() {
        return userTemporal;
    }

    public void setUserTemporal(String userTemporal) {
        this.userTemporal = userTemporal;
    }
}
