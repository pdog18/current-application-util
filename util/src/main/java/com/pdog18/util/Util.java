package com.pdog18.util;

import android.app.ActivityThread;
import android.app.Application;

public class Util {
    private static final Application CURRENT_APPLICATION = ActivityThread.currentApplication();

    public static Application getCurrentApplication() {
        return CURRENT_APPLICATION;
    }
}